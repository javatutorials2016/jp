package net.javapedia.pattern.bridge;

public class BridgePatternMain {

	public static void main(String[] args) {

		Color greyColor = new GreyColor();
		BlackColor blackColor = new BlackColor();

		Sedan greySedan = new Sedan(greyColor);
		Car blackSedan = new Sedan(blackColor);

		Car greyJeep = new Jeep(greyColor);

		Car blackJeep = new Jeep(blackColor);

		Color redColor = () -> System.out.println("applying red color");

		Jeep redJeep = new Jeep(redColor);

		greySedan.build();
		blackSedan.build();
		greyJeep.build();
		blackJeep.build();
		redJeep.build();

	}

}
