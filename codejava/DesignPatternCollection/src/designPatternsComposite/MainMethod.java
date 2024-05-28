package designPatternsComposite;

public class MainMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Shape triangle = new Triangle();
		Shape square = new Square();
		Shape circle = new Circle();
		
		Drawing drawing = new Drawing();
		drawing.add(triangle);
		drawing.add(square);
		drawing.add(circle);
		
		drawing.draw("Red");
		
		drawing.clear();
		
		drawing.add(triangle);
		drawing.add(circle);
		drawing.draw("Green");
	}

}
