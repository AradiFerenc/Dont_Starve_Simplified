package logic.entities.creatures.players;

import gfx.Animation;
import gfx.sprites.Sprite;
import logic.Coordinate;
import logic.Hitbox;

public class ArcherPlayer extends Player{

    private Sprite[] framesIdleUp ={Sprite.ArcherSprites[0]};
    private Sprite[] framesIdleLeft ={Sprite.ArcherSprites[9]};
    private Sprite[] framesIdleRight ={Sprite.ArcherSprites[27]};
    private Sprite[] framesIdleDown ={Sprite.ArcherSprites[18]};
    private int speed=2;

    private Sprite[] framesMovingUp ={
            Sprite.ArcherSprites[1],
            Sprite.ArcherSprites[2],
            Sprite.ArcherSprites[3],
            Sprite.ArcherSprites[4],
            Sprite.ArcherSprites[5],
            Sprite.ArcherSprites[6],
            Sprite.ArcherSprites[7],
            Sprite.ArcherSprites[8]
    };
    private Sprite[] framesMovingLeft ={
            Sprite.ArcherSprites[10],
            Sprite.ArcherSprites[11],
            Sprite.ArcherSprites[12],
            Sprite.ArcherSprites[13],
            Sprite.ArcherSprites[14],
            Sprite.ArcherSprites[15],
            Sprite.ArcherSprites[16],
            Sprite.ArcherSprites[17]
    };
    private Sprite[] framesMovingDown ={
            Sprite.ArcherSprites[19],
            Sprite.ArcherSprites[20],
            Sprite.ArcherSprites[21],
            Sprite.ArcherSprites[22],
            Sprite.ArcherSprites[23],
            Sprite.ArcherSprites[24],
            Sprite.ArcherSprites[25],
            Sprite.ArcherSprites[26]
    };
    private Sprite[] framesMovingRight ={
            Sprite.ArcherSprites[27],
            Sprite.ArcherSprites[28],
            Sprite.ArcherSprites[29],
            Sprite.ArcherSprites[30],
            Sprite.ArcherSprites[31],
            Sprite.ArcherSprites[32],
            Sprite.ArcherSprites[33],
            Sprite.ArcherSprites[34]
    };

    public ArcherPlayer(Coordinate startCoordinate)
    {
        super(startCoordinate);
        setSizeMultiplier(2);
        setWidth(Sprite.DEFAULT_TEXTURE_SIZE*getSizeMultiplier());
        setHeight(Sprite.DEFAULT_TEXTURE_SIZE*getSizeMultiplier());
        setHitbox(new Hitbox(this,new Coordinate(23*getSizeMultiplier(),38*getSizeMultiplier()),18*getSizeMultiplier(),24*getSizeMultiplier()));
        setSpeed(speed);
        setAnimations();
        setAnimationSpeeds();
    }

    @Override
    public void setAnimations() {
        setAnimations(new Animation[][]{
                new Animation[]{new Animation(framesIdleDown),new Animation(framesIdleUp),new Animation(framesIdleLeft),new Animation(framesIdleRight)},
                new Animation[]{new Animation(framesMovingDown), new Animation(framesMovingUp), new Animation(framesMovingLeft), new Animation(framesMovingRight)}
        });
    }

    public void setAnimationSpeeds()
    {
        for (int byMovement=0;byMovement<2;byMovement++)
        {
            for (int byDirection=0;byDirection<4;byDirection++)
            {
                setAnimationSpeed(getAnimations()[byMovement][byDirection],100/framesIdleDown.length);
            }
        }
    }


}
