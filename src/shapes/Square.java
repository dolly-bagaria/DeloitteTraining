package shapes;

public class Square extends Shape {

	public Square(double s) {
		super(s);
	}

	@Override
	public void computeArea() {
		System.out.println("area: "+ length*length);
		
	}

	@Override
	public void computePerimeter() {
		System.out.println("Perimeter: "+ 4*length);
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Square:  ";
	}

}
