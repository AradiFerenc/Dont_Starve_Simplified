package logic.entities.creatures.players;

import gfx.Animation;
import gfx.sprites.Sprite;
import logic.Coordinate;
import logic.Hitbox;

public class KnightPlayer extends Player {

    private Sprite[] framesMovingDown ={Sprite.KnightSprites[0],Sprite.KnightSprites[1]};
    private Sprite[] framesMovingLeft ={Sprite.KnightSprites[3],Sprite.KnightSprites[4]};
    private Sprite[] framesMovingRight ={Sprite.KnightSprites[6],Sprite.KnightSprites[7]};
    private Sprite[] framesMovingUp ={Sprite.KnightSprites[9],Sprite.KnightSprites[10]};

    private Sprite[] framesIdleDown ={Sprite.KnightSprites[2]};
    private Sprite[] framesIdleLeft ={Sprite.KnightSprites[5]};
    private Sprite[] framesIdleRight ={Sprite.KnightSprites[8]};
    private Sprite[] framesIdleUp ={Sprite.KnightSprites[11]};

    private int speed=3;
    public KnightPlayer(Coordinate startCoordinate)
    {
        super(startCoordinate);
        setSizeMultiplier(2);
        setWidth(Sprite.DEFAULT_TEXTURE_SIZE*getSizeMultiplier());
        setHeight(Sprite.DEFAULT_TEXTURE_SIZE*getSizeMultiplier());
        setHitbox(new Hitbox(this,new Coordinate(16*getSizeMultiplier(),30*getSizeMultiplier()),34*getSizeMultiplier(),31*getSizeMultiplier()));
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
                setAnimationSpeed(getAnimations()[byMovement][byDirection],500/framesIdleDown.length);
            }
        }
    }
}
