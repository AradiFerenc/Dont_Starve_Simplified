package logic.states.settings;

import gfx.GamePanel;
import gfx.Window;
import logic.buttons.Button;
import logic.Coordinate;
import logic.input.KeyManager;
import logic.states.State;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class ControlsSettingsState extends State {
    public ControlsSettingsState()
    {
        buttons=new Button[]{
                new Button(new Coordinate((Window.width / 2) - (Button.DEFAULT_WIDTH / 2), 100), 100, 50,"Back") {
                    @Override
                    public void actionOnClick()
                    {
                        GamePanel.removeLastState();
                    }
                    },
                new Button(new Coordinate(0,0),100,50,"UP") {
                    @Override
                    public void actionOnClick() {
                        
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
        setBackground(graphics);
        renderStateTitle(graphics,"Controls");
        renderButtons(graphics);
    }

    @Override
    public void actionOnPauseKeyPress() {
        GamePanel.removeLastState();
    }
}
