package io.github.jokypond.mixin;

import org.spongepowered.asm.mixin.Mixin;
import com.llamalad7.mixinextras.sugar.Local;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import me.cortex.voxy.common.config.storage.lmdb.LMDBStorageBackend;
import me.cortex.voxy.common.config.storage.other.CompressionStorageAdaptor;
import me.cortex.voxy.common.config.section.SectionSerializationStorage;


@Mixin(targets = "me.cortex.voxy.common.StorageConfigUtil")
public class StorageConfigUtilMixin {

    // awesome it works????
    @Inject(method = "createDefaultSerializer", at = @At("TAIL"))
    private static void createDefaultSerializer(CallbackInfoReturnable<SectionSerializationStorage.Config> cir, @Local(name = "compression") CompressionStorageAdaptor.Config compression) {
        compression.delegate = new LMDBStorageBackend.Config();
    }
}