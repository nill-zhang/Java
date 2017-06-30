import java.lang.reflect.Array;

/**
 * Created by sfzhang on 6/28/2017.
 */
public class ClassAndInstanceVariable {

    public static void main(String args[]){
        Test t1 = new Test();
        Test t2 = new Test();

        System.out.printf("Test.sclassv: %s\n", Test.sclassv);
        System.out.printf("t1.insv: %s, t2.insv: %s\n", t1.instv, t2.instv);
        System.out.printf("t1.uninsv: %s, t2.uninsv: %s\n", t1.uninit_instv, t2.uninit_instv);
        System.out.println(new String(new char[80]).replace("\0", "*"));

        // change t1's variable won't affect t2's, they are independent instances
        t1.instv = "t1 instance variable";
        System.out.printf("t1.insv: %s, t2.insv: %s\n",t1.instv, t2.instv);

        // changed t2's variable won't affect t1's
        t2.uninit_instv = "t2 uninitialized instance variable";
        System.out.printf("t1.uninsv: %s, t2.uninsv: %s\n", t1.uninit_instv, t2.uninit_instv);

        //can not access any local variable outside its scope
        t1.setLocalVariabe("instance local variable");
        // t1.localVariable;

        // although instances can not access static class variable
        // they can reset it.
        t1.setStaticVariable("changed static variable");
        System.out.printf("Test.sclassv: %s\n", Test.sclassv);

        //  super did not initialize the parameter;
        //  subclass can initialize it.
        SubTest st = new SubTest(44);
        System.out.println(st.num);
        st.setAttribute(88);
        System.out.println(st.num);
        st.num = 99;
        System.out.println(st.num);


    }
}


class Test{
    int num;
    String instv = "instance variable";
    static String sclassv = "static class variable";
    String uninit_instv;

    Test(){
        uninit_instv = "uninsv";
        System.out.println("initialized uninitialized instance variable!");
    }

    void setLocalVariabe(String localv){
        String localVariable = localv;
        System.out.printf("%s has been set: %s\n","local variable", localv);
    }

    void setStaticVariable(String staticv){
        sclassv = staticv;
    }


}

class SubTest extends Test{

    SubTest(int number){
        super.num = number;
    }

    void setAttribute(int number){
        super.num = number;
        
    }

}