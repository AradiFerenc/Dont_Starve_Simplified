package logic;

import logic.entities.Entity;

import java.awt.Graphics;
import java.awt.Color;

public class Hitbox {

    private Entity entity;
    private Coordinate offsetRelativeToEntity;
    private int width;
    private int height;
    private Coordinate position;

    public Hitbox(Entity entity,Coordinate offsetRelativeToEntity, int width, int height)
    {
        this.entity=entity;
        this.offsetRelativeToEntity=offsetRelativeToEntity;
        this.width=width;
        this.height=height;
        this.position=new Coordinate(entity.getPosition().getX()+offsetRelativeToEntity.getX(),entity.getPosition().getY()+offsetRelativeToEntity.getY());
    }

    public void update(Entity entity)
    {
        setPosition(new Coordinate(entity.getPosition().getX()+offsetRelativeToEntity.getX(),entity.getPosition().getY()+offsetRelativeToEntity.getY()));
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(getPosition().getX()+entity.getxOffset(), getPosition().getY()+entity.getyOffset(), getWidth(), getHeight());
    }

    public static boolean areColliding(Entity entity1, Entity entity2)
    {
        if (entity1.getHitbox().getPosition().getX() < entity2.getHitbox().getPosition().getX() + entity2.getHitbox().getWidth() &&
                entity1.getHitbox().getPosition().getX() + entity1.getHitbox().getWidth() > entity2.getHitbox().getPosition().getX() &&
                entity1.getHitbox().getPosition().getY() < entity2.getHitbox().getPosition().getY() + entity2.getHitbox().getHeight() &&
                entity1.getHitbox().getPosition().getY() + entity1.getHitbox().getHeight() > entity2.getHitbox().getPosition().getY())
        {
            return true;
        }
        return false;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
        entity.setPosition(new Coordinate(position.getX()-offsetRelativeToEntity.getX(),position.getY()-offsetRelativeToEntity.getY()));
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Coordinate getOffsetRelativeToEntityPosition() {
        return offsetRelativeToEntity;
}
}
