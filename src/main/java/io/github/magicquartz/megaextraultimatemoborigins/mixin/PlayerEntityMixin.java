package io.github.magicquartz.megaextraultimatemoborigins.mixin;

import io.github.magicquartz.megaextraultimatemoborigins.power.MeumoPowers;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("HEAD"), method = "damage")
    private void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if(MeumoPowers.CHARGED_STRENGTH.isActive(this)) {
            if(source.equals(DamageSource.LIGHTNING_BOLT)) {
                addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 600, 1));
                addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 0));
                addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 600, 0));
            }
        }
        if(MeumoPowers.CHARGED_STRENGTH.isActive(this)) {
            if(source.equals(DamageSource.ON_FIRE)) {
                int streak = 0;
            }
        }
    }
}
