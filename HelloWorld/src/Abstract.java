/**
 * Created by sfzhang on 6/29/2017.
 */
public class Abstract{
    public static void main(String a[]){
    S7 phone_s7 = new S7(305.00, 10, "yellow");
    System.out.printf("is this s7 popular?       %s%n", phone_s7.getPopularity());
    System.out.printf("How about its quality?    %s%n", phone_s7.getQuality());
    phone_s7.getSpecification();
    for(int i=0; i<3; i++) System.out.println();
    Iphone7 phone_iphone7 = new Iphone7(690, 7, "golden");
    System.out.printf("is this iphone7 popular?  %s%n", phone_iphone7.getPopularity());
    System.out.printf("How about its quality?    %s%n", phone_iphone7.getQuality());
    phone_iphone7.getSpecification();

    }

}

abstract class Phone{
    String name;
    static double price;
    String operatingSystem;
    int screenSize;
    String company;
    String color;

    Phone(){

    }

    abstract String getQuality();
    String getPopularity(){
        switch (color){
            case "golden": return "very popular";
            case "black":  return "popular";
            default:       return "not polular";
        }

    }

    void getSpecification(){
        System.out.printf("%18s: %20s\n", "name", name);
        System.out.printf("%18s: %20f\n", "price", price);
        System.out.printf("%18s: %20s\n", "operating system", operatingSystem);
        System.out.printf("%18s: %20s\n", "company", company);
        System.out.printf("%18s: %20d\n", "screen size", screenSize);
        System.out.printf("%18s: %20s\n", "color", color);
    }

}

class SumSung extends Phone{

    SumSung(){
        company = "SumSung,Ltd.";
        operatingSystem = "Android";
    }

    String getQuality(){
        if (price > 500) {
            return "very good";
        }
        else if (price > 300){
            return "good";
        }
        else {
            return "normal";
        }
    }

}

class S7 extends SumSung{

     S7(double price, int screenSize, String color) {
         name = "Galaxy S7";
         this.price = price;
         this.screenSize = screenSize;
         this.color = color;

     }




}

class Iphone extends Phone{
    Iphone(){
        operatingSystem = "IOS";
        company = "Apple,Inc.";
    }

    String getQuality()
    {
        return "very good!";

    }

}

class Iphone7 extends Iphone{
    Iphone7(double price, int screenSize, String color) {
        name = "Iphone 7";
        this.price = price;
        this.screenSize = screenSize;
        this.color = color;
    }


}