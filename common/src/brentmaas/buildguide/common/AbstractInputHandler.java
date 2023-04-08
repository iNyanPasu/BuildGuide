package brentmaas.buildguide.common;

import brentmaas.buildguide.common.screen.BuildGuideScreen;
import brentmaas.buildguide.common.screen.ShapelistScreen;
import brentmaas.buildguide.common.screen.VisualisationScreen;
import brentmaas.buildguide.common.shape.Shape;
import brentmaas.buildguide.common.shape.Shape.Origin;

public abstract class AbstractInputHandler {
	private IKeyBind openBuildGuide;
	private IKeyBind openShapelist;
	private IKeyBind openVisualisation;
	private IKeyBind toggleEnable;
	private IKeyBind setOrigin;
	private IKeyBind setGlobalOrigin;
	
	public abstract IKeyBind registerKeyBind(String name, int keyCode);
	public abstract void registerOnKeyInput();
	
	public void register() {
		openBuildGuide = registerKeyBind("key.buildguide.openbuildguide", KeyCode.GLFW_KEY_B);
		openShapelist = registerKeyBind("key.buildguide.openshapelist", KeyCode.GLFW_KEY_UNKNOWN);
		openVisualisation = registerKeyBind("key.buildguide.openvisualisation", KeyCode.GLFW_KEY_UNKNOWN);
		toggleEnable = registerKeyBind("key.buildguide.toggleenable", KeyCode.GLFW_KEY_UNKNOWN);
		setOrigin = registerKeyBind("key.buildguide.setorigin", KeyCode.GLFW_KEY_UNKNOWN);
		setGlobalOrigin = registerKeyBind("key.buildguide.setglobalorigin", KeyCode.GLFW_KEY_UNKNOWN);
	}
	
	public void onKeyInput() {
		if(openBuildGuide.isDown()) {
			BuildGuide.screenHandler.showScreen(new BuildGuideScreen());
		}
		
		if(openShapelist.isDown() && BuildGuide.stateManager.getState().propertyAdvancedMode.value) {
			BuildGuide.screenHandler.showScreen(new ShapelistScreen());
		}
		
		if(openVisualisation.isDown()) {
			BuildGuide.screenHandler.showScreen(new VisualisationScreen());
		}
		
		if(toggleEnable.isDown()) {
			BuildGuide.stateManager.getState().initCheck();
			BuildGuide.stateManager.getState().propertyEnable.setValue(!BuildGuide.stateManager.getState().propertyEnable.value);
		}
		
		if(setOrigin.isDown() && BuildGuide.stateManager.getState().isShapeAvailable()) { 
			BuildGuide.stateManager.getState().resetOrigin();
		}
		
		if(setGlobalOrigin.isDown() && BuildGuide.stateManager.getState().propertyAdvancedMode.value && BuildGuide.stateManager.getState().isShapeAvailable()) {
			Origin pos = BuildGuide.shapeHandler.getPlayerPosition();
			int dx = pos.x - BuildGuide.stateManager.getState().getCurrentShape().origin.x;
			int dy = pos.y - BuildGuide.stateManager.getState().getCurrentShape().origin.y;
			int dz = pos.z - BuildGuide.stateManager.getState().getCurrentShape().origin.z;
			for(Shape s: BuildGuide.stateManager.getState().advancedModeShapes) {
				s.shiftOrigin(dx, dy, dz);
			}
		}
	}
	
	public interface IKeyBind {
		public static final String category = "key.buildguide.category";
		
		public boolean isDown();
	}
	
	public static class KeyCode {
		public static final int GLFW_KEY_UNKNOWN = -1;
		public static final int GLFW_KEY_SPACE = 32;
		public static final int GLFW_KEY_APOSTROPHE = 39;
		public static final int GLFW_KEY_COMMA = 44;
		public static final int GLFW_KEY_MINUS = 45;
		public static final int GLFW_KEY_PERIOD = 46;
		public static final int GLFW_KEY_SLASH = 47;
		public static final int GLFW_KEY_0 = 48;
		public static final int GLFW_KEY_1 = 49;
		public static final int GLFW_KEY_2 = 50;
		public static final int GLFW_KEY_3 = 51;
		public static final int GLFW_KEY_4 = 52;
		public static final int GLFW_KEY_5 = 53;
		public static final int GLFW_KEY_6 = 54;
		public static final int GLFW_KEY_7 = 55;
		public static final int GLFW_KEY_8 = 56;
		public static final int GLFW_KEY_9 = 57;
		public static final int GLFW_KEY_SEMICOLON = 59;
		public static final int GLFW_KEY_EQUAL = 61;
		public static final int GLFW_KEY_A = 65;
		public static final int GLFW_KEY_B = 66;
		public static final int GLFW_KEY_C = 67;
		public static final int GLFW_KEY_D = 68;
		public static final int GLFW_KEY_E = 69;
		public static final int GLFW_KEY_F = 70;
		public static final int GLFW_KEY_G = 71;
		public static final int GLFW_KEY_H = 72;
		public static final int GLFW_KEY_I = 73;
		public static final int GLFW_KEY_J = 74;
		public static final int GLFW_KEY_K = 75;
		public static final int GLFW_KEY_L = 76;
		public static final int GLFW_KEY_M = 77;
		public static final int GLFW_KEY_N = 78;
		public static final int GLFW_KEY_O = 79;
		public static final int GLFW_KEY_P = 80;
		public static final int GLFW_KEY_Q = 81;
		public static final int GLFW_KEY_R = 82;
		public static final int GLFW_KEY_S = 83;
		public static final int GLFW_KEY_T = 84;
		public static final int GLFW_KEY_U = 85;
		public static final int GLFW_KEY_V = 86;
		public static final int GLFW_KEY_W = 87;
		public static final int GLFW_KEY_X = 88;
		public static final int GLFW_KEY_Y = 89;
		public static final int GLFW_KEY_Z = 90;
		public static final int GLFW_KEY_LEFT_BRACKET = 91;
		public static final int GLFW_KEY_BACKSLASH = 92;
		public static final int GLFW_KEY_RIGHT_BRACKET = 93;
		public static final int GLFW_KEY_GRAVE_ACCENT = 96;
		public static final int GLFW_KEY_WORLD_1 = 161;
		public static final int GLFW_KEY_WORLD_2 = 162;
		public static final int GLFW_KEY_ESCAPE = 256;
		public static final int GLFW_KEY_ENTER = 257;
		public static final int GLFW_KEY_TAB = 258;
		public static final int GLFW_KEY_BACKSPACE = 259;
		public static final int GLFW_KEY_INSERT = 260;
		public static final int GLFW_KEY_DELETE = 261;
		public static final int GLFW_KEY_RIGHT = 262;
		public static final int GLFW_KEY_LEFT = 263;
		public static final int GLFW_KEY_DOWN = 264;
		public static final int GLFW_KEY_UP = 265;
		public static final int GLFW_KEY_PAGE_UP = 266;
		public static final int GLFW_KEY_PAGE_DOWN = 267;
		public static final int GLFW_KEY_HOME = 268;
		public static final int GLFW_KEY_END = 269;
		public static final int GLFW_KEY_CAPS_LOCK = 280;
		public static final int GLFW_KEY_SCROLL_LOCK = 281;
		public static final int GLFW_KEY_NUM_LOCK = 282;
		public static final int GLFW_KEY_PRINT_SCREEN = 283;
		public static final int GLFW_KEY_PAUSE = 284;
		public static final int GLFW_KEY_F1 = 290;
		public static final int GLFW_KEY_F2 = 291;
		public static final int GLFW_KEY_F3 = 292;
		public static final int GLFW_KEY_F4 = 293;
		public static final int GLFW_KEY_F5 = 294;
		public static final int GLFW_KEY_F6 = 295;
		public static final int GLFW_KEY_F7 = 296;
		public static final int GLFW_KEY_F8 = 297;
		public static final int GLFW_KEY_F9 = 298;
		public static final int GLFW_KEY_F10 = 299;
		public static final int GLFW_KEY_F11 = 300;
		public static final int GLFW_KEY_F12 = 301;
		public static final int GLFW_KEY_F13 = 302;
		public static final int GLFW_KEY_F14 = 303;
		public static final int GLFW_KEY_F15 = 304;
		public static final int GLFW_KEY_F16 = 305;
		public static final int GLFW_KEY_F17 = 306;
		public static final int GLFW_KEY_F18 = 307;
		public static final int GLFW_KEY_F19 = 308;
		public static final int GLFW_KEY_F20 = 309;
		public static final int GLFW_KEY_F21 = 310;
		public static final int GLFW_KEY_F22 = 311;
		public static final int GLFW_KEY_F23 = 312;
		public static final int GLFW_KEY_F24 = 313;
		public static final int GLFW_KEY_F25 = 314;
		public static final int GLFW_KEY_KP_0 = 320;
		public static final int GLFW_KEY_KP_1 = 321;
		public static final int GLFW_KEY_KP_2 = 322;
		public static final int GLFW_KEY_KP_3 = 323;
		public static final int GLFW_KEY_KP_4 = 324;
		public static final int GLFW_KEY_KP_5 = 325;
		public static final int GLFW_KEY_KP_6 = 326;
		public static final int GLFW_KEY_KP_7 = 327;
		public static final int GLFW_KEY_KP_8 = 328;
		public static final int GLFW_KEY_KP_9 = 329;
		public static final int GLFW_KEY_KP_DECIMAL = 330;
		public static final int GLFW_KEY_KP_DIVIDE = 331;
		public static final int GLFW_KEY_KP_MULTIPLY = 332;
		public static final int GLFW_KEY_KP_SUBTRACT = 333;
		public static final int GLFW_KEY_KP_ADD = 334;
		public static final int GLFW_KEY_KP_ENTER = 335;
		public static final int GLFW_KEY_KP_EQUAL = 336;
		public static final int GLFW_KEY_LEFT_SHIFT = 340;
		public static final int GLFW_KEY_LEFT_CONTROL = 341;
		public static final int GLFW_KEY_LEFT_ALT = 342;
		public static final int GLFW_KEY_LEFT_SUPER = 343;
		public static final int GLFW_KEY_RIGHT_SHIFT = 344;
		public static final int GLFW_KEY_RIGHT_CONTROL = 345;
		public static final int GLFW_KEY_RIGHT_ALT = 346;
		public static final int GLFW_KEY_RIGHT_SUPER = 347;
		public static final int GLFW_KEY_MENU = 348;
		public static final int GLFW_KEY_LAST = GLFW_KEY_MENU;
	}
}
