package newJava_Ex2;

public class Circle {
  // defining the variables 
  private double centerX;
  private double centerY;
  private double radius;
  // Constant variable , used Math class for getting the value of PI 
  static final double PI = Math.PI;
  // empty constructor  
  public Circle() {
    this.centerX = 0;
    this.centerY = 0;
    this.radius = 1;
  }
  // second constructor   
  public Circle(double x, double y, double r) {
    this.centerX = x;
    this.centerY = y;
    if (r < 0) {
      this.radius = 1;
    } else {
      this.radius = r;
    }
  }
  //generate setters and getters 
  public double getCenterX() {
    return centerX;
  }

  public double getCenterY() {
    return centerY;
  }

  public double getRadius() {
    return radius;
  }

  public void setCenterX(double centerX) {
    this.centerX = centerX;
  }

  public void setCenterY(double centerY) {
    this.centerY = centerY;
  }

  public void setRadius(double radius) {
    if (radius >= 0)
      this.radius = radius;
  }
  // printing the circles info 
  public String toString() {
    return "Circle at (" + this.centerX + "," + this.centerY + ")" + " radius " + this.radius;
  }
  // calculating the area , used math class to get the power of the radius 
  public double area() {
    return PI * Math.pow(this.radius, 2);
  }
  // calculating the perimeter
  public double perimeter() {
    return 2 * PI * this.radius;
  }
  // resizing the circle (radius times factor)
  public void resize(double factor) {
    if (factor >= 0) {
      this.radius *= factor;
    }
  }
  // changing the centre of the circle 
  public void moveTo(double x, double y) {
    this.centerX = x;
    this.centerY = y;
  }
  // check if the given point is included or on the circle 
  public boolean isIn(double x, double y) {
    double equation = Math.pow((this.centerX - x), 2) + Math.pow((this.centerY - y), 2);
    if (equation <= this.radius)
      return true;
    else
      return false;
  }

}