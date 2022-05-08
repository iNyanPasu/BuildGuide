package brentmaas.buildguide.common.shape;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import brentmaas.buildguide.common.BuildGuide;

public class ShapeRegistry {
	private static Map<String,Class<? extends Shape>> shapeRegistry = new HashMap<String,Class<? extends Shape>>();
	private static ArrayList<String> classIdentifiers = new ArrayList<String>();
	private static ArrayList<String> translationKeys = new ArrayList<String>();
	
	public static void registerShape(Class<? extends Shape> shapeClass) {
		shapeRegistry.put(shapeClass.getName(), shapeClass);
		classIdentifiers.add(shapeClass.getName());
		translationKeys.add(getNewInstance(shapeClass.getName()).getTranslationKey());
	}
	
	public static Shape getNewInstance(String classIdentifier) {
		try {
			return shapeRegistry.get(classIdentifier).getDeclaredConstructor().newInstance();
		}catch(InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			BuildGuide.logHandler.fatal("Unable to instantiate Shape class '" + classIdentifier + "'");
			e.printStackTrace();
			System.exit(1);
		}
		
		return null;
	}
	
	public static ArrayList<String> getClassIdentifiers(){
		return classIdentifiers;
	}
	
	public static ArrayList<String> getTranslationKeys(){
		return translationKeys;
	}
	
	public static int getNumberOfShapes() {
		return classIdentifiers.size();
	}
	
	public static String getClassIdentifier(Class<? extends Shape> shapeClass) {
		for(String classIdentifier: classIdentifiers) {
			if(shapeRegistry.get(classIdentifier) == shapeClass) return classIdentifier;
		}
		return null;
	}
	
	public static int getShapeId(Class<? extends Shape> shapeClass) {
		String classIdentifier = getClassIdentifier(shapeClass);
		if(classIdentifier == null) return 0;
		return getShapeId(classIdentifier);
	}
	
	public static int getShapeId(String classIdentifier) {
		return classIdentifiers.contains(classIdentifier) ? classIdentifiers.indexOf(classIdentifier) : 0;
	}
}
