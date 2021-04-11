package dk.sdu.se4.commongameinput;

/**
 * Service for getting inputs for the game
 */
public interface GameInput {
  boolean isPressed(GameInputKeys key);
}
