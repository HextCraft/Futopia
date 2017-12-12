package net.thegaminghuskymc.futopia.blocks

import net.minecraft.block.material.Material
import net.ndrei.teslacorelib.blocks.OrientedBlock
import net.ndrei.teslacorelib.tileentities.SidedTileEntity
import net.thegaminghuskymc.futopia.Reference
import net.thegaminghuskymc.futopia.init.FTCreativeTabs

/**
 * Created by CF on 2017-06-30.
 */
open class BaseThingyBlock<T : SidedTileEntity> : OrientedBlock<T> {
    protected constructor(registryName: String, teClass: Class<T>)
            : super(Reference.MODID, FTCreativeTabs.machines, registryName, teClass)

    protected constructor(registryName: String, teClass: Class<T>, material: Material)
            : super(Reference.MODID, FTCreativeTabs.machines, registryName, teClass, material)
}