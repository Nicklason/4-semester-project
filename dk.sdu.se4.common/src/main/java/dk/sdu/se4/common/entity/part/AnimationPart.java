package dk.sdu.se4.common.entity.part;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import dk.sdu.se4.common.entity.Entity;

import java.io.File;
import java.lang.reflect.Array;
import java.util.logging.FileHandler;

public class AnimationPart implements EntityPart {
  private Texture imageTexture;
  private TextureRegion[][]tmp;
  private Animation<TextureRegion> animation;



  public AnimationPart(File file, int frame_column, int frame_row){
      imageTexture = new Texture(new FileHandle(file));
      tmp = TextureRegion.split(imageTexture, imageTexture.getWidth() / frame_column, imageTexture.getHeight() / frame_row);
      for (TextureRegion t :animation){
        System.out.println(t);
      }
  }



  @Override
  public void process(Entity entity) {

  }
}
