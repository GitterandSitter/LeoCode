package leo;

public class Square extends Rectangle{

    int side = 0;

    public Square(int width) {
        this.side = width;
        setHeight(side);
        setWidth(side);
    }


    @Override
    protected void setWidth(int width) {
        setSide(width);

    }
    @Override
    protected void setHeight(int height) {
        setSide(height);
    }

    private void setSide(int value) {
        super.setHeight(value);
        super.setWidth(value);
    }

    protected static void describeSquare() {
        System.out.println("This is a square. static method call without necessary instantiation.");

    }
}
