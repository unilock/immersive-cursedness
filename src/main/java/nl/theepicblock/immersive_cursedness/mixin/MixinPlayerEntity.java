package nl.theepicblock.immersive_cursedness.mixin;

import net.minecraft.entity.player.PlayerEntity;
import nl.theepicblock.immersive_cursedness.PlayerInterface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class MixinPlayerEntity {
    /**
     * @reason makes it so the portal always takes 1 tick to go through. Even when in survival
     * @author TheEpicBlock_TEB
     */
    @Inject(method = "getMaxNetherPortalTime", at = @At("HEAD"), cancellable = true)
    public void handleGetMaxNetherPortalTime(CallbackInfoReturnable<Integer> cir) {
        if (((PlayerInterface) this).immersivecursedness$getEnabled()) cir.setReturnValue(1);
    }
}
