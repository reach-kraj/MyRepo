package advancejava;

public class EnumsConcept {
	public enum Season {
		WINTER, SPRING, SUMMER, FALL
	}

	// enum
	public static void main(String[] args) {
		Season season = Season.WINTER;

		if (season == Season.WINTER) {
			System.out.println("It is winter!");
		} else if (season == Season.SPRING) {
			System.out.println("It is spring!");
		} else if (season == Season.SUMMER) {
			System.out.println("It is summer!");
		} else if (season == Season.FALL) {
			System.out.println("It is fall!");
		}
	}

}
