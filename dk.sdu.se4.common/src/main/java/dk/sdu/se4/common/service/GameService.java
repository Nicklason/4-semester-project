package dk.sdu.se4.common.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.List;

public interface GameService {

  public void create();

  List<ProcessorService> getProcessorServiceslist();

  void addMapService(MapService mapService);

  void removeMapService(MapService mapService);

  void addPlugin(PluginService pluginService);

  void removePlugin(PluginService pluginService);

  void addProcessorService(ProcessorService ProcessorService);

  void removeProcessorService(ProcessorService ProcessorService);

  void addPostProcessorService(PostProcessorService postProcessorService);

  void removePostProcessorService(PostProcessorService postProcessorService);

  void addScreen(Screen screen);

  SpriteBatch getBatch();

  int getWidth();

  int  getHeight();

 List<ProcessorService> getProcessorServices();

  MapService getMapService();
}
