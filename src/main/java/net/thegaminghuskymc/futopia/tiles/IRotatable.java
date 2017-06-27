package net.thegaminghuskymc.futopia.tiles;

import net.minecraft.util.EnumFacing;

public interface IRotatable {
    EnumFacing getFacing();

    void setFacing(EnumFacing facing);

    boolean canRotateVertically();
}
