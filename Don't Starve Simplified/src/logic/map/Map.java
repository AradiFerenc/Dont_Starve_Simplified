package logic.map;

import logic.Coordinate;
import logic.entities.Entity;
import logic.entities.tiles.NullTile;
import logic.entities.tiles.Tile;

import java.awt.Graphics;


public abstract class Map {
    public static Map gameMap;

    protected final int WIDTH;
    protected final int HEIGHT;
    protected Tile tiles[];
    protected int xOffset=0;
    protected int yOffset=0;

    public Map(int width, int height)
    {
        this.WIDTH=width;
        this.HEIGHT=height;
        Tile.initializeTiles();
        tiles=new Tile[WIDTH*HEIGHT];
        initialize();
    }

    public void loadMapData()
    {
        loadTiles();
        loadEntities();
    }

    public void initialize()
    {
        loadMapData();
    }

    public abstract void loadTiles();
    public abstract void loadEntities();

    public void setTilesOffset ()
    {
        for (int i = 0; i< tiles.length; i++)
        {
            tiles[i].setxOffset(this.xOffset);
            tiles[i].setyOffset(this.yOffset);
        }
    }
    public void renderEntities(Graphics graphics)
    {

    }

    public void update()
    {
        setTilesOffset();
    }

    public void renderTiles(Graphics graphics)
    {
        for (int i = 0; i< tiles.length; i++)
        {
            if (tiles[i].isOnScreen())
            {
                tiles[i].render(graphics);
                if (tiles[i].isSolid())
                {
                    //tiles[i].getHitbox().render(graphics);
                }
            }
        }
    }

    public void render(Graphics graphics)
    {
        renderTiles(graphics);
        renderEntities(graphics);
    }

    public Tile getTile(int x, int y) {
        try{
            return tiles[y*WIDTH+x];

        }catch (ArrayIndexOutOfBoundsException e)
        {
            return new NullTile();
        }
    }

    public Coordinate getTileCoordinateUnderEntity(Entity entity)
    {
        Coordinate midPoint=new Coordinate(entity.getHitbox().getPosition().getX()+entity.getHitbox().getWidth()/2,entity.getHitbox().getPosition().getY()+entity.getHitbox().getHeight()/2);
        return new Coordinate((midPoint.getX()/Tile.DEFAULT_TILE_WIDTH),(midPoint.getY()/Tile.DEFAULT_TILE_HEIGHT));
    }
    public Tile[] getTilesAroundEntity(Entity entity)
    {
        Coordinate entityCoordinate=getTileCoordinateUnderEntity(entity);
        System.out.println(entityCoordinate.getX()+"__"+entityCoordinate.getY());
        Tile[] tilesAroundEntity={
                getTile(entityCoordinate.getX()-1,entityCoordinate.getY()-1),
                getTile(entityCoordinate.getX()-1,entityCoordinate.getY()),
                getTile(entityCoordinate.getX()-1,entityCoordinate.getY()+1),
                getTile(entityCoordinate.getX(),entityCoordinate.getY()-1),
                getTile(entityCoordinate.getX(),entityCoordinate.getY()),
                getTile(entityCoordinate.getX(),entityCoordinate.getY()+1),
                getTile(entityCoordinate.getX()+1,entityCoordinate.getY()-1),
                getTile(entityCoordinate.getX()+1,entityCoordinate.getY()),
                getTile(entityCoordinate.getX()+1,entityCoordinate.getY()+1),
        };
        return tilesAroundEntity;
    }

    public void setTilesXOffset(int xOffset)
    {
        for (int i=0;i<tiles.length;i++)
        {
            tiles[i].setxOffset(xOffset);
        }
    }
    public void setTilesYOffset(int yOffset)
    {
        for (int i=0;i<tiles.length;i++)
        {
            tiles[i].setyOffset(yOffset);
        }
    }
    public boolean isBindingToEndOfMap(Entity entity)
    {
        if(entity.getHitbox().getPosition().getX()<=0 ||
        entity.getHitbox().getPosition().getX()+entity.getHitbox().getWidth()>=Tile.DEFAULT_TILE_WIDTH*WIDTH||
        entity.getHitbox().getPosition().getY()<=0 ||
                entity.getHitbox().getPosition().getY()+entity.getHitbox().getHeight()>=Tile.DEFAULT_TILE_HEIGHT*HEIGHT)
            return true;
        return false;
    }
    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getxOffset() {
        return xOffset;
    }

    public void setxOffset(int xOffset) {
        this.xOffset = xOffset;
    }

    public int getyOffset() {
        return yOffset;
    }

    public void setyOffset(int yOffset) {
        this.yOffset = yOffset;
    }
    public void setMapOffset(int xOffset, int yOffset)
    {
        this.xOffset=xOffset;
        this.yOffset=yOffset;
    }


}
