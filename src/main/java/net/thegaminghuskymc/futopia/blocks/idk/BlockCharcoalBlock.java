package net.thegaminghuskymc.futopia.blocks.idk;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.Reference;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

/**
 * Created by LiLRichy on 7/6/2016.
 */
public class BlockCharcoalBlock extends Block {
    public BlockCharcoalBlock() {
        super(Material.ROCK);
        setUnlocalizedName("charcoal_block");
        setRegistryName(Reference.MODID, "charcoal_block");
        this.setCreativeTab(FTCreativeTabs.main);
        this.setHardness(2f);
        this.setSoundType(SoundType.STONE);
    }

    @Override
    public boolean isFireSource(World world, BlockPos pos, EnumFacing side) {
        return true;
    }
}