package pulch.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stat;
import net.minecraft.util.math.Box;
import pulch.sound.ModSounds;

import java.util.List;

public class SovereignEdge extends Item {

    public SovereignEdge(Settings settings) {
        super(settings);
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!((PlayerEntity) attacker).getItemCooldownManager().isCoolingDown(stack)) {
            Box box = target.getBoundingBox().expand(30.0, 8.0, 30.0);
            List<LivingEntity> list = target.getEntityWorld().getNonSpectatingEntities(LivingEntity.class, box);
            for (LivingEntity livingEntity : list) {
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 255));
                livingEntity.setSneaking(true);
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 140));
                attacker.removeStatusEffect(StatusEffects.GLOWING);
                attacker.removeStatusEffect(StatusEffects.SLOWNESS);
                livingEntity.playSound(ModSounds.KNEEL, 40, 1);
                ((PlayerEntity) attacker).getItemCooldownManager().set(stack, 200);

            }
        }
    }
}
