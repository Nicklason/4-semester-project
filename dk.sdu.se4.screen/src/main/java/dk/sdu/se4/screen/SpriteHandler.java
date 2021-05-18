package dk.sdu.se4.screen;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class SpriteHandler {
    protected static final AssetManager assetManager = new AssetManager();
    private String[] assetPaths = new String[]{
      "Bullets/bullet.png",
      "Enemy/zombi.png",
      "Player/player.png",
      "UI/UI.png",
      "UI/Background.png",
      "UI/HeadLine.png",
      "UI/play.png",
      "UI/exit.png",
      "Tile/grass.png",
      "Tile/lake.png"
    };

    public void loadAssets() {
        for (int i = 0; i < assetPaths.length; i++) {
            assetManager.load(assetPaths[i], Texture.class);
            assetManager.update();
        }

        assetManager.finishLoading();
    }
}
