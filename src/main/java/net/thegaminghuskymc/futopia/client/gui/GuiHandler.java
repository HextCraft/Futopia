package net.thegaminghuskymc.futopia.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.thegaminghuskymc.futopia.client.container.computers.ContainerCPU;
import net.thegaminghuskymc.futopia.client.container.computers.ContainerController;
import net.thegaminghuskymc.futopia.client.container.computers.ContainerDiskDrive;
import net.thegaminghuskymc.futopia.client.container.computers.ContainerFilter;
import net.thegaminghuskymc.futopia.client.container.computers.ContainerMonitor;
import net.thegaminghuskymc.futopia.client.container.computers.ContainerProjectTable;
import net.thegaminghuskymc.futopia.client.container.machines.ContainerFurnaceBase;
import net.thegaminghuskymc.futopia.client.container.machines.ContainerParticleEmitter;
import net.thegaminghuskymc.futopia.client.gui.computers.GuiCPU;
import net.thegaminghuskymc.futopia.client.gui.computers.GuiController;
import net.thegaminghuskymc.futopia.client.gui.computers.GuiDiskDrive;
import net.thegaminghuskymc.futopia.client.gui.computers.GuiFilter;
import net.thegaminghuskymc.futopia.client.gui.computers.GuiMonitor;
import net.thegaminghuskymc.futopia.client.gui.computers.GuiProjectTable;
import net.thegaminghuskymc.futopia.client.gui.machines.GuiFurnaceBase;
import net.thegaminghuskymc.futopia.client.gui.machines.GuiParticleEmitter;
import net.thegaminghuskymc.futopia.tiles.TileDiskDrive;

public class GuiHandler implements IGuiHandler {

	public static final int GUIID_BASE = 0;
	public static final int PROJECT_TABLE = 1;
	public static final int CONTROLLER = 2;
	public static final int DISK_DRIVE = 3;
	public static final int FILTER = 4;
	public static final int MONITOR = 5;
	public static final int FURNACE_BASE = 6;
	public static final int CPU = 7;
	public static final int PARTICLE_EMITTER = 8;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == PROJECT_TABLE) {
			return new ContainerProjectTable(player.inventory, world);
		}
		if (ID == CONTROLLER) {
			return new ContainerController();
		}
		if (ID == MONITOR) {
			return new ContainerMonitor();
		}
		if (ID == FILTER) {
			return new ContainerFilter();
		}
		if (ID == DISK_DRIVE) {
			return new ContainerDiskDrive(player.inventory);
		}
		if (ID == FURNACE_BASE) {
			return new ContainerFurnaceBase();
		}
		if (ID == CPU) {
			return new ContainerCPU();
		}
		if (ID == PARTICLE_EMITTER) {
			return new ContainerParticleEmitter();
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == PROJECT_TABLE) {
			return new GuiProjectTable(player.inventory, world);
		}
		if (ID == CONTROLLER) {
			return new GuiController();
		}
		if (ID == MONITOR) {
			return new GuiMonitor();
		}
		if (ID == FILTER) {
			return new GuiFilter();
		}
		if (ID == DISK_DRIVE) {
			return new GuiDiskDrive(player.inventory);
		}
		if (ID == FURNACE_BASE) {
			return new GuiFurnaceBase();
		}
		if (ID == CPU) {
			return new GuiCPU();
		}
		if (ID == PARTICLE_EMITTER) {
			return new GuiParticleEmitter();
		}

		return null;
	}

}
