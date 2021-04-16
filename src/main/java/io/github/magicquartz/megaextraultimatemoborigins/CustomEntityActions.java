package io.github.magicquartz.megaextraultimatemoborigins;

import io.github.apace100.origins.power.factory.action.ActionFactory;
import io.github.apace100.origins.registry.ModRegistries;
import io.github.apace100.origins.util.SerializableData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.explosion.Explosion;

public class CustomEntityActions {
    public static void register() {
        register(new ActionFactory<>(Main.identifier("summon_explosion"), new SerializableData(),
                (data, entity) -> {
                    LivingEntity user = (LivingEntity) entity;
                    if(user.hasStatusEffect(StatusEffects.STRENGTH)) {
                        if(user.getStatusEffect(StatusEffects.STRENGTH).getAmplifier() == 1) {
                            entity.world.createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(),6f, Explosion.DestructionType.DESTROY);
                        }
                    } else {
                        entity.world.createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(),3f, Explosion.DestructionType.DESTROY);
                    }
                }
        ));
    }

    private static void register(ActionFactory<Entity> actionFactory) {
        Registry.register(ModRegistries.ENTITY_ACTION, actionFactory.getSerializerId(), actionFactory);
    }
}
