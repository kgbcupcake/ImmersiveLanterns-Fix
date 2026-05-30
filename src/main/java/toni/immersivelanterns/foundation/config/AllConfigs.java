package toni.immersivelanterns.foundation.config;

import toni.immersivelanterns.ImmersiveLanterns;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.function.BiConsumer;

@EventBusSubscriber(modid = ImmersiveLanterns.ID)
public class AllConfigs {

    private static CClient client;
    private static ModConfigSpec clientSpec;

    public static CClient client() {
        return client;
    }

    public static void register(BiConsumer<ModConfig.Type, ModConfigSpec> registration) {
        var pair = new ModConfigSpec.Builder().configure(CClient::new);
        client = pair.getLeft();
        clientSpec = pair.getRight();
        registration.accept(ModConfig.Type.CLIENT, clientSpec);
    }

    @SubscribeEvent
    public static void onLoad(ModConfigEvent.Loading event) {
        if (event.getConfig().getSpec() == clientSpec) {
            client.onLoad();
        }
    }

    @SubscribeEvent
    public static void onReload(ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec() == clientSpec) {
            client.onReload();
        }
    }
}
