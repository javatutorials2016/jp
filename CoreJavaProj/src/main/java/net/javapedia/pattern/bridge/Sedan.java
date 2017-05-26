package net.javapedia.pattern.bridge;

public class Sedan extends Car {

	Sedan(Color color) {
		super(color);
	}

	@Override
	void build() {
		System.out.println("Building Sedan car...");
		color.applyColor();
		
	}

}
