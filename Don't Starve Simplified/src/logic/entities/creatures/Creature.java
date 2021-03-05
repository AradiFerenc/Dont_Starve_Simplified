package logic.entities.creatures;

import gfx.Animation;
import gfx.GamePanel;
import logic.Coordinate;
import logic.Direction;
import logic.entities.Entity;

import java.awt.Graphics;

public abstract class Creature extends Entity {
    private Animation[][] animations=new Animation[2][4];

    public Creature(Coordinate coordinate)
    {
        super(coordinate);
        setAnimations();
    }

    public abstract boolean isHostile();

    @Override
    public void update()
    {
        updateMoving();
        updateDirection();
        updateAnimation();
        updateHitbox();
    }
    @Override
    public void render(Graphics graphics)
    {
        playAnimation(graphics);
        //getHitbox().render(graphics);
    }


    public void playAnimation(Graphics graphics)
    {
        graphics.drawImage(animations[getMovingStatus()][getDirection().getValue()].getCurrentFrame().getTexture(), position.getX()+getxOffset(), position.getY()+getyOffset(), getWidth(), getHeight(), null);
    }

    public void updateAnimation()
    {
        animations[getMovingStatus()][getDirection().getValue()].update();
    }
    public void updateDirection()
    {
        if(GamePanel.keyManager.down)
        {
            setDirection(Direction.DOWN);
        }
        else if(GamePanel.keyManager.up)
        {
            setDirection(Direction.UP);
        }
        else if(GamePanel.keyManager.left)
        {
            setDirection(Direction.LEFT);
        }
        else if(GamePanel.keyManager.right)
        {
            setDirection(Direction.RIGHT);
        }

    }
    public void updateMoving()
    {
        if(GamePanel.keyManager.up || GamePanel.keyManager.down || GamePanel.keyManager.right || GamePanel.keyManager.left)
        {
            setMovingStatus(1);
        }
        else
        {
            setMovingStatus(0);
        }
    }

    public abstract void setAnimations();

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public void setAnimationSpeed(Animation animation, int newSpeed)
    {
        animation.setSpeed(newSpeed);
    }


    public Animation[][] getAnimations() {
        return animations;
    }

    public void setAnimations(Animation[][] animations) {
        this.animations = animations;
    }
}
