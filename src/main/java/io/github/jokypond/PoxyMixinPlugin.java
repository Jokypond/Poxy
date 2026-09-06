package io.github.jokypond;

import com.google.common.collect.ImmutableMap;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

// Taken from https://github.com/Juuxel/Adorn

// https://github.com/FabricMC/fabric-loader/issues/188
/** :irritatered: */
public final class PoxyMixinPlugin implements IMixinConfigPlugin {
    private static final Supplier<Boolean> TRUE = () -> true;

    /* I'm not sure what person with an ARM64 computer and an actual Linux desktop installed
   would have this mod installed, but unfortunately I don't know if there is a way to prevent
   the loading of my custom LMDB and ZSTD libraries for those devices.
   */

    public static boolean isAndroid() {

        File f = new File("/system/lib64/libandroid.so");
        return f.exists();
    }

    private static final Map<String, Supplier<Boolean>> CONDITIONS = ImmutableMap.of(
            "io.github.jokypond.mixin.StorageConfigUtilMixin", PoxyMixinPlugin::isAndroid,
            "io.github.jokypond.mixin.ThreadUtilsMixin", PoxyMixinPlugin::isAndroid
    );

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return CONDITIONS.getOrDefault(mixinClassName, TRUE).get();
    }

    // Boilerplate

    @Override
    public void onLoad(String mixinPackage) {

    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}