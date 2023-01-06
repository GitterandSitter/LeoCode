package leo;

public abstract class Rectangle {

    int width;
    int height;

    protected void setWidth(int width){
        this.width = width;

    };
    protected void setHeight(int height){
        this.height = height;
    };

    public String getArea(){
        return "Area: " +  (width * height);
    }

    public String getCircumference() {
        return "Circumference: " + ((width * 2)+(height * 2));
    }


}
