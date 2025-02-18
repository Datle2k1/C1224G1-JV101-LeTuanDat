package square;

import java.util.Arrays;

public class SquareComparatorTest {
    public static void main(String[] args) {
        Square[] squares = new Square[3];
        squares[0] = new Square(9);
        squares[1] = new Square(4, "red", true);
        squares[2] = new Square(6);

        System.out.println("Array squares before sort");
        for (Square square: squares) {
            System.out.println(square);
        }

        SquareComparator comparator = new SquareComparator();
        Arrays.sort(squares, comparator);

        System.out.println("Array square after sort");
        for (Square square: squares) {
            System.out.println(square);
        }
    }
}
