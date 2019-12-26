package shapes;

public class Rectangle extends Shape {

	public Rectangle(double len, double wid) {
		super(len, wid);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void computeArea() {
		System.out.println("area= "+ (length*width));
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Rectangle:  ";
	}

	@Override
	public void computePerimeter() {
		System.out.println("perimeter: "+ 2*(length+width));
		
	}

}
