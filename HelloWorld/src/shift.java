import java.sql.Struct;
import java.util.Formatter;

/**
 * Created by Admin on 6/22/2017.
 */
public class shift {
    public static void main(){
        byte  bb= (byte)0b1111_1000;                      // -8
        short sb= (short)0b11111111_11111000;             // -8
        int   ib= 0b11111111_11111111_11111111_11111000;  // -8
        Formatter fmt = new Formatter();
        fmt.format("%s:  >>2=%x,>>>2=%x,<<2=%x", "bb", bb>>2, bb>>>2, bb<<2);
        System.out.println(fmt);

        fmt.format("%s:  >>2=%x,>>>2=%x,<<2=%x", "sb", sb>>2, sb>>>2, sb<<2);
        System.out.println(fmt);

        fmt.format("%s:  >>2=%x,>>>2=%x,<<2=%x", "ib", ib>>2, ib>>>2, ib<<2);
        System.out.println(fmt);

    }
}
