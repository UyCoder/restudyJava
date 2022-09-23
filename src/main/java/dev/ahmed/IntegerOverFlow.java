package dev.ahmed;

/**
 * @author Ahmed Bughra
 * @create 2022-09-24  1:47 AM
 */
public class IntegerOverFlow {
    public static void main(String[] args) {
        method1(); // extracted method automatically generated
        method2();

    }

    private static void method2() {
        int l = 0;
        int r = Integer.MAX_VALUE -1;

        int m = (l+r)>>>1;
        System.out.println(m);

        // right side
        l = m + 1;
        m = (l+r)>>>1;
        System.out.println(m);


        m = (l+r)>>>1;
        System.out.println(m);

        System.out.println(126+63);
        System.out.println((126+63)/2);
        System.out.println((126+63)>>>1);
        //    (126+63)/2 and (126+63)>>>1 are equivalent for positive numbers integer
    }

    private static void method1() {
        int l = 0;
        int r = Integer.MAX_VALUE -1;

        int m = (l+r)/2;
        System.out.println(m);

        // right side
        l = m + 1;
        m = (r+l)/2;
        System.out.println(m);


        // l/2 + r/2  ==> l + (-l/2 + r/2) ==> l + (r-l)/2
        m = l + (r-l)/2;
        System.out.println(m);

        l = m + 1;
        m = l + (r - l) / 2;
        System.out.println(m);
    }
}
