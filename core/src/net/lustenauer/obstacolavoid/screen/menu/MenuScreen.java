package net.lustenauer.obstacolavoid.screen.menu;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Logger;
import net.lustenauer.obstacolavoid.ObstacleAvoidGame;
import net.lustenauer.obstacolavoid.assets.AssetDescriptors;
import net.lustenauer.obstacolavoid.assets.RegionNames;
import net.lustenauer.obstacolavoid.screen.game.GameScreen;

/**
 * Created by Patric Hollenstein on 13.01.18.
 *
 * @author Patric Hollenstein
 */
public class MenuScreen extends MenuScreenBase {
    /*
     * CONSTANTS
     */
    private static final Logger log = new Logger(MenuScreen.class.getName(), Logger.DEBUG);

    /*
     * CONSTRUCTOR
     */
    public MenuScreen(ObstacleAvoidGame game) {
        super(game);
    }

    @Override
    protected Actor createUi() {
        Table table = new Table();

        TextureAtlas gamePlayAtlas = assetManager.get(AssetDescriptors.GAME_PLAY);
        TextureAtlas uiAtlas = assetManager.get(AssetDescriptors.UI);

        TextureRegion backgroundRegion = gamePlayAtlas.findRegion(RegionNames.BACKGROUND);
        TextureRegion panelRegion = uiAtlas.findRegion(RegionNames.PANEL);

        table.setBackground(new TextureRegionDrawable(backgroundRegion));

        // play button
        ImageButton playButton = createButton(uiAtlas, RegionNames.PLAY, RegionNames.PLAY_PRESSED);
        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                play();
            }
        });

        // highscore button
        ImageButton highScoreButton = createButton(uiAtlas, RegionNames.HIGH_SCORE, RegionNames.HIGH_SCORE_PRESSED);
        highScoreButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                showHighScore();
            }
        });

        // options button
        ImageButton optionsButton = createButton(uiAtlas, RegionNames.OPTIONS, RegionNames.OPTIONS_PRESSED);
        optionsButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                showOptions();
            }
        });

        // quit button


        // setup table
        Table buttonTable = new Table();
        buttonTable.defaults().pad(20);
        buttonTable.setBackground(new TextureRegionDrawable(panelRegion));

        buttonTable.add(playButton).row();
        buttonTable.add(highScoreButton).row();
        buttonTable.add(optionsButton).row();

        buttonTable.center();

        table.add(buttonTable);
        table.center();
        table.setFillParent(true);
        table.pack();

        return table;

    }

    private void showOptions() {
        log.debug("showOptions");
        game.setScreen(new OptionsScreen(game));
    }

    private void showHighScore() {
        log.debug("showHighScore");
        game.setScreen(new HeightScoreScreen(game));
    }

    private void play() {
        log.debug("play");
        game.setScreen(new GameScreen(game));
    }

    private static ImageButton createButton(TextureAtlas atlas, String upRegionName, String downRegionName) {
        TextureRegion upRegion = atlas.findRegion(upRegionName);
        TextureRegion downRegion = atlas.findRegion(downRegionName);

        return new ImageButton(
                new TextureRegionDrawable(upRegion),
                new TextureRegionDrawable(downRegion)
        );
    }

}
