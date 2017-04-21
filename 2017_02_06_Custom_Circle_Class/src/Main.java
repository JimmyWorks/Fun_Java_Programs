/*
 * Custom Circle Class with Unique Methods
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */

public class Main {

    public static void main(String[] args) {
        
        Circle2D c1 = new Circle2D(2.0, 2.0, 5.5);
        System.out.printf("Created circle c1 with center at (%.1f, %.1f) and radius %.1f\n", c1.x, c1.y, c1.radius);
        System.out.printf("The area is %.1f and the perimeter is %.1f\n", c1.getArea(), c1.getPerimeter());
        
        System.out.printf("Checking if c1 contains (3, 3)\n");
        System.out.printf("The result is ");
                if(c1.contains(3, 3))
                    System.out.printf("true\n\n");
                else
                    System.out.printf("false\n\n");
        
                
        Circle2D c2 = new Circle2D(4.0, 5.0, 10.5);
        System.out.printf("Created circle c2 with center at (%.1f, %.1f) and radius %.1f\n", c2.x, c2.y, c2.radius);
        
        System.out.printf("Checking if c1 it overlaps c2\n");
        System.out.printf("The result is ");
                if(c1.overlaps(c2))
                    System.out.printf("true\n\n");
                else
                    System.out.printf("false\n\n");
                
        Circle2D c3 = new Circle2D(3.0, 5.0, 2.3);
        System.out.printf("Created circle c3 with center at (%.1f, %.1f) and radius %.1f\n", c3.x, c3.y, c3.radius);
           
        System.out.printf("Checking if c1 it contains c3\n");
        System.out.printf("The result is ");
                if(c1.contains(c3))
                    System.out.printf("true\n\n");
                else
                    System.out.printf("false\n\n");
           
    }
    
}
