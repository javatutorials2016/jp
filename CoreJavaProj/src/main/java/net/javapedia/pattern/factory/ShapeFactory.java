package net.javapedia.pattern.factory;

public class ShapeFactory {
	
	public static Shape getShape(String shape) {
		if ("Rectangle".equalsIgnoreCase(shape)) {
			return new Rectangle();
		}
		else if ("Circle".equals(shape)) {
			return new Circle();
		}
		
		return null;
	}

}
