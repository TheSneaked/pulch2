package pulch.cca;

import pulch.item.ModItems;
import pulch.sound.ModSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.math.Vec3d;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import org.ladysnake.cca.api.v3.component.tick.CommonTickingComponent;


public class RosenThornComponent implements CommonTickingComponent, AutoSyncedComponent {
    private static final String ATTACHED = ("attached");
    private final PlayerEntity player;
    private int time = 0;
    private int attached = -1;

    public RosenThornComponent(PlayerEntity player) {
        this.player = player;


    }


    @Override
    public void tick() {
        if (this.getAttached() != null) {
            if (time > 0) {
                time--;
            }
            double distance = this.player.distanceTo(this.getAttached());
            Vec3d velocity = new Vec3d(player.getX() - this.getAttached().getX(), player.getY() - this.getAttached().getY(), player.getZ() - this.getAttached().getZ());
            this.getAttached().addVelocity(velocity.multiply(distance).multiply(1 / 128f));


            Vec3d toAttached = this.player.getEntityPos().subtract(this.getAttached().getEntityPos());
            float v = (float) (1 / distance);
            for (float i = 0; i < 1; i += v) {
                Vec3d particlePos = this.getAttached().getEntityPos().add(toAttached.multiply(i));
                this.player.getEntityWorld().addParticleClient(new DustParticleEffect(0x33cc33, 1), particlePos.x, particlePos.y, particlePos.z, 1, 0, 0);

            }
            if (!this.player.getEntityWorld().isClient()) {
                if (time == 0 && distance <= Math.max(player.getBoundingBox().getAverageSideLength(), this.getAttached().getBoundingBox().getAverageSideLength()) * 2) {
                    this.setAttached(null);
                }

                if (!player.isHolding(ModItems.ROSEN_THORN) && !player.isHolding(ModItems.BLUE_ROSEN_THORN)) {
                    this.setAttached(null);
                }
            }
        }
    }

    public void setAttached(LivingEntity livingEntity) {

        if (livingEntity != null) {
            this.attached = livingEntity.getId();
            this.getAttached().playSound(ModSounds.FLOWERY, 1, 1);
            time = 40;

        } else {
            this.attached = -1;
        }
        ModCardinalComponents.ROSEN_THORN.sync(player);
    }

    public LivingEntity getAttached() {
        if (this.player.getEntityWorld().getEntityById(this.attached) instanceof LivingEntity living) {
            return living;
        }
        return null;
    }

    @Override
    public void readData(ReadView readView) {
        this.attached = readView.getInt(ATTACHED, -1);


    }

    @Override
    public void writeData(WriteView writeView) {
        writeView.putInt(ATTACHED, this.attached);
    }
}



