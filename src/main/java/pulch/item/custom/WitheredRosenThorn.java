package pulch.item.custom;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import pulch.cca.ModCardinalComponents;
import pulch.component.ModDataComponentTypes;
import pulch.sound.ModSounds;

public class WitheredRosenThorn extends Item {
    public WitheredRosenThorn(Settings settings) {
        super(settings);
    }

    private static final int ITEM_BAR_COLOR = MathHelper.hsvToRgb(0.1F, 0.1F, 0.6F);
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker == target.getAttacker()) {
            setPressureCount(stack, (int) (getPressureCount(stack) + 2.6f));
            System.out.println(ModDataComponentTypes.PRESSURE_COUNT);
            if (getPressureCount(stack) >= 13) {
                if (attacker instanceof PlayerEntity player) {
                    ModCardinalComponents.WITHERED_ROSEN_THORN.get(player).setAttached(target);
                }

                setPressureCount(stack, 0);
            }
        }

    }
    public int getPressureCount(ItemStack stack) { return stack.getOrDefault(ModDataComponentTypes.PRESSURE_COUNT, 0);}
    public void setPressureCount(ItemStack stack, int value) { stack.set(ModDataComponentTypes.PRESSURE_COUNT, Math.clamp(value, 0,13));}
    public boolean isItemBarVisible(ItemStack stack) {
        return getPressureCount(stack) > -1;
    }
    public int getItemBarStep(ItemStack stack) {

        return getPressureCount(stack);

    }
    public int getItemBarColor(ItemStack stack) {
        return ITEM_BAR_COLOR;
    }
    @Override
    public Text getName(ItemStack stack) {
        return Text.translatable(this.getTranslationKey()).setStyle(Style.EMPTY.withColor(0x42352e ));
    }
}



