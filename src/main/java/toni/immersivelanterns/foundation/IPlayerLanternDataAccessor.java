package toni.immersivelanterns.foundation;

import net.minecraft.world.phys.Vec3;

public interface IPlayerLanternDataAccessor {
    void immersiveLanterns$setLastHipPosition(Vec3 val);

    Vec3 immersiveLanterns$getLastHipPosition();

    void immersiveLanterns$setWasCrouching(boolean val);

    boolean immersiveLanterns$getWasCrouching();

    void immersiveLanterns$setZAngle(float val);

    float immersiveLanterns$getZAngle();

    void immersiveLanterns$setZVel(float val);

    float immersiveLanterns$getZVel();

    void immersiveLanterns$setXAngle(float val);

    float immersiveLanterns$getXAngle();

    void immersiveLanterns$setXVel(float val);

    float immersiveLanterns$getXVel();
}
