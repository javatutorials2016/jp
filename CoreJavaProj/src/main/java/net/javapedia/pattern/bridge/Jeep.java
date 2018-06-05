package net.javapedia.pattern.bridge;

public class Jeep extends Car {

	Jeep(Color color) {
		super(color);
	}

	@Override
	void build() {
		System.out.println("Building Jeep...");
		color.applyColor();
	}

}
