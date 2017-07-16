package net.thegaminghuskymc.futopia.client.gui.computers;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.client.container.computers.ContainerDiskDrive;
import net.thegaminghuskymc.huskylib.client.gui.GuiContainerBase;

public class GuiDiskDrive extends GuiContainerBase {

	private static ResourceLocation texture_normal = new ResourceLocation(Refs.MODID,
			"textures/gui/container/disk_drive.png");
	@SuppressWarnings("unused")
	private static ResourceLocation texture_red = new ResourceLocation(Refs.MODID,
			"textures/gui/container/disk_drive.png");
	@SuppressWarnings("unused")
	private static ResourceLocation texture_blue = new ResourceLocation(Refs.MODID,
			"textures/gui/container/disk_drive.png");
	@SuppressWarnings("unused")
	private static ResourceLocation texture_purple = new ResourceLocation(Refs.MODID,
			"textures/gui/container/disk_drive.png");
	@SuppressWarnings("unused")
	private static ResourceLocation texture_pink = new ResourceLocation(Refs.MODID,
			"textures/gui/container/disk_drive.png");
	@SuppressWarnings("unused")
	private static ResourceLocation texture_yellow = new ResourceLocation(Refs.MODID,
			"textures/gui/container/disk_drive.png");
	@SuppressWarnings("unused")
	private static ResourceLocation texture_orange = new ResourceLocation(Refs.MODID,
			"textures/gui/container/disk_drive.png");
	@SuppressWarnings("unused")
	private static ResourceLocation texture_light_blue = new ResourceLocation(Refs.MODID,
			"textures/gui/container/disk_drive.png");

	public GuiDiskDrive(InventoryPlayer playerInventory) {
		super(new ContainerDiskDrive(playerInventory));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture_normal);
		int i = this.guiLeft;
		int j = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
	}

	@Override
	public void updateScreen() {
		super.updateScreen();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString(I18n.format("Disk Drive"), 28, 6, 0x00DB00);
		this.fontRenderer.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 0x00DB00);
	}

}
