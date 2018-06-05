package net.javapedia.pattern.factory;

public class ShapeMain {

	public static void main(String[] args) {
			ShapeFactory.getShape("Rectangle").draw();
			
			Shape shape = ShapeFactory.getShape("Circle");
			
			shape.draw();
	}

}
