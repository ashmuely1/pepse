package pepse;

import danogl.GameManager;
import danogl.collisions.GameObjectCollection;
import danogl.collisions.Layer;
import danogl.gui.ImageReader;
import danogl.gui.SoundReader;
import danogl.gui.UserInputListener;
import danogl.gui.WindowController;
import danogl.util.Vector2;
import pepse.world.Block;
import pepse.world.Sky;
import pepse.world.Terrain;

public class PepseGameManager extends GameManager {

    private static int BlocksInSeason = 100;

    @Override
    public void initializeGame(ImageReader imageReader, SoundReader soundReader, UserInputListener inputListener, WindowController windowController) {
        super.initializeGame(imageReader, soundReader, inputListener, windowController);
        Sky.create( gameObjects(), windowController.getWindowDimensions(), Layer.BACKGROUND);
        Terrain terr = new Terrain(gameObjects(), Layer.STATIC_OBJECTS, windowController.getWindowDimensions());
        terr.createInRange(0, (int)(BlocksInSeason * Block.SIZE));
    }

    public static void main(String[] args) {
        new PepseGameManager().run();
    }

}
