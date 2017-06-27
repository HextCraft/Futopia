package net.thegaminghuskymc.futopia.tiles;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileBase extends TileEntity implements IRotatable {

    private boolean isRedstonePowered;
    private int outputtingRedstone;
    private int ticker = 0;
    private EnumFacing rotation = EnumFacing.UP;

    @Override
    public void readFromNBT(NBTTagCompound tCompound) {

        super.readFromNBT(tCompound);
        isRedstonePowered = tCompound.getBoolean("isRedstonePowered");
//        readFromPacketNBT(tCompound);
    }

    /**
     * This function gets called whenever the world/chunk is saved
     *
     * @return
     */
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tCompound) {

        super.writeToNBT(tCompound);
        tCompound.setBoolean("isRedstonePowered", isRedstonePowered);

        writeToPacketNBT(tCompound);

        return tCompound;
    }

    /**
     * Tags written in here are synced upon markBlockForUpdate.
     *
     * @param tCompound
     */
    protected void writeToPacketNBT(NBTTagCompound tCompound) {

        tCompound.setByte("rotation", (byte) rotation.ordinal());
        tCompound.setByte("outputtingRedstone", (byte) outputtingRedstone);
    }

//    protected void readFromPacketNBT(NBTTagCompound tCompound) {
//
//        rotation = EnumFacing.random(tCompound.getByte("rotation"));
//        if (rotation.ordinal() > 5) {
//            BluePower.log.warn("invalid rotation!");
//            rotation = ForgeDirection.UP;
//        }
//        outputtingRedstone = tCompound.getByte("outputtingRedstone");
//        if (worldObj != null)
//            markForRenderUpdate();
//    }

//    @Override
//    public Packet getDescriptionPacket() {
//
//        NBTTagCompound tCompound = new NBTTagCompound();
//        writeToPacketNBT(tCompound);
//        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, tCompound);
//    }

//    @Override
//    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
//
//        readFromPacketNBT(pkt.getNbtCompound());
//    }

//    protected void sendUpdatePacket() {
//
//        if (!worldObj.isRemote)
//            worldObj.ma(pos.getX(), pos.getY(), pos.getZ());
//    }

//    protected void markForRenderUpdate() {
//
//        if (worldObj != null)
//            worldObj.markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord);
//    }
//
//    protected void notifyNeighborBlockUpdate() {
//
//        worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, getBlockType());
//    }

    /**
     * Function gets called every tick. Do not forget to call the super method!
     */
//    @Override
//    public void update() {
//
//        if (ticker == 0) {
//            onTileLoaded();
//        }
//        super.updateEntity();
//        ticker++;
//    }

    /**
     * ************** ADDED FUNCTIONS ****************
     */

//    public void onBlockNeighbourChanged() {
//
//        checkRedstonePower();
//    }

    /**
     * Checks if redstone has changed.
     */
//    public void checkRedstonePower() {
//
//        boolean isIndirectlyPowered = getWorld().isBlockIndirectlyGettingPowered(false);
//        if (isIndirectlyPowered && !getIsRedstonePowered()) {
//            redstoneChanged(true);
//        } else if (getIsRedstonePowered() && !isIndirectlyPowered) {
//            redstoneChanged(false);
//        }
//    }

    /**
     * Before being able to use this, remember to mark the block as redstone emitter by calling BlockContainerBase#emitsRedstone()
     *
     * @param newValue
     */
    public void setOutputtingRedstone(boolean newValue) {

        setOutputtingRedstone(newValue ? 15 : 0);
    }

    public int getOutputtingRedstone() {

        return outputtingRedstone;
    }

    /**
     * Before being able to use this, remember to mark the block as redstone emitter by calling BlockContainerBase#emitsRedstone()
     *
     * @param value
     */
    public void setOutputtingRedstone(int value) {

        value = Math.max(0, value);
        value = Math.min(15, value);
        if (outputtingRedstone != value) {
            outputtingRedstone = value;
        }
    }

    /**
     * This method can be overwritten to get alerted when the redstone level has changed.
     *
     * @param newValue The redstone level it is at now
     */
    protected void redstoneChanged(boolean newValue) {

        isRedstonePowered = newValue;
    }

    /**
     * Check whether or not redstone level is high
     */
    public boolean getIsRedstonePowered() {

        return isRedstonePowered;
    }

    /**
     * Returns the ticker of the Tile, this number wll increase every tick
     *
     * @return the ticker
     */
    public int getTicker() {

        return ticker;
    }

    /**
     * Gets called when the TileEntity ticks for the first time, the world is accessible and updateEntity() has not been ran yet
     */
//    protected void onTileLoaded() {
//
//        if (!worldObj.isRemote)
//        	
//    }
    public List<ItemStack> getDrops() {

        return new ArrayList<ItemStack>();
    }

    @Override
    public EnumFacing getFacing() {

        return rotation;
    }

    @Override
    public void setFacing(EnumFacing dir) {

        rotation = dir;
        if (world != null) {

        }
    }

    public boolean canConnectRedstone() {

        return false;
    }

    @Override
    public boolean canRotateVertically() {
        return false;
    }
}