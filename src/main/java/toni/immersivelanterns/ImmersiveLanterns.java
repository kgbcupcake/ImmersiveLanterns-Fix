package toni.immersivelanterns;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import toni.immersivelanterns.foundation.config.AllConfigs;

@Mod(ImmersiveLanterns.ID)
public class ImmersiveLanterns {
    public static final String MODNAME = "Immersive Lanterns";
    public static final String ID = "immersivelanterns";

    public ImmersiveLanterns(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        AllConfigs.register(modContainer::registerConfig);

        if (FMLLoader.getDist().isClient()) {
            modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        }
    }

    public static boolean isEquipped(Player player) {
        if (isModLoaded("accessories")) {
            return AccessoriesBridge.isEquipped(player);
        }
        if (isModLoaded("curios")) {
            return CuriosBridge.isEquipped(player);
        }
        return false;
    }

    public static ItemStack getEquipped(Player player) {
        if (isModLoaded("accessories")) {
            return AccessoriesBridge.getEquipped(player);
        }
        if (isModLoaded("curios")) {
            return CuriosBridge.getEquipped(player);
        }
        return null;
    }

    private static boolean isModLoaded(String modId) {
        return net.neoforged.fml.ModList.get().isLoaded(modId);
    }

    public void onInitialize() {
    }

    public void onInitializeClient() {
        if (isModLoaded("accessories")) {
            AccessoriesBridge.register();
        } else if (isModLoaded("curios")) {
            CuriosBridge.register();
        }
    }

    public void commonSetup(FMLCommonSetupEvent event) {
        onInitialize();
    }

    public void clientSetup(FMLClientSetupEvent event) {
        onInitializeClient();
    }

    private static final class AccessoriesBridge {
        static void register() {
            AccessoriesLanternRenderer.register();
        }

        static boolean isEquipped(Player player) {
            return AccessoriesLanternRenderer.isEquipped(player);
        }

        static ItemStack getEquipped(Player player) {
            return AccessoriesLanternRenderer.getEquipped(player);
        }
    }

    private static final class CuriosBridge {
        static void register() {
            LanternCurioRenderer.register();
        }

        static boolean isEquipped(Player player) {
            return LanternCurioRenderer.isEquipped(player);
        }

        static ItemStack getEquipped(Player player) {
            return LanternCurioRenderer.getEquipped(player);
        }
    }
}
