package dk.sdu.se4.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import dk.sdu.se4.common.service.GameService;
import dk.sdu.se4.common.service.MapService;

public class ShopScreen implements Screen {

  private GameService game;
  private MapService mapService=null;
  private Texture shopui;
  private Texture shopLogo;

  public ShopScreen(GameService gameCore) {
    this.game=gameCore;
    this.shopui = new Texture("../dk.sdu.se4.screen/src/main/resources/img/ShopBackground.png");
    this.shopLogo = new Texture("../dk.sdu.se4.screen/src/main/resources/img/shop.png");
    if(this.mapService==null){
      this.mapService=gameCore.getMapService();
    }
  }

  @Override
  public void show() {

  }

  @Override
  public void render(float v) {
    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    this.game.getBatch().begin();
    if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
      this.pause();
      this.game.addScreen(new StartMenu(this.game));
    }
    draw();


    this.game.getBatch().end();

  }
  private void draw(){
    this.game.getBatch().draw(shopui,0,0);
    this.game.getBatch().draw(shopLogo,(this.game.getWidth()/2)-(this.shopLogo.getWidth()/2),this.game.getHeight()-100);

  }

  @Override
  public void resize(int i, int i1) {

  }

  @Override
  public void pause() {

  }

  @Override
  public void resume() {

  }

  @Override
  public void hide() {

  }

  @Override
  public void dispose() {

  }
}
