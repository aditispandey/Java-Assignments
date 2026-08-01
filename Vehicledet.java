class Vehicle{
    String model="Kia Seltos";
    String colour="Red";
    int licenseno=3884;
    String statecode="MH";
    int rtocode=14;
    String seriescode="FH";
    int mil=19;
    void display(){
        System.out.println("Vehicle Program:");
        System.out.println("Average mileage: "+mil+" km/l");
    }
    class Cardetails{
        int mil1=(mil+17)/2;
        void show(){
        System.out.println("Model: "+model);
        System.out.println("Colour: "+colour);
        System.out.println("License No.: "+statecode+"-"+rtocode+"-"+seriescode+"-"+licenseno);
        System.out.println("Mileage for this car: "+mil1+" km/l");
        }
    }
}
public class Vehicledet{
    public static void main(String[] args){
        Vehicle v=new Vehicle(){
            void display(){
                super.display();
                System.out.println("Vehicle Details: ");
            }
        };
        v.display();
        Vehicle.Cardetails c=v.new Cardetails();
        c.show();
    }
}
