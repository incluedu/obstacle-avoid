package net.lustenauer.obstacolavoid.screen.menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Logger;
import net.lustenauer.obstacolavoid.ObstacleAvoidGame;
import net.lustenauer.obstacolavoid.assets.AssetDescriptors;
import net.lustenauer.obstacolavoid.assets.RegionNames;
import net.lustenauer.obstacolavoid.common.GameManager;

/**
 * Created by Patric Hollenstein on 14.01.18.
 *
 * @author Patric Hollenstein
 */
public class HeightScoreScreen extends MenuScreenBase {
    private static final Logger log = new Logger(HeightScoreScreen.class.getName(), Logger.DEBUG);


    /*
     * CONSTRUCTORS
     */
    public HeightScoreScreen(ObstacleAvoidGame game) {
        super(game);
    }

    /*
     * PRIVATE METHODES
     */
    protected Actor createUi() {
        Table table = new Table();

        TextureAtlas gamePlayAtlas = assetManager.get(AssetDescriptors.GAME_PLAY);
        TextureAtlas uiAtlas = assetManager.get(AssetDescriptors.UI);
        BitmapFont font = assetManager.get(AssetDescriptors.FONT);

        TextureRegion backgroundRegion = gamePlayAtlas.findRegion(RegionNames.BACKGROUND);
        TextureRegion panelRegion = uiAtlas.findRegion(RegionNames.PANEL);

        TextureRegion backRegion = uiAtlas.findRegion(RegionNames.BACK);
        TextureRegion backPressedRegion = uiAtlas.findRegion(RegionNames.BACK_PRESSED);

        Label.LabelStyle labelStyle = new Label.LabelStyle(font, Color.WHITE);


        // background
        table.setBackground(new TextureRegionDrawable(backgroundRegion));

        // highscore text
        Label highScoreText = new Label("HIGHSCORE", labelStyle);


        // highscore label
        String highScoreString = GameManager.INSTANCE.getHighScoreString();
        Label highScoreLabel = new Label(highScoreString, labelStyle);

        // back button
        ImageButton backButton = new ImageButton(
                new TextureRegionDrawable(backRegion),
                new TextureRegionDrawable(backPressedRegion)
        );
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                back();
            }
        });

        // setup tables
        Table contentTable = new Table();
        contentTable.defaults().pad(20f);
        contentTable.setBackground(new TextureRegionDrawable(panelRegion));

        contentTable.add(highScoreText).row();
        contentTable.add(highScoreLabel).row();
        contentTable.add(backButton);

        table.add(contentTable);
        table.center();
        table.setFillParent(true);
        table.pack();

        return table;
    }

    private void back() {
        log.debug("back");
        game.setScreen(new MenuScreen(game));
    }

}
