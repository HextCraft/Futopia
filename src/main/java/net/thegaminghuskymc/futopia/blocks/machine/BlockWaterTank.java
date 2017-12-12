package net.thegaminghuskymc.futopia.blocks.machine;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.Reference;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.tiles.TileEntityWaterTank;
import net.thegaminghuskymc.futopia.utils.StringHelper;
import net.thegaminghuskymc.huskylib.blocks.BlockBase;

import javax.annotation.Nullable;
import java.util.List;

public class BlockWaterTank extends BlockBase {

    private static TileEntityWaterTank te = new TileEntityWaterTank();

    public BlockWaterTank() {
        super(Reference.MODID, "water_tank", FTCreativeTabs.machines);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced) {
        if(StringHelper.isShiftKeyDown() == false){
            tooltip.add(StringHelper.shiftForDetails());
        }
        else {
//            tooltip.add("This tank is" + te.getCapacity() / te.getFluidAmount() + "% of " + te.getFluid());
        }
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }

}
