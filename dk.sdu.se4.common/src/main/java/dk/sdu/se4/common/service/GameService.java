package dk.sdu.se4.common.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.List;

public interface GameService {
  
  void addScreen(Screen screen);

  SpriteBatch getBatch();
  
  ShapeRenderer getShapeRenderer();

  int getWidth();

  int  getHeight();

 List<ProcessorService> getProcessorServices();
 
 List<PostProcessorService> getPostProcessorServiceslist();

  MapService getMapService();

  OrthographicCamera getCamera();
}
