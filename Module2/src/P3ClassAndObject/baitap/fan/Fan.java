package P3ClassAndObject.baitap.fan;

public class Fan{
   public final static int  SLOW = 1;
   public final static int MEDIUM = 2;
   public final static int FAST = 3;
   private int speed = SLOW;
   private boolean on = false;
   private double radius = 5.0;
   private String color = "blue";
   public void turnOn() {
      on = true;
   }
   public void turnOff() {
      on = false;
   }
   public void setColor(String color) {
        this.color = color;
   }
   public String getColor() {
      return color;
   }
   public void setRadius(double radius) {
      if (radius > 0)
         this.radius = radius;
   }
   public double getRadius() {
       return radius;
   }
   public void setSpeed(int speed) {
      if (on && speed >= SLOW && speed <= FAST)
         this.speed = speed;
   }
   public int getSpeed() {
      if (on)
         return speed;
      else
         return 0;
   }

   @Override
   public String toString() {
       if(on) {
          return "Speed: " + getSpeed() + ", Color: " + getColor() + ", Radius: " + getRadius() + ", Fan is on.";
       } else {
          return "Color: " + getColor() + ", Radius: " + getRadius() + ", Fan is off.";
       }
   }
}
