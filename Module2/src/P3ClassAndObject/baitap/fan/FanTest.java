package P3ClassAndObject.baitap.fan;

public class FanTest {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.turnOn();
        fan1.setSpeed(Fan.FAST);
        fan1.setRadius(10.0);
        fan1.setColor("Yellow");
        fan2.turnOff();
        fan2.setSpeed(Fan.MEDIUM);
        fan2.setRadius(5.0);
        fan2.setColor("Blue");
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
