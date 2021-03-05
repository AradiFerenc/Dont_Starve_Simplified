package logic.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    private boolean[] keys;
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    public boolean pauseKey;

    public static int upKeycode;
    public static int downKeycode;
    public static int leftKeycode;
    public static int rightKeycode;

    public KeyManager() {
        keys = new boolean[66666];
        upKeycode=KeyEvent.VK_W;
        downKeycode=KeyEvent.VK_S;
        leftKeycode=KeyEvent.VK_A;
        rightKeycode=KeyEvent.VK_D;
    }

    public void update()
    {
        up=keys[upKeycode];
        down=keys[downKeycode];
        left=keys[leftKeycode];
        right=keys[rightKeycode];
    }
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
        //System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        pauseKey=keys[KeyEvent.VK_ESCAPE];
    }


    public static void setUpKeycode(int upKeycode) {
        KeyManager.upKeycode = upKeycode;
    }

    public static void setDownKeycode(int downKeycode) {
        KeyManager.downKeycode = downKeycode;
    }

    public static void setLeftKeycode(int leftKeycode) {
        KeyManager.leftKeycode = leftKeycode;
    }

    public static void setRightKeycode(int rightKeycode) {
        KeyManager.rightKeycode = rightKeycode;
    }
}
