package shapes;

public class ShapeDrawer implements Drawable {

	@Override
	public void draw(Shape s) {
		if(s instanceof Rectangle) {
			System.out.println("drawing a rectangle");
		}
		else if(s instanceof Square) {
			System.out.println("drawing a square");
		}
	}

}
