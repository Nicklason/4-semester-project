package dk.sdu.se4.screen;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.*;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.MapService;

public class SpriteHandler {

  protected static final AssetManager assetManager = new AssetManager();


  public void loadAssets(MapService mapService) {
    for (Entity entity : mapService.getEntities()) {
      SpritePart spritePart = entity.getPart(SpritePart.class);
      if (spritePart != null) {
        assetManager.load(spritePart.getSpritePath(), Texture.class);
        assetManager.update();
      }
    }
    assetManager.finishLoading();
  }


}
