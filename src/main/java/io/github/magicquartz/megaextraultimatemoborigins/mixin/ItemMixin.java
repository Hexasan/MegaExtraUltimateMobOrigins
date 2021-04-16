package io.github.magicquartz.megaextraultimatemoborigins.mixin;

import io.github.magicquartz.megaextraultimatemoborigins.power.MeumoPowers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {

    @Inject(at = @At("HEAD"), method = "use")
    private void use(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        if(MeumoPowers.EXPLOSIVE_EATER.isActive(user) && user.getHealth() != user.getMaxHealth()) {
            ItemStack item = user.getStackInHand(hand);
            int count = item.getCount();
            if(item.getItem() == Items.TNT_MINECART) {
                user.sendMessage(new LiteralText("You can't eat minecarts!"), true);
            } else if (item.getItem() == Items.GUNPOWDER || item.getItem() == Items.TNT){
                if(item.getItem() == Items.GUNPOWDER) {
                if(count == 1)
                    item = new ItemStack(Items.AIR, 1);
                else
                    item.setCount(count - 1);
                user.setHealth(user.getHealth() + 1F);
            }
                if(item.getItem() == Items.TNT) {
                    if(count == 1)
                        item = new ItemStack(Items.AIR, 1);
                    else
                        item.setCount(count - 1);
                    user.setHealth(user.getHealth() + 6F);
                }
                user.playSound(SoundEvents.ENTITY_PLAYER_BURP, 1.0F, 1.0F);
                user.setStackInHand(hand, item);
            }

        }
    }
}
