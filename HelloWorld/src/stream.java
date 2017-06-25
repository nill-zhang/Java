/**
 * Created by Admin on 6/24/2017.
 */
public class stream {
    public static void main(String args[])
            throws java.io.IOException {
        /*
        * stdin-----------------System.in.read(byte[])---------------->in_buf
        *
        * out_buf-------------System.out.write(byte[])----------------->stdout
        * */
        byte[] out_buf = new byte[5], in_buf = new byte[50];
        for (int i = 0; i < 5; i++) {
            out_buf[i] = (byte) ('A' + 32 + i);
        }
        System.out.printf("length of b: %d\n", out_buf.length);
        //provide a buffer as the source of write, default write destination is console
        System.out.write(out_buf);
        System.out.println();


        int counter = System.in.read(in_buf);
        System.out.printf("number of bytes read into the buffer: %d%n", counter);
        for (byte k: in_buf){
            System.out.printf("content of in buffer: %d%n", k);
        }
    }
}