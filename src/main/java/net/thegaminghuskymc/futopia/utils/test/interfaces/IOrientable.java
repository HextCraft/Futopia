package net.thegaminghuskymc.futopia.utils.test.interfaces;

import net.minecraft.util.EnumFacing;

public interface IOrientable {
    boolean canRotateVertically();

    EnumFacing getForward();

    void setFacing(EnumFacing facing);
}
