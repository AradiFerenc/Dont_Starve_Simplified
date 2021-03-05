package gfx;

import javax.swing.JFrame;
import java.awt.event.WindowEvent;

public class Window extends JFrame
{
    public static int width;
    public static int height;


    public Window()
    {
        this.width=800;
        this.height=600;
        initializeWindow();
    }
    public void initializeWindow()
    {
        setTitle("River runner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setAutoRequestFocus(true);
    }
    public void start()
    {
        add(new GamePanel(width,height,this));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void close()
    {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}