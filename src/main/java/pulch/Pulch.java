package pulch;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pulch.component.ModDataComponentTypes;
import pulch.item.ModItemGroups;
import pulch.item.ModItems;
import pulch.sound.ModSounds;

public class Pulch implements ModInitializer {
	public static final String MOD_ID = "pulch";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModDataComponentTypes.registerDataComponentTypes();
		ModSounds.registerSounds();

		LOGGER.info("Hello Fabric world!");
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
