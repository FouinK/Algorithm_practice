

import java.util.Scanner;

public class Main {

    static long c;
    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();
        c = sc.nextInt();

        System.out.println(pow(a,b));
    }

    public static long pow(long a, long zisu) {

        if (zisu == 1) {
            return  a%c ;
        }

        long temp = pow(a, zisu / 2);

        if (zisu % 2 == 0) {
            return temp * temp % c;
        }

        return (temp*temp % c) * a % c;
    }
}