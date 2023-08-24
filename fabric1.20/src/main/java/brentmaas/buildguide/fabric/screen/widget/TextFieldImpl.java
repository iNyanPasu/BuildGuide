package brentmaas.buildguide.fabric.screen.widget;

import brentmaas.buildguide.common.screen.widget.ITextField;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;

public class TextFieldImpl extends TextFieldWidget implements ITextField {
	public TextFieldImpl(int x, int y, int width, int height, String value) {
		super(MinecraftClient.getInstance().textRenderer, x, y, width, height, Text.literal(value));
	}
	
	public void setTextValue(String text) {
		setText(text);
	}
	
	public void setTextColour(int colour) {
		setEditableColor(colour);
	}
	
	public void setVisibility(boolean visible) {
		setVisible(visible);
	}
	
	public void setYPosition(int y) {
		super.setY(y);
	}
	
	public String getTextValue() {
		return getText();
	}
}
