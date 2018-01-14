package net.lustenauer.obstacolavoid.screen.menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Logger;
import net.lustenauer.obstacolavoid.ObstacleAvoidGame;
import net.lustenauer.obstacolavoid.assets.AssetDescriptors;
import net.lustenauer.obstacolavoid.assets.RegionNames;
import net.lustenauer.obstacolavoid.common.GameManager;
import net.lustenauer.obstacolavoid.config.DifficultyLevel;
import net.lustenauer.obstacolavoid.config.GameConfig;

/**
 * Created by Patric Hollenstein on 14.01.18.
 *
 * @author Patric Hollenstein
 */
public class OptionsScreen extends MenuScreenBase {
    private static final Logger log = new Logger(OptionsScreen.class.getName(), Logger.DEBUG);

    private Image checkMark;


    public OptionsScreen(ObstacleAvoidGame game) {
        super(game);
    }

    protected Actor createUi() {
        Table table = new Table();
        table.defaults().pad(15f);

        TextureAtlas gamePlayAtlas = assetManager.get(AssetDescriptors.GAME_PLAY);
        TextureAtlas uiAtlas = assetManager.get(AssetDescriptors.UI);
        BitmapFont font = assetManager.get(AssetDescriptors.FONT);
        Label.LabelStyle labelStyle = new Label.LabelStyle(font, Color.WHITE);

        TextureRegion backgroundRegion = gamePlayAtlas.findRegion(RegionNames.BACKGROUND);
        Image background = new Image(backgroundRegion);


        Label label = new Label("DIFFICULTY", labelStyle);
        label.setPosition(GameConfig.HUD_WIDTH / 2, GameConfig.HUD_HEIGHT / 2 + 180, Align.center);

        final ImageButton easy = createButton(uiAtlas, RegionNames.EASY);
        easy.setPosition(GameConfig.HUD_WIDTH / 2, GameConfig.HUD_HEIGHT / 2 + 90, Align.center);
        easy.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                checkMark.setY(easy.getY() + 25);
                GameManager.INSTANCE.updateDifficultyLevel(DifficultyLevel.EASY);
            }
        });

        final ImageButton medium = createButton(uiAtlas, RegionNames.MEDIUM);
        medium.setPosition(GameConfig.HUD_WIDTH / 2, GameConfig.HUD_HEIGHT / 2, Align.center);
        medium.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                checkMark.setY(medium.getY() + 25);
                GameManager.INSTANCE.updateDifficultyLevel(DifficultyLevel.MEDIUM);
            }
        });

        final ImageButton hard = createButton(uiAtlas, RegionNames.HARD);
        hard.setPosition(GameConfig.HUD_WIDTH / 2, GameConfig.HUD_HEIGHT / 2 - 90, Align.center);
        hard.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                checkMark.setY(hard.getY() + 25);
                GameManager.INSTANCE.updateDifficultyLevel(DifficultyLevel.HARD);
            }
        });

        TextureRegion checkMarkRegion = uiAtlas.findRegion(RegionNames.CHECK_MARK);
        checkMark = new Image(new TextureRegionDrawable(checkMarkRegion));
        checkMark.setPosition(medium.getX() + 50, medium.getY() + 40, Align.center);

        DifficultyLevel difficultyLevel = GameManager.INSTANCE.getDifficultyLevel();

        if (difficultyLevel.isEasy()) {
            checkMark.setY(easy.getY() + 25);
        } else if (difficultyLevel.isHard()) {
            checkMark.setY(hard.getY() + 25);
        }

        ImageButton back = new ImageButton(
                new TextureRegionDrawable(uiAtlas.findRegion(RegionNames.BACK)),
                new TextureRegionDrawable(uiAtlas.findRegion(RegionNames.BACK_PRESSED))

        );
        back.setPosition(GameConfig.HUD_WIDTH / 2, GameConfig.HUD_HEIGHT / 2 - 180, Align.center);
        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                back();
            }
        });


        table.addActor(background);
        table.addActor(label);
        table.addActor(easy);
        table.addActor(medium);
        table.addActor(hard);
        table.addActor(checkMark);
        table.addActor(back);

        return table;
    }

    private void back() {
        log.debug("back");
        game.setScreen(new MenuScreen(game));
    }

    private static ImageButton createButton(TextureAtlas atlas, String regionName) {
        TextureRegion region = atlas.findRegion(regionName);
        return new ImageButton(new TextureRegionDrawable(region));
    }

}
