package shapes;

public class ShapeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape box= new Rectangle(5,7);
		System.out.println(box);
		box.computeArea();
		box.computePerimeter();
		
		Shape box1= new Square(5);
		System.out.println(box1);
		box1.computeArea();
		box1.computePerimeter();
		//ShapeDrawer sd= new ShapeDrawer();
		draw(new ShapeDrawer(), box); //draw(sd,box);
		draw(new ShapeDrawer(), box1); //draw(sd,box1);
		
		//anonymous inner class
		Drawable d = new Drawable() {
			@Override
			public void draw(Shape s) {
				if(s instanceof Rectangle)
					System.out.println("drawing rect using drawable");
				if(s instanceof Square)
					System.out.println("drawing square using drawable");
				
			
			}
		};
		
		draw(d,box);
		
		draw(new MyDrawable(), box1);
	}
	public static void draw(Drawable d, Shape s) {
		d.draw(s);
		
	}
	
	static class MyDrawable implements Drawable{
		@Override
		public void draw(Shape s) {
			if(s instanceof Rectangle)
				System.out.println("drawing rect using MyDrawable");
			if(s instanceof Square)
				System.out.println("drawing square using MyDrawable");
			
	}
}
}
