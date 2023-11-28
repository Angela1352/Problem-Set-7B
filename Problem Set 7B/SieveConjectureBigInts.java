
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

        ArrayList<Integer> num1 = convertInt(350);
        ArrayList<Integer> num2 = convertInt(450);   
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

    public static ArrayList<Integer> convertInt(int num) {
        ArrayList<Integer> bigInt = new ArrayList();
        
        for (int i = 0; i < num.size(); i++) {
            
        }
    }

    public static ArrayList<Integer> bigInts(ArrayList<Integer> num1, ArrayList<Integer> num2) {
        ArrayList<Integer> bigints = new ArrayList();

        for (int i = 0; i < num1.size(); i++) num1.add(i);
        for (int i = 0; i < num2.size(); i++) num2.add(i);

        return bigints;
    }

}

