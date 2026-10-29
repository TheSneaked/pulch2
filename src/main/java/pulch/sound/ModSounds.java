package pulch.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import pulch.Pulch;

public class ModSounds {
    public static final SoundEvent FLOWERY = registerSoundEvent("flowery");
    public static final SoundEvent KNIGHT = registerSoundEvent("knight");
    public static final SoundEvent KNEEL = registerSoundEvent("kneel");





    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Pulch.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        Pulch.LOGGER.info("Registering Mod Sounds for " + Pulch.MOD_ID);
    }
}