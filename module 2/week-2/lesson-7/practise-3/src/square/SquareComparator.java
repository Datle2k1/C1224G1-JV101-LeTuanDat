package square;

import java.util.Comparator;

public class SquareComparator implements Comparator<Square> {
    @Override
    public int compare(Square s1, Square s2) {
        return Double.compare(s1.getArea(), s2.getArea());
    }
}
