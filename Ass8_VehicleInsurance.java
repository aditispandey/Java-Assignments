class Vehicle{
    String vehiclenumber;
    String model;
    double price;
    Vehicle(String vehiclenumber, String model, double price){
        this.vehiclenumber = vehiclenumber;
        this.model = model;
        this.price = price;
    }
    void displayVehicle(){
        System.out.println("Vehicle Number : "+vehiclenumber);
        System.out.println("Vehicle Model  : "+model);
        System.out.println("Vehicle Price  : "+price);
    }
}
class CarInsurance extends Vehicle{
    double premium;
    CarInsurance(String vehiclenumber, String model, double price, double premium){
        super(vehiclenumber, model, price);
        this.premium = premium;
    }
    void displayInsurance(){
        System.out.println("Vehicle Number : "+ super.vehiclenumber);
        System.out.println("Vehicle Model  : "+ super.model);
        System.out.println("Vehicle Price  : "+ super.price);
        System.out.println("Insurance Premium : "+ premium);
    }
}
class BikeInsurance extends Vehicle{
    double premium;
    BikeInsurance(String vehiclenumber, String model, double price, double premium){
        super(vehiclenumber, model, price);
        this.premium = premium;
    }
    void displayInsurance(){
        System.out.println("Vehicle Number : "+ super.vehiclenumber);
        System.out.println("Vehicle Model  : "+ super.model);
        System.out.println("Vehicle Price  : "+ super.price);
        System.out.println("Insurance Premium : "+ premium);
    }
}
public class VehicleInsurance {
    public static void main(String[] args){
        CarInsurance car = new CarInsurance("MH-14-CF-8334","Honda City",2000000,25000);
        BikeInsurance bike = new BikeInsurance("MH-12-DJ-8980","Royal Enfield",100000,20000);
        car.displayInsurance();
        bike.displayInsurance();
    }
}
