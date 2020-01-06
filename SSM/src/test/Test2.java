/**
 * @author ：clt
 * @Date ：Created in 16:16 2019/10/29
 */
public class Test2 {
    public static void main(String[] args) {
        int i, k;
        int[] a = new int[10];
        int[] p = new int[3];
        k = 10;
        for (i = 0; i < 10; i++) {
            a[i] = i;
        }
        for (i = 0; i < 3; i++) {
            p[i] = a[i * (i + 1)];
        }
        for (i = 0; i < 3; i++) {
            k += p[i] * 2;
        }
        System.out.println(k);
    }


}
