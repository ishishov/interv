package tests.com.cake.rectangularlove;

/**
 * Created by ishishov on 5/13/16.
 */
public class RectangularLove {

    static Rectangle findXOverlap(Rectangle r1, Rectangle r2) {
        Integer highestStart = Math.max(r1.leftX, r2.leftX);
        Integer lowestEnd = Math.min(r1.leftX + r1.width, r2.leftX + r2.width);

        if (lowestEnd < highestStart) return null;

        return new Rectangle(highestStart, null, lowestEnd - highestStart, null);
    }


    //TODO: code looks very similar to x overlap, two methods can be combined into one
    static Rectangle findYOverlap(Rectangle r1, Rectangle r2) {
        Integer highestStart = Math.max(r1.bottomY, r2.bottomY);
        Integer lowestEnd = Math.min(r1.bottomY + r1.height, r2.bottomY + r2.height);

        if (lowestEnd < highestStart) return null;

        return new Rectangle(null, highestStart, null, lowestEnd - highestStart);
    }

    static Rectangle findLove(Rectangle r1, Rectangle r2) {
        Rectangle x = findXOverlap(r1, r2);
        Rectangle y = findYOverlap(r1, r2);

        return new Rectangle(x.leftX, y.bottomY, x.width, y.height);
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(-1, -1, 3, 2);
        Rectangle r2 = new Rectangle(1, 0, 2, 3);

        System.out.print(findLove(r1,r2));
    }
}
