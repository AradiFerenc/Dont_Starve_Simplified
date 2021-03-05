package logic.entities.creatures.players;

import gfx.GamePanel;
import logic.Coordinate;
import logic.Hitbox;
import logic.entities.creatures.Creature;


public  abstract class Player extends Creature {

    private int speed=2;

    public Player(Coordinate startCoordinate)
    {
        super(startCoordinate);
    }

    @Override
    public boolean isHostile() {
        return false;
    }

    @Override
    public void move() {
            position.setX(position.getX()+getXMovement());
            position.setY(position.getY()+getYMovement());

    }

    public int getYMovement()
    {
        if (GamePanel.keyManager.up)
            return -speed;
        if (GamePanel.keyManager.down)
            return speed;
        return 0;
    }
    public int getXMovement()
    {
        if (GamePanel.keyManager.left)
            return -speed;
        if (GamePanel.keyManager.right)
            return speed;
        return 0;
    }

    @Override
    public void update() {
        super.update();
        //move();
    }
    public void setSpeed(int newSpeed)
    {
        this.speed=newSpeed;
    }
}
