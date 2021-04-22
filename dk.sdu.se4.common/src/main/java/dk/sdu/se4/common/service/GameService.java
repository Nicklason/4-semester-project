package dk.sdu.se4.common.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.List;

public interface GameService {

  void create();

  void addMapService(MapService mapService);

  void removeMapService(MapService mapService);

  void addScreen(Screen screen);

  SpriteBatch getBatch();

  int getWidth();

  int  getHeight();

 List<ProcessorService> getProcessorServices();

  MapService getMapService();

  OrthographicCamera getCamera();
}
