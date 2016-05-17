package com.game.world;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.game.entities.Entity;
import com.game.entities.Static;
import com.heat.engine.graphics.camera.Camera;
import com.heat.engine.graphics.image.Texture;
import com.heat.engine.graphics.image.TextureCollection;
import com.heat.engine.graphics.image.TextureLoader;
import com.heat.engine.io.FileUtils;

public class World {

	private String id = "undefined";
	private String name = "undefined";

	private TextureCollection assets = new TextureCollection();

	/**
	 * ArrayList of all entities loaded in this world.
	 */
	private ArrayList<Entity> entities = new ArrayList<>();

	/**
	 * Adds an entity to the world.
	 */
	public void addEntity(Entity entity) {
		entities.add(entity);
	}

	/**
	 * Returns an entity.
	 */
	public Entity getEntity(int index) {
		return entities.get(index);
	}

	/**
	 * Returns the amount of loaded entities.
	 */
	public int getNumEntities() {
		return entities.size();
	}

	public World(String path, String assetsPath) {

		assets = TextureLoader.loadTextureSheet(assetsPath);

		load(path);

	}

	public void tick() {

	}

	public void draw(Camera camera) {
		for (Entity e : entities) {
			e.draw(camera);
		}
	}

	/**
	 * Returns the attribute value from an element.
	 */
	private String getAttributeValue(Element e, String tag) {
		try {
			return e.getAttributeValue(tag);
		} catch (Exception exception) {
		}
		return null;
	}

	/**
	 * Returns the child text from an element.
	 */
	private String getChildText(Element e, String tag) {
		try {
			return e.getChildText(tag);
		} catch (Exception exception) {
		}
		return null;
	}

	private void load(String path) {

		SAXBuilder builder = new SAXBuilder();
		File xmlFile = FileUtils.getLocal(path);

		try {

			Document document = (Document) builder.build(xmlFile);
			Element root = document.getRootElement();

			Element properties = root.getChild("properties");

			id = properties.getAttributeValue("id");
			name = properties.getAttributeValue("name");

			List<Element> entities = root.getChild("entities").getChildren();

			for (int i = 0; i < entities.size(); i++) {
				Element entity = (Element) entities.get(i);

				String id = getChildText(entity, "id");
				String type = getChildText(entity, "type");
				String texture = getChildText(entity, "texture");
				Element bounds = entity.getChild("bounds");

				// If this object has a rotation tag, get that value.
				float rotation = getChildText(entity, "rotation") != null ? Float.parseFloat(getChildText(entity, "rotation")) : 0;
				
				int x = Integer.parseInt(bounds.getAttributeValue("x"));
				int y = Integer.parseInt(bounds.getAttributeValue("y"));
				int w = Integer.parseInt(bounds.getAttributeValue("width"));
				int h = Integer.parseInt(bounds.getAttributeValue("height"));

				switch (type) {
				case "static":

					Static s = (Static) new Static(x, y, w, h, assets.get(texture)).setID(id);
					s.rotation = rotation;
					addEntity(s);

					break;

				default:
					System.err.println("Could not find an entity preset of type '" + type + "'");
					break;
				}

			}

		} catch (Exception e) {

		}

	}

}
