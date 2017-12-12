package net.thegaminghuskymc.futopia.client.gui.machines;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import net.thegaminghuskymc.futopia.Reference;
import net.thegaminghuskymc.huskylib.client.gui.EnumRenderType;
import net.thegaminghuskymc.huskylib.client.gui.GuiContainerBase;
import net.thegaminghuskymc.huskylib.client.gui.HLBuilder;

@SuppressWarnings("deprecation")
public class GuiGeneratorBase extends GuiContainerBase {

	private String name;

	private HLBuilder builder = new HLBuilder();

	public GuiGeneratorBase(Container container, String name) {
		super(container);
		this.name = name;

		xSize = 176;
		ySize = 190;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager()
				.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/container/generator.png"));
		final int k = (this.width - this.xSize) / 2;
		final int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

		// this.drawBackground(new Point2i(k, l), new Point2i(176, 190),
		// GuiContainerBase.ALIGNMENT_NONE);

		this.drawEnergyBar(this, this.guiLeft + 151, this.guiTop + 10, 50, 500, 1000, mouseX, mouseY, "Tesla");

		drawBurnBar(this, 5, this.guiLeft + 40, this.guiTop + 40, mouseX, mouseY);

		drawProgressBar(this, 8, this.guiLeft + 40, this.guiTop + 70, mouseX, mouseY);

		builder.drawJEIButton(this, 10, 10, EnumRenderType.BACKGROUND);

		// builder.drawFluid(this, new FluidStack(FluidRegistry.LAVA, 100), x,
		// y, mouseY, k, maxCapacity);

		// this.drawPowerBar(new Point2i(this.guiLeft + 151, this.guiTop),
		// GuiContainerBase.BACKGROUND_LIGHT, GuiContainerBase.POWER_MT,
		// 5000000, 10000000);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		final String name = this.name + " Generator";
		this.fontRenderer.drawString(name, this.xSize / 2 - this.fontRenderer.getStringWidth(name) / 2, 6, 4210752);
		this.fontRenderer.drawString(I18n.translateToLocalFormatted("container.inventory"), 8,
				this.ySize - 96 + 2, 4210752);

		/*
		 * this.fontRenderer.drawString(PowerSystem.getLocaliszedPower(generator
		 * .euOut) + "/t", 10, 20, Color.WHITE.getRGB());
		 * this.fontRenderer.drawString(PowerSystem.getLocaliszedPower(generator
		 * .storedEu), 10, 30, Color.WHITE.getRGB());
		 * this.fontRenderer.drawString(PowerSystem.getLocaliszedPower(generator
		 * .euChange) + " change", 10, 40, Color.WHITE.getRGB());
		 * this.fontRenderer.drawString(PowerSystem.getLocaliszedPower(generator
		 * .euStorage) + " max", 10, 60, Color.WHITE.getRGB());
		 */

		this.drawGradientRect(this.guiLeft + 10, this.guiTop + 10, this.guiLeft + 10, this.guiTop + 100, 0x00E0E0,
				0x37DD00);
	}

	@Override
	public void updateScreen() {
		super.updateScreen();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		this.renderHoveredToolTip(mouseX, mouseY);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

}
