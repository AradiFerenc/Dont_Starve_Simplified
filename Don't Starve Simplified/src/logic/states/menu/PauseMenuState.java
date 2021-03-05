package logic.states.menu;

import gfx.GamePanel;
import gfx.Window;
import logic.buttons.Button;
import logic.Coordinate;
import logic.states.State;

import java.awt.Graphics;

public class PauseMenuState extends State {


    public PauseMenuState()
    {
        buttons= new Button[]{
                new Button(new Coordinate((Window.width / 2) - (Button.DEFAULT_WIDTH / 2), 100), Button.DEFAULT_WIDTH, Button.DEFAULT_HEIGHT,"Back") {
                    @Override
                    public void actionOnClick() {
                        GamePanel.removeLastState();
                    }
                },
                new Button(new Coordinate((Window.width / 2) - (Button.DEFAULT_WIDTH / 2), 100 + (Button.DEFAULT_HEIGHT + State.DEFAULT_BUTTON_SPACING)), Button.DEFAULT_WIDTH, Button.DEFAULT_HEIGHT,"Settings") {
                    @Override
                    public void actionOnClick() {
                        GamePanel.addState(State.settings);
                    }
                },
                new Button(new Coordinate((Window.width / 2) - (Button.DEFAULT_WIDTH), 100 + (Button.DEFAULT_HEIGHT + State.DEFAULT_BUTTON_SPACING) * 2), Button.DEFAULT_WIDTH * 2, Button.DEFAULT_HEIGHT,"Main menu") {
                    @Override
                    public void actionOnClick() {
                        GamePanel.clearStates();
                        GamePanel.addState(State.mainMenu);
                    }
                }
        };
    }
    @Override
    public void update() {
        updateButtons();
        managePauseKey();
    }

    @Override
    public void render(Graphics graphics) {
        State.game.render(graphics);
        renderStateTitle(graphics,"Paused");
        renderButtons(graphics);
    }

    @Override
    public void actionOnPauseKeyPress() {
        GamePanel.removeLastState();
    }

}
