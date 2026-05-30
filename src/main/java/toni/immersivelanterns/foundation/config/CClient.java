package toni.immersivelanterns.foundation.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class CClient {
    public final ModConfigSpec.BooleanValue leftHandedLanterns;
    public final ModConfigSpec.BooleanValue backLanterns;
    public final ModConfigSpec.BooleanValue enablePhysics;
    public final ModConfigSpec.DoubleValue bounciness;

    public CClient(ModConfigSpec.Builder builder) {
        builder.push("client");

        leftHandedLanterns = builder
                .comment("Whether lantern accessories should switch to the left side or not.")
                .define("Left-Handed Lanterns", false);

        backLanterns = builder
                .comment("Whether lantern accessories should switch to the back of the player or not.")
                .define("Back Lanterns", false);

        enablePhysics = builder
                .comment("No performance impact, just cosmetic.")
                .define("Enable Lantern Swinging Physics", true);

        bounciness = builder
                .comment("How affected by in-world forces lantern physics should be. Default 1f")
                .defineInRange("Lantern Bounciness", 1.0, 0.1, 10.0);

        builder.pop();
    }

    public void onLoad() {
    }

    public void onReload() {
    }
}
