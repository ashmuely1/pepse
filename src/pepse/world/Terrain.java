package pepse.world;

import danogl.collisions.GameObjectCollection;
import danogl.collisions.Layer;
import danogl.gui.rendering.RectangleRenderable;
import danogl.gui.rendering.Renderable;
import danogl.util.Vector2;
import pepse.util.ColorSupplier;

import java.awt.*;

public class Terrain {
    private static final int TERRAIN_DEPTH = 20;
    private static final Color BASE_GROUND_COLOR = new Color(212, 123, 74);

    private GameObjectCollection gameObjects;
    private int groundLayer;
    private float groundHeightAtX0;


    public Terrain(GameObjectCollection gameObjects,
                   int groundLayer,
                   Vector2 windowDimensions) {

        this.gameObjects = gameObjects;
        this.groundLayer = groundLayer;
        this.groundHeightAtX0 = windowDimensions.y();
        this.groundHeightAtX0 = windowDimensions.y() * 2 / 3;
    }

    public float groundHeightAt(float x) {
        return (int)((groundHeightAtX0 + (float) Math.sin(x/5) * Block.SIZE * 2)/30) * 30;
    }

    public void createInRange(int minX, int maxX) {
        Renderable ground = new RectangleRenderable(ColorSupplier.approximateColor(BASE_GROUND_COLOR));
        for (int i = (int)((minX / Block.SIZE) * Block.SIZE); i < maxX; i += Block.SIZE){
            for (int j = 0; j < TERRAIN_DEPTH; j++) {
                Block block = new Block(new Vector2(i, groundHeightAt(i) + j*Block.SIZE), ground);
                block.setTag("block");
                gameObjects.addGameObject(block, groundLayer);
            }

        }
    }


}
