package io.github.magicquartz.megaextraultimatemoborigins.registry;

import io.github.magicquartz.megaextraultimatemoborigins.Main;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static void register() {

    }

    private static void register(String id, Item item) {
        Registry.register(Registry.ITEM, Main.identifier(id), item);
    }
}
