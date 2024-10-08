package brentmaas.buildguide.fabric.screen.widget;

import brentmaas.buildguide.common.screen.widget.ITextField;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.chat.TextComponent;

public class TextFieldImpl extends EditBox implements ITextField {
	public TextFieldImpl(int x, int y, int width, int height, String value) {
		super(Minecraft.getInstance().font, x, y, width, height, new TextComponent(value));
	}
	
	public void setTextValue(String text) {
		setValue(text);
	}
	
	public void setTextColour(int colour) {
		setTextColor(colour);
	}
	
	public void setVisibility(boolean visible) {
		setVisible(visible);
	}
	
	public void setYPosition(int y) {
		this.y = y;
	}
	
	public String getTextValue() {
		return getValue();
	}
}
