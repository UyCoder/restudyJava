package dev.ahmed;

/**
 * @author Ahmed Bughra
 * @create 2022-10-17  11:43 PM
 */
public class Test {
    public static void main(String[] args) {
        int i = 5634;
        int ming = i/1000;
        int yuz = i/100%10;
        int onlar = i%100/10;
        int bir = i%10;
        System.out.println(ming);
        System.out.println(yuz);
        System.out.println(onlar);
        System.out.println(bir);
        int i2 = 23;
        int i3 = i2++;
        int i4= i2++;
        int i5 = i2++;

        System.out.println(i3);
        System.out.println(i4);
        System.out.println(i5);
    }
}
