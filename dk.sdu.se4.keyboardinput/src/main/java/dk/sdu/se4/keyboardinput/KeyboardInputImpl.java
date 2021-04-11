package dk.sdu.se4.keyboardinput;

import dk.sdu.se4.commongameinput.GameInput;
import dk.sdu.se4.commongameinput.GameInputKeys;
import java.util.HashMap;
import java.util.Map;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

public class KeyboardInputImpl extends InputAdapter implements GameInput {
    private final Map<GameInputKeys, Boolean> keys = new HashMap();
    
    public boolean isPressed(GameInputKeys key) {
        if(keys.containsKey(key)) {
            System.out.println(keys.get(key).booleanValue());
            return keys.get(key).booleanValue();
        } else {
            System.out.println("false");
            return false;
        }
    }

    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Keys.W:
                this.keys.put(GameInputKeys.UP, true);
                break;
            case Keys.D:
                this.keys.put(GameInputKeys.RIGHT, true);
                break;
            case Keys.S:
                this.keys.put(GameInputKeys.DOWN, true);
                break;
            case Keys.A:
                this.keys.put(GameInputKeys.LEFT, true);
                break;
            case Keys.SPACE:
                this.keys.put(GameInputKeys.SPACE, true);
                break;
            case Keys.ESCAPE:
                this.keys.put(GameInputKeys.ESCAPE, true);
                break;
        }
        
        return true;
    }
    
    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Keys.W:
                this.keys.put(GameInputKeys.UP, false);
                break;
            case Keys.D:
                this.keys.put(GameInputKeys.RIGHT, false);
                break;
            case Keys.S:
                this.keys.put(GameInputKeys.DOWN, false);
                break;
            case Keys.A:
                this.keys.put(GameInputKeys.LEFT, false);
                break;
            case Keys.SPACE:
                this.keys.put(GameInputKeys.SPACE, false);
                break;
            case Keys.ESCAPE:
                this.keys.put(GameInputKeys.ESCAPE, false);
                break;
        }
        
        return true;
    }
}
