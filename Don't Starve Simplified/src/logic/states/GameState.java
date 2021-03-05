package logic.states;

import gfx.GamePanel;
import logic.Coordinate;
import logic.Hitbox;
import logic.camera.Camera;
import logic.entities.creatures.players.ArcherPlayer;
import logic.entities.Entity;
import logic.entities.creatures.players.KnightPlayer;
import logic.entities.tiles.NullTile;
import logic.entities.tiles.Tile;
import logic.map.Map;
import logic.map.RandomMap;

import java.awt.Graphics;
import java.util.ArrayList;

public class GameState extends State {

    private ArrayList<Entity> entityList=new ArrayList<>();
    private Camera camera;

    public GameState()
    {
        initEntityList();
        Map.gameMap=new RandomMap(100,100);
        camera=new Camera(entityList,0,Map.gameMap);
    }
    private void initEntityList()
    {
        this.entityList.add(new ArcherPlayer(new Coordinate(100,100)));//350,250
        //this.entityList.add(new KnightPlayer(new Coordinate(100,100)));
    }
    @Override
    public void update() {
        Map.gameMap.update();
        updateEntities();
        camera.update();
        managePauseKey();
    }

    @Override
    public void render(Graphics graphics) {
        setBackground(graphics);
        Map.gameMap.render(graphics);
        renderEntities(graphics);
    }

    @Override
    public void actionOnPauseKeyPress() {
        GamePanel.addState(State.pauseMenu);
    }
    public void renderEntities(Graphics graphics)
    {
        for (int i=0;i<entityList.size();i++)
        {
            entityList.get(i).render(graphics);
        }
    }
    public void updateEntities()
    {
        for(int i=0;i<entityList.size();i++)
        {
            boolean canMove=true;
            entityList.get(i).move();
            entityList.get(i).update();
        }
    }
}
