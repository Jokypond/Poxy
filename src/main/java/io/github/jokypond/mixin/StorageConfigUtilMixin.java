package io.github.jokypond.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import me.cortex.voxy.common.config.section.SectionSerializationStorage;
import me.cortex.voxy.common.config.storage.other.CompressionStorageAdaptor;
import me.cortex.voxy.common.config.storage.lmdb.LMDBStorageBackend;

@Mixin(targets = "me.cortex.voxy.common.StorageConfigUtil")
public class StorageConfigUtilMixin {

    // shouldn't have taken me so long to make this work (like 2h and it didn't even work but gemini got it in 10 seconds aaa)
    @ModifyReturnValue(method = "createDefaultSerializer", at = @At("RETURN"))
    private static SectionSerializationStorage.Config changeDefaultStorageBackend(SectionSerializationStorage.Config originalSerializer) {
        if (originalSerializer.storage instanceof CompressionStorageAdaptor.Config compression) {
            compression.delegate = new LMDBStorageBackend.Config();
        }

        return originalSerializer;
    }
}