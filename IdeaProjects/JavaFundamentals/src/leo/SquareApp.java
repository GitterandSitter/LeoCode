package leo;

public class SquareApp {

    //Static variable: shared by all instances. Not of importance to create a single entry.
    public static void main(String[] args) {
        int vierkantZijde = 5;
        Square vierkant = new Square(vierkantZijde);
        System.out.println(vierkant.getArea());
        System.out.println(vierkant.getCircumference());

        vierkant.setWidth(10);
        System.out.println(vierkant.getArea());
        System.out.println(vierkant.getCircumference());

        Square.describeSquare(); //No instantiation; Class reference. 
    }
}
