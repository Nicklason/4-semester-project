package dk.sdu.se4.gui;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.*;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.common.service.PluginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.events.EntityReference;

public class GameGuiPlugin implements PluginService {

  protected Logger log = LoggerFactory.getLogger(this.getClass());
  private MapService mapService;
  @Override
  public void load() {

    if (mapService!=null){
      this.mapService.addEntity(addUIEntity("UI/UI.png",800,600,99,0,0 ,new UIPart(UIPart.Type.IMAGE,true, "UI")));

      this.mapService.addEntity(addUIEntity("UI/Background.png",400,500,102,(800-400)/2,(600-500)/2, new UIPart( UIPart.Type.IMAGE,true, "MenuBackground")));

      this.mapService.addEntity(addUIEntity("UI/HeadLine.png",350,45,103,(int)(800-350)/2,475, new UIPart( UIPart.Type.IMAGE,true, "HeadLine")));

      this.mapService.addEntity(addUIEntity("UI/play.png",200,60,103,(int)(800-200)/2,350, new UIPart( UIPart.Type.BUTTON,true, "play")));


      this.mapService.addEntity(addUIEntity("UI/exit.png",200,60,103,(int)(800-200)/2,275, new UIPart(UIPart.Type.BUTTON,true,"exit" )));



    }

  }


  @Override
  public void unload() {

  }



  public void addMapService(MapService mapService) {
    log.debug("Add Mapservice on {}", this.getClass());
    this.mapService = mapService;
  }

  public void removeMapService(MapService mapService) {
    log.debug("Remove Mapservice from {}", this.getClass());
    this.mapService = null;
  }

  private Entity addUIEntity(String path, int width, int height, int layer, int X, int Y, UIPart uiPart){
    Entity gameGuiEntity = new GuiEntity();
    gameGuiEntity.addPart(new PositionPart(X,Y));
    gameGuiEntity.addPart(uiPart);
    gameGuiEntity.addPart(new SpritePart(path, width,height, layer));
    return gameGuiEntity;
  }

}
