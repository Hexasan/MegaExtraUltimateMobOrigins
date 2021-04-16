package io.github.magicquartz.megaextraultimatemoborigins;

import io.github.apace100.origins.power.factory.condition.DamageConditions;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Main implements ModInitializer {
    public static String MOD_ID = "meumo";

    @Override
    public void onInitialize() {
        CustomEntityActions.register();
    }

    public static Identifier identifier(String id) {
        return new Identifier(MOD_ID, id);
    }
}
