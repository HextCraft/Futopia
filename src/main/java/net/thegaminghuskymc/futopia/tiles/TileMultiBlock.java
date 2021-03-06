package net.thegaminghuskymc.futopia.tiles;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.thegaminghuskymc.futopia.Futopia;

public class TileMultiBlock extends TileEntity implements ITickable{
	
    private boolean hasMaster, isMaster;
    public static int masterX, masterY, masterZ;
    
    @Override
    public void update() {
        if (!world.isRemote) {
            if (hasMaster()) { 
                if (isMaster()) {
                	Futopia.LOGGER.fine("This is a multiblock");
                }
            } else {
                // Constantly check if structure is formed until it is.
                if (checkMultiBlockForm())
                    setupStructure();
            }
        }
    }
    
    /** Check that structure is properly formed */
	public boolean checkMultiBlockForm() {
		int i = 0;
		// Scan a 3x3x3 area, starting with the bottom left corner
		for (int x = pos.getX() - 1; x < pos.getX() + 2; x++)
			for (int y = pos.getY(); y < pos.getY() + 3; y++)
				for (int z = pos.getZ() - 1; z < pos.getZ() + 2; z++) {
					TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
					// Make sure tile isn't null, is an instance of the same Tile, and isn't already a part of a multiblock
					if (tile != null && (tile instanceof TileMultiBlock)) {
						if (this.isMaster()) {
							if (((TileMultiBlock)tile).hasMaster())
								i++;
						} else if (!((TileMultiBlock)tile).hasMaster())
							i++;
					}
			}
		// check if there are 26 blocks present ((3*3*3) - 1) and check that center block is empty
		return i > 25 && world.isAirBlock(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()));
	}
 
    /** Setup all the blocks in the structure*/
    public void setupStructure() {
        for (int x = pos.getX() - 1; x < pos.getX() + 2; x++)
            for (int y = pos.getY(); y < pos.getY() + 3; y++)
                for (int z = pos.getZ() - 1; z < pos.getZ() + 2; z++) {
                    TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
                    // Check if block is bottom center block
                    boolean master = (x == pos.getX() && y == pos.getY() && z == pos.getZ());
                    if (tile != null && (tile instanceof TileMultiBlock)) {
                        ((TileMultiBlock) tile).setMasterCoords(pos.getX(), pos.getY(), pos.getZ());
                        ((TileMultiBlock) tile).setHasMaster(true);
                        ((TileMultiBlock) tile).setIsMaster(master);
                    }
                }
    }
 
    /** Reset method to be run when the master is gone or tells them to */
    public void reset() {
        masterX = 0;
        masterY = 0;
        masterZ = 0;
        hasMaster = false;
        isMaster = false;
    }
 
    /** Check that the master exists */
    public boolean checkForMaster() {
        TileEntity tile = world.getTileEntity(new BlockPos(masterX, masterY, masterZ));
        return (tile != null && (tile instanceof TileMultiBlock));
    }
    
    /** Reset all the parts of the structure */
    public void resetStructure() {
        for (int x = pos.getX() - 1; x < pos.getX() + 2; x++)
            for (int y = pos.getY(); y < pos.getY() + 3; y++)
                for (int z = pos.getZ() - 1; z < pos.getZ() + 2; z++) {
                    TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
                    if (tile != null && (tile instanceof TileMultiBlock))
                        ((TileMultiBlock) tile).reset();
                }
    }
 
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setInteger("masterX", masterX);
        data.setInteger("masterY", masterY);
        data.setInteger("masterZ", masterZ);
        data.setBoolean("hasMaster", hasMaster);
        data.setBoolean("isMaster", isMaster);
        if (hasMaster() && isMaster()) {
            // Any other values should ONLY BE SAVED TO THE MASTER
        }
		return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        masterX = data.getInteger("masterX");
        masterY = data.getInteger("masterY");
        masterZ = data.getInteger("masterZ");
        hasMaster = data.getBoolean("hasMaster");
        isMaster = data.getBoolean("isMaster");
        if (hasMaster() && isMaster()) {
            // Any other values should ONLY BE READ BY THE MASTER
        }
    }
 
    public boolean hasMaster() {
        return hasMaster;
    }
 
    public boolean isMaster() {
        return isMaster;
    }
 
    public int getMasterX() {
        return masterX;
    }
 
    public int getMasterY() {
        return masterY;
    }
 
    public int getMasterZ() {
        return masterZ;
    }
 
    public void setHasMaster(boolean bool) {
        hasMaster = bool;
    }
 
    public void setIsMaster(boolean bool) {
        isMaster = bool;
    }
 
    public void setMasterCoords(int x, int y, int z) {
        masterX = x;
        masterY = y;
        masterZ = z;
    }
}