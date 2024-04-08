package test;

public class Scopeofinnerclass {

	class Innerclass{
		private int num = 10;
	}
	
	public void print() {
		num=20;
	}
	public static void main(String[] args) {
		
		Scopeofinnerclass.Innerclass test= new Scopeofinnerclass().new Innerclass();
		System.out.println(test.num);
	}
}
