package asewasew.obsidiantools.mixin;

import asewasew.obsidiantools.util.ModTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.world.dimension.NetherPortal;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetherPortal.class)
public class NetherPortalMixin {

	@Shadow
	@Final
	@Mutable
	private static AbstractBlock.ContextPredicate IS_VALID_FRAME_BLOCK;

	@Inject(method = "<clinit>", at = @At("TAIL"))
	private static void modifyStaticPredicate(CallbackInfo ci) {
		IS_VALID_FRAME_BLOCK = (state, world, pos) -> {
			return state.isIn(ModTags.NETHER_PORTAL_FRAME_BLOCKS);
		};
	}
}