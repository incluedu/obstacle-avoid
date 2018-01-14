package net.lustenauer.obstacolavoid.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by Patric Hollenstein on 10.01.18.
 *
 * @author Patric Hollenstein
 */
public class AssetDescriptors {

    public static final AssetDescriptor<BitmapFont> FONT =
            new AssetDescriptor<BitmapFont>(AssetPaths.UI_FONT, BitmapFont.class);

    public static final AssetDescriptor<TextureAtlas> GAME_PLAY =
            new AssetDescriptor<TextureAtlas>(AssetPaths.GAME_PLAY, TextureAtlas.class);

    public static final AssetDescriptor<TextureAtlas> UI =
            new AssetDescriptor<TextureAtlas>(AssetPaths.UI, TextureAtlas.class);

    private AssetDescriptors() {
    }
}
