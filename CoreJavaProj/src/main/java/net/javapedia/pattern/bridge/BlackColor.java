package net.javapedia.pattern.bridge;

public class BlackColor implements Color {

	@Override
	public void applyColor() {
		System.out.println("Applied Black color!");
	}

}
