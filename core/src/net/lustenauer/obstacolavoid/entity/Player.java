package net.lustenauer.obstacolavoid.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import net.lustenauer.obstacolavoid.config.GameConfig;

/**
 * Created by Patric Hollenstein on 05.01.18.
 *
 * @author Patric Hollenstein
 */
public class Player extends GameObjectBase {


    public Player() {
        super(GameConfig.PLAYER_BOUNDS_RADIUS);
        setSize(GameConfig.PLAYER_SIZE, GameConfig.PLAYER_SIZE);
    }
}
