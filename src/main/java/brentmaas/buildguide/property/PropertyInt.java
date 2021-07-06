package brentmaas.buildguide.property;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class PropertyInt extends Property<Integer>{
	private TextFieldWidget valueWidget;
	
	public PropertyInt(int x, int y, int value, TextComponent name, Runnable onUpdate) {
		super(x, y, value, name, onUpdate);
		buttonList.add(new Button(x + 90, y, 20, 20, new StringTextComponent("-"), button -> {
			--this.value;
			valueWidget.setText("" + this.value);
			if(onUpdate != null) onUpdate.run();
		}));
		buttonList.add(new Button(x + 190, y, 20, 20, new StringTextComponent("+"), button -> {
			++this.value;
			valueWidget.setText("" + this.value);
			if(onUpdate != null) onUpdate.run();
		}));
		buttonList.add(new Button(x + 160, y, 30, 20, new TranslationTextComponent("screen.buildguide.set"), button -> {
			try {
				int newval = Integer.parseInt(valueWidget.getText());
				this.value = newval;
				valueWidget.setTextColor(0xFFFFFF);
			}catch(NumberFormatException e) {
				valueWidget.setTextColor(0xFF0000);
			}
		}));
	}
	
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks, FontRenderer font) {
		super.render(matrixStack, mouseX, mouseY, partialTicks, font);
		font.drawStringWithShadow(matrixStack, name.getString(), x + 5, y + 5, 0xFFFFFF);
	}
	
	public void setValue(Integer value) {
		super.setValue(value);
		valueWidget.setText("" + value);
	}
	
	public void addTextFields(FontRenderer fr) {
		valueWidget = new TextFieldWidget(fr, x + 110, y, 50, 20, new StringTextComponent(""));
		valueWidget.setText("" + value);
		valueWidget.setTextColor(0xFFFFFF);
		textFieldList.add(valueWidget);
	}
}
