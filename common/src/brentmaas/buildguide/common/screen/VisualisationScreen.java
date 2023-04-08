package brentmaas.buildguide.common.screen;

import java.util.Random;

import brentmaas.buildguide.common.BuildGuide;
import brentmaas.buildguide.common.screen.widget.IButton;
import brentmaas.buildguide.common.screen.widget.ISlider;

public class VisualisationScreen extends PropertyScreen {
	private String titleColours = BuildGuide.screenHandler.translate("screen.buildguide.colours");
	private String titleShape = BuildGuide.screenHandler.translate("screen.buildguide.shape");
	private String titleOrigin = BuildGuide.screenHandler.translate("screen.buildguide.origin");
	private String titleRendering = BuildGuide.screenHandler.translate("screen.buildguide.rendering");
	
	private IButton buttonClose;
	private IButton buttonBack = BuildGuide.widgetHandler.createButton(0, 0, 20, 20, "<-", () -> BuildGuide.screenHandler.showScreen(new BuildGuideScreen()));
	private ISlider sliderShapeR = BuildGuide.widgetHandler.createSlider(0, 45, 100, 20, "R", 0.0, 1.0, BuildGuide.stateManager.getState().isShapeAvailable() ? BuildGuide.stateManager.getState().getCurrentShape().colourShapeR : 1.0);
	private ISlider sliderShapeG = BuildGuide.widgetHandler.createSlider(0, 65, 100, 20, "G", 0.0, 1.0, BuildGuide.stateManager.getState().isShapeAvailable() ? BuildGuide.stateManager.getState().getCurrentShape().colourShapeG : 1.0);
	private ISlider sliderShapeB = BuildGuide.widgetHandler.createSlider(0, 85, 100, 20, "B", 0.0, 1.0, BuildGuide.stateManager.getState().isShapeAvailable() ? BuildGuide.stateManager.getState().getCurrentShape().colourShapeB : 1.0);
	private ISlider sliderShapeA = BuildGuide.widgetHandler.createSlider(0, 105, 100, 20, "A", 0.0, 1.0, BuildGuide.stateManager.getState().isShapeAvailable() ? BuildGuide.stateManager.getState().getCurrentShape().colourShapeA : 0.5);
	private ISlider sliderOriginR = BuildGuide.widgetHandler.createSlider(110, 45, 100, 20, "R", 0.0, 1.0, BuildGuide.stateManager.getState().isShapeAvailable() ? BuildGuide.stateManager.getState().getCurrentShape().colourOriginR : 1.0);
	private ISlider sliderOriginG = BuildGuide.widgetHandler.createSlider(110, 65, 100, 20, "G", 0.0, 1.0, BuildGuide.stateManager.getState().isShapeAvailable() ? BuildGuide.stateManager.getState().getCurrentShape().colourOriginG : 1.0);
	private ISlider sliderOriginB = BuildGuide.widgetHandler.createSlider(110, 85, 100, 20, "B", 0.0, 1.0, BuildGuide.stateManager.getState().isShapeAvailable() ? BuildGuide.stateManager.getState().getCurrentShape().colourOriginB : 1.0);
	private ISlider sliderOriginA = BuildGuide.widgetHandler.createSlider(110, 105, 100, 20, "A", 0.0, 1.0, BuildGuide.stateManager.getState().isShapeAvailable() ? BuildGuide.stateManager.getState().getCurrentShape().colourOriginA : 0.5);
	private IButton buttonSetShape = BuildGuide.widgetHandler.createButton(0, 125, 100, 20, BuildGuide.screenHandler.translate("screen.buildguide.set"), () -> {
		if(BuildGuide.stateManager.getState().isShapeAvailable()) {
			BuildGuide.stateManager.getState().setShapeColour((float) sliderShapeR.getSliderValue(), (float) sliderShapeG.getSliderValue(), (float) sliderShapeB.getSliderValue(), (float) sliderShapeA.getSliderValue());
		}
	});
	private IButton buttonSetOrigin = BuildGuide.widgetHandler.createButton(110, 125, 100, 20, BuildGuide.screenHandler.translate("screen.buildguide.set"), () -> {
		if(BuildGuide.stateManager.getState().isShapeAvailable()) {
			BuildGuide.stateManager.getState().setOriginColour((float) sliderOriginR.getSliderValue(), (float) sliderOriginG.getSliderValue(), (float) sliderOriginB.getSliderValue(), (float) sliderOriginA.getSliderValue());
		}
	});
	private IButton buttonSetShapeRandom = BuildGuide.widgetHandler.createButton(0, 145, 100, 20, BuildGuide.screenHandler.translate("screen.buildguide.setrandom"), () -> {
		if(BuildGuide.stateManager.getState().isShapeAvailable()) {
			Random random = new Random();
			sliderShapeR.setSliderValue(random.nextDouble());
			sliderShapeG.setSliderValue(random.nextDouble());
			sliderShapeB.setSliderValue(random.nextDouble());
			BuildGuide.stateManager.getState().setShapeColour((float) sliderShapeR.getSliderValue(), (float) sliderShapeG.getSliderValue(), (float) sliderShapeB.getSliderValue(), (float) sliderShapeA.getSliderValue());
		}
	});
	private IButton buttonSetOriginRandom = BuildGuide.widgetHandler.createButton(110, 145, 100, 20, BuildGuide.screenHandler.translate("screen.buildguide.setrandom"), () -> {
		if(BuildGuide.stateManager.getState().isShapeAvailable()) {
			Random random = new Random();
			sliderOriginR.setSliderValue(random.nextDouble());
			sliderOriginG.setSliderValue(random.nextDouble());
			sliderOriginB.setSliderValue(random.nextDouble());
			BuildGuide.stateManager.getState().setOriginColour((float) sliderOriginR.getSliderValue(), (float) sliderOriginG.getSliderValue(), (float) sliderOriginB.getSliderValue(), (float) sliderOriginA.getSliderValue());
		}
	});
	private IButton buttonDefaultShape = BuildGuide.widgetHandler.createButton(0, 165, 100, 20, BuildGuide.screenHandler.translate("screen.buildguide.default"), () -> {
		sliderShapeR.setSliderValue(1.0);
		sliderShapeG.setSliderValue(1.0);
		sliderShapeB.setSliderValue(1.0);
		sliderShapeA.setSliderValue(0.5);
		sliderShapeR.updateText();
		sliderShapeG.updateText();
		sliderShapeB.updateText();
		sliderShapeA.updateText();
		if(BuildGuide.stateManager.getState().isShapeAvailable()) {
			BuildGuide.stateManager.getState().setShapeColour(1.0f, 1.0f, 1.0f, 0.5f);
		}
	});
	private IButton buttonDefaultOrigin = BuildGuide.widgetHandler.createButton(110, 165, 100, 20, BuildGuide.screenHandler.translate("screen.buildguide.default"), () -> {
		sliderOriginR.setSliderValue(1.0);
		sliderOriginG.setSliderValue(0.0);
		sliderOriginB.setSliderValue(0.0);
		sliderOriginA.setSliderValue(0.5);
		sliderOriginR.updateText();
		sliderOriginG.updateText();
		sliderOriginB.updateText();
		sliderOriginA.updateText();
		if(BuildGuide.stateManager.getState().isShapeAvailable()) {
			BuildGuide.stateManager.getState().setOriginColour(1.0f, 0.0f, 0.0f, 0.5f);
		}
	});
	
	public VisualisationScreen() {
		super(BuildGuide.screenHandler.translate("screen.buildguide.visualisation"));
	}
	
	public void init() {
		super.init();
		
		buttonClose = BuildGuide.widgetHandler.createButton(wrapper.getWidth() - 20, 0, 20, 20, "X", () -> BuildGuide.screenHandler.showScreen(null));
		
		if(!BuildGuide.stateManager.getState().isShapeAvailable()) {
			sliderShapeR.setActive(false);
			sliderShapeG.setActive(false);
			sliderShapeB.setActive(false);
			sliderShapeA.setActive(false);
			sliderOriginR.setActive(false);
			sliderOriginG.setActive(false);
			sliderOriginB.setActive(false);
			sliderOriginA.setActive(false);
			buttonSetShape.setActive(false);
			buttonDefaultShape.setActive(false);
			buttonSetOrigin.setActive(false);
			buttonDefaultOrigin.setActive(false);
		}
		
		addButton(buttonClose);
		addButton(buttonBack);
		addSlider(sliderShapeR);
		addSlider(sliderShapeG);
		addSlider(sliderShapeB);
		addSlider(sliderShapeA);
		addSlider(sliderOriginR);
		addSlider(sliderOriginG);
		addSlider(sliderOriginB);
		addSlider(sliderOriginA);
		addButton(buttonSetShape);
		addButton(buttonDefaultShape);
		addButton(buttonSetShapeRandom);
		addButton(buttonSetOriginRandom);
		addButton(buttonSetOrigin);
		addButton(buttonDefaultOrigin);
		
		BuildGuide.stateManager.getState().propertyAdvancedModeRandomColours.setSlot(3);
		addProperty(BuildGuide.stateManager.getState().propertyAdvancedModeRandomColours);
		BuildGuide.stateManager.getState().propertyDepthTest.setSlot(5);
		addProperty(BuildGuide.stateManager.getState().propertyDepthTest);
	}
	
	public void render() {
		super.render();
		drawShadowCentred(title, wrapper.getWidth() / 2, 5, 0xFFFFFF);
		drawShadowCentred(titleColours, 105, 15, 0xFFFFFF);
		drawShadowCentred(titleShape, 50, 35, 0xFFFFFF);
		drawShadowCentred(titleOrigin, 160, 35, 0xFFFFFF);
		drawShadowCentred(titleRendering, 80, 215, 0xFFFFFF);
	}
}
