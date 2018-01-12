package net.lustenauer.obstacolavoid.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by Patric Hollenstein on 10.01.18.
 *
 * @author Patric Hollenstein
 */
public class AssetDescriptors {

    public static final AssetDescriptor<BitmapFont> FONT =
            new AssetDescriptor<BitmapFont>(AssetPaths.UI_FONT, BitmapFont.class);

    public static final AssetDescriptor<Texture> BACKGROUND =
            new AssetDescriptor<Texture>(AssetPaths.BACKGROUND, Texture.class);
    public static final AssetDescriptor<Texture> OBSTACLE =
            new AssetDescriptor<Texture>(AssetPaths.OBSTACLE, Texture.class);
    public static final AssetDescriptor<Texture> PLAYER =
            new AssetDescriptor<Texture>(AssetPaths.PLAYER, Texture.class);


    private AssetDescriptors() {
    }
}
