package brentmaas.buildguide.property;

import java.util.ArrayList;

import com.mojang.blaze3d.matrix.MatrixStack;

import brentmaas.buildguide.screen.BuildGuideScreen;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.AbstractButton;
import net.minecraft.util.text.TextComponent;

public abstract class Property<T> {
	protected int x, y;
	public T value;
	protected TextComponent name;
	public ArrayList<AbstractButton> buttonList = new ArrayList<AbstractButton>();
	public ArrayList<TextFieldWidget> textFieldList = new ArrayList<TextFieldWidget>();
	
	public Property(int x, int y, T value, TextComponent name, Runnable onUpdate){
		this.x = x;
		this.y = y;
		this.value = value;
		this.name = name;
	}
	
	public void onSelectedInGUI() {
		for(AbstractButton b: buttonList) {
			b.visible = true;
		}
		for(TextFieldWidget tfw: textFieldList) {
			tfw.visible = true;
		}
	}
	
	public void onDeselectedInGUI() {
		for(AbstractButton b: buttonList) {
			b.visible = false;
		}
		for(TextFieldWidget tfw: textFieldList) {
			tfw.visible = false;
		}
	}
	
	public void addToBuildGuideScreen(BuildGuideScreen screen) {
		for(AbstractButton b: buttonList) {
			screen.addButtonExternal(b);
		}
		for(TextFieldWidget tfw: textFieldList) {
			screen.addTextFieldExternal(tfw);
		}
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public void setName(TextComponent name) {
		this.name = name;
	}
	
	public boolean mightNeedTextFields() {
		return textFieldList.size() == 0;
	}
	
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks, FontRenderer font) {
		for(TextFieldWidget tfw: textFieldList) {
			tfw.render(matrixStack, mouseX, mouseY, partialTicks);
		}
	}
	
	public abstract void addTextFields(FontRenderer fr);
}
