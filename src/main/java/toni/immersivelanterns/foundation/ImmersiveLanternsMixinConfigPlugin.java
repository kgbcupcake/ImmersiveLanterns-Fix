package toni.immersivelanterns.foundation;

import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.LoadingModList;
import net.neoforged.fml.loading.moddiscovery.ModInfo;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class ImmersiveLanternsMixinConfigPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String s) {
    }

    @Override
    public String getRefMapperConfig() {
        return "";
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.contains("Iris") && !(isModLoaded("iris") || isModLoaded("oculus"))) {
            return false;
        }

        if (mixinClassName.contains("DynamicLights") && !isDynamicLightsLoaded()) {
            return false;
        }

        return true;
    }

    private static boolean isDynamicLightsLoaded() {
        return isModLoaded("lambdynamiclights") || isModLoaded("sodiumdynamiclights");
    }

    public static boolean isIrisRenderingShadows() {
        if (isModLoaded("iris") || isModLoaded("oculus"))
            return IrisBridge.isIrisRenderingShadows();

        return false;
    }

    public static boolean isModLoaded(String modid) {
        if (ModList.get() == null) {
            return LoadingModList.get().getMods().stream().map(ModInfo::getModId).anyMatch(modid::equals);
        }
        return ModList.get().isLoaded(modid);
    }

    @Override
    public void acceptTargets(Set<String> set, Set<String> set1) {
    }

    @Override
    public List<String> getMixins() {
        if (isDynamicLightsLoaded()) {
            return List.of("DynamicLightsMixin");
        }
        return List.of();
    }

    @Override
    public void preApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {
    }

    @Override
    public void postApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {
    }
}
