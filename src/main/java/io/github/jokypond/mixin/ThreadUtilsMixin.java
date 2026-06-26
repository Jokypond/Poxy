	package io.github.jokypond.mixin;

	import org.spongepowered.asm.mixin.Mixin;
	import org.spongepowered.asm.mixin.injection.Constant;
	import org.spongepowered.asm.mixin.injection.ModifyConstant;

	@Mixin(targets = "me.cortex.voxy.common.util.ThreadUtils")
	public class ThreadUtilsMixin {

		@ModifyConstant(method = "<clinit>", constant = @Constant(stringValue = "libc.so.6"))
		private static String init(String original) {
			return "libc.so";
		}
	}