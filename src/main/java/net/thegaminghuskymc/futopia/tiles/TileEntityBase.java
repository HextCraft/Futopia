package net.thegaminghuskymc.futopia.tiles;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.thegaminghuskymc.futopia.utils.test.helpers.TileHelper;
import net.thegaminghuskymc.futopia.utils.test.interfaces.IOrientable;

public class TileEntityBase extends TileEntity implements /*IWailaHeadMessage,*/ IOrientable, IRotatable {

    private String customName;
    private int renderedFragment = 0;
    private NBTTagCompound machineItemData;
    private EnumFacing forward = EnumFacing.NORTH;

    @SuppressWarnings("rawtypes")
	public Packet getDescriptionPacket() {
        NBTTagCompound data = new NBTTagCompound();
        writeToNBT(data);
        initMachineData();
        return new SPacketUpdateTileEntity(this.pos, 1, data);
    }

    @Override
    public void onDataPacket(NetworkManager networkManager, SPacketUpdateTileEntity s35PacketUpdateTileEntity) {
        readFromNBT(s35PacketUpdateTileEntity.getNbtCompound());
        world.markBlockRangeForRenderUpdate(this.pos, this.pos);
        markForUpdate();
    }

    public void initMachineData() {}

    public void markForUpdate() {
        if (this.renderedFragment > 0) {
            this.renderedFragment |= 0x1;
        } else if (this.world != null) {
            Block block = world.getBlockState(this.pos).getBlock();
            //todo: look at this, is it correct?
            this.world.notifyBlockUpdate(this.pos, world.getBlockState(this.pos), world.getBlockState(this.pos), 3);

            int xCoord = this.pos.getX();
            int yCoord = this.pos.getY();
            int zCoord = this.pos.getZ();

            this.world.notifyNeighborsOfStateChange(new BlockPos(xCoord, yCoord - 1, zCoord), block, true);
            this.world.notifyNeighborsOfStateChange(new BlockPos(xCoord, yCoord + 1, zCoord), block, true);
            this.world.notifyNeighborsOfStateChange(new BlockPos(xCoord - 1, yCoord, zCoord), block, true);
            this.world.notifyNeighborsOfStateChange(new BlockPos(xCoord + 1, yCoord, zCoord), block, true);
            this.world.notifyNeighborsOfStateChange(new BlockPos(xCoord, yCoord - 1, zCoord - 1), block, true);
            this.world.notifyNeighborsOfStateChange(new BlockPos(xCoord, yCoord - 1, zCoord + 1), block, true);
        }
    }

    public void markForLightUpdate() {
        if (this.world.isRemote) {
            this.world.notifyBlockUpdate(this.pos, world.getBlockState(this.pos), world.getBlockState(this.pos), 3);
        }

        this.world.checkLightFor(EnumSkyBlock.BLOCK, this.pos);
    }

    public void onChunkLoad() {
        if (this.isInvalid())
            this.validate();

        markForUpdate();
    }

    @Override
    public void onChunkUnload() {
        if (!this.isInvalid())
            this.invalidate();
    }

    public TileEntity getTile() {
        return this;
    }

    public String getCustomName() {
        return this.customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public boolean hasCustomName() {
        return (this.customName != null) && (this.customName.length() > 0);
    }

    public String getUnlocalizedName() {
        Item item = Item.getItemFromBlock(world.getBlockState(this.pos).getBlock());
        ItemStack itemStack = new ItemStack(item, 1, getBlockMetadata());

        return itemStack.getUnlocalizedName() + ".name";
    }

    public void setName(String name) {
        this.customName = name;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        if (this.customName != null)
            nbtTagCompound.setString("CustomName", this.customName);

        if (this.machineItemData != null)
            nbtTagCompound.setTag("MachineItemData", machineItemData);

        if (canRotateVertically()) {
            nbtTagCompound.setInteger("forward", this.forward.ordinal());
        }
        return nbtTagCompound;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        this.customName = nbtTagCompound.hasKey("CustomName") ? nbtTagCompound.getString("CustomName") : null;
        this.machineItemData = nbtTagCompound.hasKey("MachineItemData") ? nbtTagCompound.getCompoundTag("MachineItemData") : null;

        if (canRotateVertically()) {
            this.forward = EnumFacing.values()[nbtTagCompound.getInteger("forward")];
        }
    }

    public NBTTagCompound getMachineItemData() {
        return machineItemData;
    }

    public void setMachineItemData(NBTTagCompound machineItemData) {
        this.machineItemData = machineItemData;
    }

    public IBlockState getBlockState() {
        if (world == null)
            return null;

        return world.getBlockState(pos);
    }

    /*@Override
    public List<String> getWailaHeadToolTip(ItemStack itemStack, List<String> currentTip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        if (customName != null)
            currentTip.add(String.format("%s%s%s", TextFormatting.BLUE, TextFormatting.ITALIC, customName));

        return currentTip;
    }*/

    public EnumFacing getForward() {
        return forward;
    }

    public void dropItems() {
        TileHelper.DropItems(this);
    }

	@Override
	public EnumFacing getFacing() {
		return getForward();
	}

	@Override
	public void setFacing(EnumFacing facing) {
		this.forward = facing;
        markDirty();
        markForUpdate();
	}

	@Override
	public boolean canRotateVertically() {
		return false;
	}
}