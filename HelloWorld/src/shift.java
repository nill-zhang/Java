import java.util.Formatter;

/**
 * Created by sfzhang on 6/22/2017.
 */
public class shift {
    public static void main(String []args){
        byte  bb_negative = (byte)0b1111_1000;                         // -8
        short sb_negative = (short)0b11111111_11111000;                // -8
        int   ib_negative = 0b11111111_11111111_11111111_11111000;     // -8

        byte bb_positive = (byte)0b0000_1000;                          //  8
        short sb_positive = (short)0b00000000_00001000;                //  8
        int ib_positive = (int)0b00000000_000000000_00000000_00001000; //  8



        System.out.printf("bb(-8): %s\n", shiftPrinter(bb_negative));
        System.out.printf("sb(-8): %s\n", shiftPrinter(sb_negative));
        System.out.printf("ib(-8): %s\n", shiftPrinter(ib_negative));
d
        System.out.printf("bb(+8): %s\n", shiftPrinter(bb_positive));
        System.out.printf("sb(+8): %s\n", shiftPrinter(sb_positive));
        System.out.printf("ib(+8): %s\n", shiftPrinter(ib_positive));

        // let's see the following example
        // call fmt.format() multiple times, it accumulate those formats.

        Formatter fmt = new Formatter();
        fmt.format("%s", "1");
        System.out.println(fmt);

        fmt.format("%s", "2");
        System.out.println(fmt);
        // fmt.close(); use it after you closed it will cause exception

        fmt.format("%s", "3");
        System.out.println(fmt);

        String s = fmt.toString();
        System.out.println("what is fmt now?: " + s);

        fmt.close();

    }


    /**
     * formats output
     */
    public static String shiftPrinter(int i){

        Formatter fmt = new Formatter();
        fmt.format(">>2=%32s,>>>2=%32s,<<2=%32s", b(i>>2), b(i>>>2), b(i<<2));
        // fill the empty characters in the string with '0'
        String str = fmt.toString().replace(' ', '0');
        fmt.close();
        return str;

    }

    /**
     *  a wrapper converts an integer to its binary form String representation
     */
    public static String b(int i){
        return  Integer.toBinaryString(i);
    }


}
