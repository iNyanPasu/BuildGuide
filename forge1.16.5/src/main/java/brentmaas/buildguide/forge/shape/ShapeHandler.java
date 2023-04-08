package brentmaas.buildguide.forge.shape;

import brentmaas.buildguide.common.shape.IShapeBuffer;
import brentmaas.buildguide.common.shape.IShapeHandler;
import brentmaas.buildguide.common.shape.Shape.Origin;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.vector.Vector3d;

public class ShapeHandler implements IShapeHandler {
	
	
	public IShapeBuffer newBuffer() {
		return new ShapeBuffer();
	}
	
	public Origin getPlayerPosition() {
		Vector3d pos = Minecraft.getInstance().player.position();
		return new Origin((int) Math.floor(pos.x), (int) Math.floor(pos.y), (int) Math.floor(pos.z));
	}
}
