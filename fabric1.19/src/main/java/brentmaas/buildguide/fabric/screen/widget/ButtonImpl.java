package brentmaas.buildguide.fabric.screen.widget;

import brentmaas.buildguide.common.screen.widget.IButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

public class ButtonImpl extends Button implements IButton {
	public void setVisibility(boolean visible) {
		this.visible = visible;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public ButtonImpl(int x, int y, int width, int height, String text, IButton.IPressable onPress) {
		super(x, y, width, height, Component.literal(text), button -> onPress.onPress());
	}
	
	public void setYPosition(int y) {
		this.y = y;
	}
}
