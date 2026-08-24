interface Switchable{
    void TurnOn();
    default void ShowMessage(){
        System.out.println("Device is being operated...");
    }
}
class Light implements Switchable{
    String name;
    int brightness;
    boolean status;
    Light(String name, int brightness){
        this.name = name;
        this.brightness = brightness;
        this.status = false;
    }
    public void TurnOn(){
        System.out.println();
        status = true;
        ShowMessage();
        System.out.println("\n-------- LIGHT DETAILS --------\n");
        System.out.println("Name       : " + name);
        System.out.println("Brightness : " + brightness + "%");
        System.out.println("Status     : ON");
        if (brightness >= 80){
            System.out.println("Mode       : High Brightness");
        }
        else if (brightness >= 50){
            System.out.println("Mode       : Medium Brightness");
        }
        else{
            System.out.println("Mode       : Low Brightness");
        }
        System.out.println();
    }
}
class Fan implements Switchable{
    String name;
    int speed;
    boolean status;
    Fan(String name, int speed){
        this.name = name;
        this.speed = speed;
        this.status = false;
    }
    public void TurnOn(){
        status = true;
        System.out.println();
        ShowMessage();
        System.out.println("\n-------- FAN DETAILS --------\n");
        System.out.println("Name       : " + name);
        System.out.println("Speed      : " + speed);
        System.out.println("Status     : ON");
        if (speed >= 4){
            System.out.println("Mode       : High Speed");
        }
        else if (speed >= 2){
            System.out.println("Mode       : Medium Speed");
        }
        else{
            System.out.println("Mode       : Low Speed");
        }
        System.out.println();
    }
}
public class SwitchableInterface {
    public static void main(String[] args) {
        Switchable l = new Light("Bed Room Light",75);
        Switchable f = new Fan("Ceiling Fan",3);
        l.TurnOn();
        f.TurnOn();
    }
}