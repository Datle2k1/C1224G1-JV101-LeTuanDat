package rectangle;

import java.util.Arrays;
import java.util.Comparator;

public class RectangleComparatorTest {
    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[3];
        rectangles[0] = new Rectangle(4.0, 7.0);
        rectangles[1] = new Rectangle();
        rectangles[2] = new Rectangle(5.0,3.0,"blue", true);
        System.out.println("Array rectangle after sort : "  + Arrays.toString(rectangles));

        Comparator<Rectangle> comparator = new RectangleComparator();
        Arrays.sort(rectangles, comparator);

        System.out.println("Array rectangle after sort : ");
        for (Rectangle rectangle: rectangles) {
            System.out.println(rectangle);
        }
    }
}
