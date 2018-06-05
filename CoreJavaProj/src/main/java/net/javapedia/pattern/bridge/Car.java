package net.javapedia.pattern.bridge;

public abstract class Car {
	Color color;
	
	Car (Color color) {
		this.color = color;
	}
	
	abstract void build();
}
