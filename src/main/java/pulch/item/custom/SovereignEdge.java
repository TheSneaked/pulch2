package pulch.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stat;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import pulch.item.ModItems;
import pulch.sound.ModSounds;

import java.util.List;

public class SovereignEdge extends Item {

    public SovereignEdge(Settings settings) {
        super(settings);
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!((PlayerEntity) attacker).getItemCooldownManager().isCoolingDown(stack)) {
            target.setFireTicks(120);
            Box box = target.getBoundingBox().expand(15.0, 3.0, 15.0);
            List<LivingEntity> list = target.getEntityWorld().getNonSpectatingEntities(LivingEntity.class, box);
            for (LivingEntity livingEntity : list) {
                if (livingEntity instanceof  PlayerEntity player){
                    if (!player.getOffHandStack().isOf(ModItems.ROYAL_PARDON)) {
                        livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 255));
                        livingEntity.setSneaking(true);
                        livingEntity.setVelocity(0,-200,0);
                        livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 140));
                        attacker.removeStatusEffect(StatusEffects.GLOWING);
                        attacker.removeStatusEffect(StatusEffects.SLOWNESS);
                        livingEntity.playSound(ModSounds.KNEEL, 40, 1);
                        ((PlayerEntity) attacker).getItemCooldownManager().set(stack, 200);

                    }
                }

}

        }
    }
    @Override
    public Text getName(ItemStack stack) {
        return Text.translatable(this.getTranslationKey()).setStyle(Style.EMPTY.withColor(0xeed67c ));
    }
}

