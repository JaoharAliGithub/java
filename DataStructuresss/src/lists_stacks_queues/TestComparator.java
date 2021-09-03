package lists_stacks_queues;

import java.util.Comparator;

public class TestComparator {
	public static void main(String[] args) {
		AbstractGeometricObject g1 = new Rectangle(5, 5);
		AbstractGeometricObject g2 = new Circle(5);

		AbstractGeometricObject g = max(g1, g2, new GeometricObjectComparator());

		System.out.println("The area of the larger object is " + g.getArea());
	}

	public static AbstractGeometricObject max(AbstractGeometricObject g1, AbstractGeometricObject g2, Comparator<AbstractGeometricObject> c) {
		if (c.compare(g1, g2) > 0)
			return g1;
		else
			return g2;
	}
}