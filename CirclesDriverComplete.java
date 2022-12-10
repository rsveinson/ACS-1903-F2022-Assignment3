import java.util.Scanner;
import java.util.ArrayList;
/** 
 * ACS-1903 Assignment X Question Y
 * @author 
*/

public class CirclesDriverComplete{
    public static void main(String[] args) {
        // ** Variables constants and objects **
        int radiusMin = 2;
        int radiusMax = 4;  // 4 because the Math.random will generate up to .49
        double r;
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Circle>circles = new ArrayList<>();

        // ** load the array list with circles **
        for (int i = 0; i < 10; i++){
            r = (2 + (4 - 1) * Math.random());
            circles.add(new Circle(r));
        }// end for
        
        // print the whole list
        System.out.println("Circle\tRadius\tArea\tDiam\tCirc");
        for(Circle c : circles){
            System.out.println(c);
        }
        System.out.println("--------------------------------\n");
        
        // ** Make sure your Circle class and ArrayList work with the following driver code **
        System.out.println();
        
        Circle c1 = new Circle();
        System.out.println("C1: " + c1.getID());
        System.out.println("Radius: " + c1.getRadius());
        System.out.println("--------------------------------\n");
        
        c1.setRadius(1.5);
        System.out.println("C1: " + c1.getID());
        System.out.println("Radius: " + c1.getRadius());
        System.out.println("Area: " + c1.getArea());
        System.out.println("--------------------------------\n");
        
        circles.get(3).setRadius(2.2);
        System.out.println("C1: " + circles.get(3).getID());
        System.out.println("Radius: " + circles.get(3).getRadius());
        System.out.println("Diameter: " + circles.get(3).getDiameter());
        System.out.println("--------------------------------\n");
        
        Circle c2 = circles.remove(9);
        System.out.println("C2: " + c2.getID());
        System.out.println("Radius: " + c2.getRadius());
        System.out.println("Circumference: " + c2.getCircumference());
        System.out.println("--------------------------------\n");
        
        // ** output
        
        // ** closing message **
        System.out.println("\nend of program");
    }
}
