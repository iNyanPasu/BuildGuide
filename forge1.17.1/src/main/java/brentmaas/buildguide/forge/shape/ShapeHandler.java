package brentmaas.buildguide.forge.shape;

import brentmaas.buildguide.common.shapes.IShapeBuffer;
import brentmaas.buildguide.common.shapes.IShapeHandler;
import brentmaas.buildguide.common.shapes.Shape.Basepos;
import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec3;

public class ShapeHandler implements IShapeHandler {
	
	
	public IShapeBuffer newBuffer() {
		return new ShapeBuffer();
	}
	
	public Basepos getPlayerPosition() {
		Vec3 pos = Minecraft.getInstance().player.position();
		return new Basepos((int) Math.floor(pos.x), (int) Math.floor(pos.y), (int) Math.floor(pos.z));
	}
}
