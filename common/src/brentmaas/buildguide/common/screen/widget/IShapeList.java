package brentmaas.buildguide.common.screen.widget;

public interface IShapeList extends IWidget {
	//TODO Move implementation more towards here
	
	public void addEntry(int shapeId);
	
	public boolean removeEntry(IEntry entry);
	
	public IEntry getSelected();
	
	public static interface IEntry {
		
		
		public void setShapeSetId(int shapeId);
		
		public int getShapeSetId();
	}
}
