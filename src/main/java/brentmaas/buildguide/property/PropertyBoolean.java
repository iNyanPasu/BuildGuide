package brentmaas.buildguide.property;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.button.CheckboxButton;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;

public class PropertyBoolean extends Property<Boolean>{
	private CheckboxButton button;
	
	public PropertyBoolean(int x, int y, Boolean value, TextComponent name, Runnable onUpdate) {
		super(x, y, value, name, onUpdate);
		button = new CheckboxButton(x + 120, y, 20, 20, new StringTextComponent(""), value, false);
		buttonList.add(button);
	}
	
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks, FontRenderer font) {
		value = button.isChecked();
		font.drawStringWithShadow(matrixStack, name.getString(), x + 5, y + 5, 0xFFFFFF);
	}
}
