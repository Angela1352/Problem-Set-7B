
/**
 * Angela Chen
 * 1-2
 * Nov. 27, 2023
 */

import java.util.ArrayList;

public class SieveConjectureBigInts {

    public static void main (String[] args) {
        System.out.println(sieve(100));
        System.out.println(goldbach(6));

        ArrayList<Integer> num1 = new ArrayList();
        num1.add(5);
        num1.add(9);
        num1.add(8);
        num1.add(7);
        ArrayList<Integer> num2 = new ArrayList();
        num2.add(3);
        num2.add(6);
        num2.add(9);

        System.out.println(bigInts(num1, num2));
    }

    public static ArrayList<Integer> sieve(int n) {
        ArrayList<Integer> sieve = new ArrayList();

        for (int i = 2; i < n+1; i++) {
            sieve.add(i);
        }

        for (int i = 0; i < sieve.size(); i++) {
            int p = sieve.get(i);
            for (int x = i+1; x < sieve.size(); x++) {
                if (sieve.get(x)%p == 0) {
                    sieve.remove(x);
                    x--;
                }
            }
        }
        return sieve;
    }

    public static ArrayList<Integer> goldbach(int sum) {
        ArrayList<Integer> primes = sieve(sum);
        ArrayList<Integer> goldbach = new ArrayList();

        for (int i = 0; i < primes.size(); i++) {
            int prime = primes.get(i);
            int num1 = sum-prime;

            if (primes.contains(num1)) {
                goldbach.add(prime);
                goldbach.add(num1);
                break;
            }
        }

        return goldbach;
    }

    public static ArrayList<Integer> bigInts(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> bigints = new ArrayList();
        int carry = 0;
        int lastA = a.size() - 1;
        int lastB = b.size() - 1;

        while (lastA >= 0 || lastB >= 0) {
            int sum = 0;
            if (lastA >= 0 && lastB >= 0) sum = a.get(lastA) + b.get(lastB) + carry;
            else if (lastA >= 0) sum = a.get(lastA) + carry;
            else if (lastB >= 0) sum = b.get(lastB) + carry;
            else sum = carry;

            if (sum > 9) {
                carry = 1;
                sum -= 10;
            } else carry = 0;

            bigints.add(0, sum);
            lastA--;
            lastB--;
        }

        if (carry > 0) bigints.add(0, 1); 

        return bigints;
    }

}
