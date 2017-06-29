/**
 * Created by Admin on 6/28/2017.
 */

class Inheriance {
    public static void main(String args[]){
        Child nova = new Child(1, 2, 3);
        System.out.printf("Miss Nova netWorth: $%.2f\n", nova.getNetWorth());
        System.out.printf("Father NetWorth: $%.2f\n", nova.getFatherNetWorth());
        System.out.printf("Father NetWorth: $%.2f\n", nova.fnetworth);
        System.out.printf("Grand Father NetWorth: $%.2f\n", nova.gnetworth);

    }
}

class GrandFather{

    double gnetworth;

    GrandFather(double gnw){
        gnetworth= gnw;
    }

    double getNetWorth(){
        return gnetworth;
    }
}


class  Father extends GrandFather{
    double fnetworth;

    Father(double gnw, double fnw){
        super(gnw);
        fnetworth = fnw;
    }

    // will override its parent class's getNetWorth
    double getNetWorth(){

        return fnetworth;
    }
}

class Child extends Father{
    double cnetworth;

    Child(double gnw, double fnw, double cnw){
        super(gnw, fnw);
        cnetworth = cnw;


    }
    double getNetWorth(){
        return cnetworth;
    }

    double getFatherNetWorth(){
        return super.getNetWorth();
    }

}