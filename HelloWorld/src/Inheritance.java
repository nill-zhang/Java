/**
 * Created by sfzhang on 6/28/2017.
 */

class Inheritance {
    public static void main(String args[]){
        Child nova = new Child(100, 10, 1);

        // Child method getNetWorth() overrides its ancestors getNetWorth()
        System.out.printf("Miss Nova's netWorth:         $%.2f\n", nova.getNetWorth());
        System.out.printf("Father's NetWorth:            $%.2f\n", nova.getFatherNetWorth());

        // Child class  inherits all its ancestors' public attributes and methods
        System.out.printf("Miss Nova's SecretSavings:    $%.2f\n", nova.getcSecretSavings());
        System.out.printf("Father's SecretSavings:       $%.2f\n", nova.getfSecretSavings());
        System.out.printf("Grand Father's SecretSavings: $%.2f\n", nova.getgSecretSavings());
        System.out.printf("*****************************************************************\n");
        System.out.printf("Miss Nova's NetWorth:         $%.2f\n", nova.cNetWorth);
        System.out.printf("Grand Father's NetWorth:      $%.2f\n", nova.gNetWorth);
        System.out.printf("Father's NetWorth:            $%.2f\n", nova.fNetWorth);

        /* can not access its own private attributes outside its class
        System.out.printf("Miss Nova's SecretSavings:    $%.2f\n", nova.cSecretSavins);
        */

        /* can not access its supers'private attributes outside their class
        System.out.printf("Father's SecretSavings:       $%.2f\n", nova.fSecretSavings);
        System.out.printf("Grand Father's SecretSavings: $%.2f\n", nova.gSecretSavings);
        */


    }
}

class GrandFather{

    double gNetWorth;
    private double gSecretSavings;

    GrandFather(double gnw){
        gNetWorth= gnw;
        gSecretSavings = 100.00;
    }

    double getNetWorth(){
        return gNetWorth;
    }

    double getgSecretSavings(){
        return gSecretSavings;
    }
}


class  Father extends GrandFather{
    double fNetWorth;
    private double fSecretSavings;

    Father(double gnw, double fnw){
        super(gnw);
        fNetWorth = fnw;
        fSecretSavings = 100.00;
    }

    // will override its parent class's getNetWorth
    double getNetWorth(){

        return this.gNetWorth + fNetWorth;
    }

    double getfSecretSavings(){
        return fSecretSavings;
    }
}

class Child extends Father{
    double cNetWorth;
    private double cSecretSavings;

    Child(double gnw, double fnw, double cnw){
        super(gnw, fnw);
        cNetWorth = cnw;
        cSecretSavings = 100.00;

    }
    double getNetWorth(){
        return this.gNetWorth +  this.fNetWorth + cNetWorth;
    }

    double getFatherNetWorth(){
        return super.getNetWorth();
    }


    double getcSecretSavings(){
        return cSecretSavings;

    }

}