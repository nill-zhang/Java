/**
 * Created by sfzhang on 6/22/2017.
 */


public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        char [] chars = {97, 98, 99, 100};
        byte [] buf = {97, 98, 99, 100};
        for (int j = 0; j < 4; j++){
            System.out.print(chars[j]);
        }
        System.out.println();


        short k = 0;
        while (k < 4){
            System.out.print(buf[k++]); // c style? haha!
            System.out.print(' ');
        }

        System.out.println();

        char [][] records = {
                {'加', '瓦', '工', '程', '师'},
                {'你', '好', '啊'},
                {'H','i',' ', 'T', 'h', 'e', 'r', 'e', '!'}
        };

        for (int i = 0; i < 3; i++){
            System.out.print(records[i]);
            System.out.println();
        }


    }
}

