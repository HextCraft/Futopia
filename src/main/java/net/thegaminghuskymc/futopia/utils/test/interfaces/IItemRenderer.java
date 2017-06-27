package net.thegaminghuskymc.futopia.utils.test.interfaces;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IItemRenderer {
    @SideOnly(Side.CLIENT)
    void registerItemRenderer();
}