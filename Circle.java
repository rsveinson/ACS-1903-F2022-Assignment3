import java.util.Scanner;
import java.util.ArrayList;
/** 
 * ACS-1903 Assignment X Question Y
 * @author 
 */

public class Circle{
    // ** static variables and constants
    
    private static int nextID = 1054;

    // ** Instance Variables constants and objects **
    private int id;
    private double radius;
    
    // ** constructors **
    public Circle(){
        radius = 0;
        id = getNextID();
    }// end no-arg
    
    public Circle(double radius){
        this.radius = radius;
        id = getNextID();
    }// end full arg
    
    // ** getters **
    public double getRadius(){
        return this.radius;
    }// end get radius
    
    public int getID(){
        return this.id;
    }// end get id
    
    // ** setters **
    
    public void setRadius(double radius){
        this.radius = radius;
    }// end set radius
    
    // methods to calculate circle dimensions
    public double getArea(){
        return Math.pow(radius, 2) * Math.PI;
    }// end are
    
    public double getDiameter(){
        return radius * 2;
    }// end diameter
    
    public double getCircumference(){
        return 2 * Math.PI * radius;
    }// end get circumference
    
    // ** other **
    @Override
    public String toString(){
        String st;
        
        // st = "Circle: \t" + this.id + "\n";
        // st += "Radius: \t" + String.format("%.3f\n", this.getRadius());
        // st += "Area: \t\t" + String.format("%.3f", this.getArea()) + "\n";
        // st += "Diameter: \t" + String.format("%.3f", this.getDiameter()) + "\n";
        // st += "Circumference: \t" + String.format("%.3f", this.getCircumference());
        // System.out.println("-----------------------------------\n");
        
        st = "" + this.id;
        st += "\t" + String.format("%.3f", this.getRadius());
        st += "\t" + String.format("%.3f", this.getArea());
        st += "\t" + String.format("%.3f", this.getDiameter());
        st += "\t" + String.format("%.3f", this.getCircumference());
        
        return st;
    }
    
    private int getNextID(){
        return nextID++;
    }// end get next id

}//end of Cirlce
