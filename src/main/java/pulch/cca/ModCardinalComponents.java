package pulch.cca;

import pulch.Pulch;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;
import org.ladysnake.cca.api.v3.entity.RespawnCopyStrategy;

public class ModCardinalComponents implements EntityComponentInitializer {
    public static final ComponentKey<RosenThornComponent> ROSEN_THORN = ComponentRegistry.getOrCreate(Pulch.id("rosen_thorn"), RosenThornComponent.class);
    public static final ComponentKey<WitheredRosenThornComponent> WITHERED_ROSEN_THORN = ComponentRegistry.getOrCreate(Pulch.id("withered_rosen_thorn"), WitheredRosenThornComponent.class);
    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry entityComponentFactoryRegistry) {
        entityComponentFactoryRegistry.registerForPlayers(ROSEN_THORN, RosenThornComponent::new, RespawnCopyStrategy.NEVER_COPY);
        entityComponentFactoryRegistry.registerForPlayers(WITHERED_ROSEN_THORN, WitheredRosenThornComponent::new, RespawnCopyStrategy.NEVER_COPY);
    }
}
