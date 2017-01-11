import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


/**
 * Created by ArthurArt on 10.12.2016.
 */
public class HomeWorkTask6 {
    public static int min(int a, int b, int c, int d) {
        if ((a < b) && (a < c) && (a < d)) return a;
        else if ((b < c) && (b < d)) return b;
        else if (c < d) return c;
        else return d;


    }


    public static void task1(Scanner sc) {
        System.out.print(min(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
    }

    public static double power(double a, int n) {
        double abuf = 1;
        if (n != 0) {
            while (n != 0) {
                if (n == 1) n -= 1;
                else if (n % 2 == 0) {
                    a *= a;
                    n /= 2;
                } else {
                    abuf *= a;
                    n -= 1;
                }
            }
        } else a = 1;
        return a * abuf;
    }

    public static void task2(Scanner sc) {
        System.out.print(power(sc.nextDouble(), sc.nextInt()));
    }

    public static boolean Xor(boolean x, boolean y) {
        //x^y
        if (x == y) return false;
        else return true;
    }

    public static void task3(Scanner sc) {

        System.out.print(Xor(sc.nextInt() != 0, sc.nextInt() != 0));
    }

    public static boolean Election(boolean x, boolean y, boolean z) {
        return y & z ^ x & z ^ y & x;
    }

    public static void task4(Scanner sc) {

        System.out.print(Election(sc.nextInt() != 0, sc.nextInt() != 0, sc.nextInt() != 0));
    }

    public static boolean IsPrime(int n) {
        boolean itog = false;
        for (int i = 2; i < n / 2; i++) {
            if ((n % i == 0) && (n / i != 1.0)) {
                itog = true;
                break;
            }

        }
        return itog;
    }


    public static void task5(Scanner sc) {

        if (IsPrime(sc.nextInt())) System.out.print("composite");
        else System.out.print(" prime");


    }

    public static int SumOfDigits(int n) {
        int sum = 0;
        do {
            sum += n % 10;
            n = n / 10;
        } while (n != 0);
        return sum;
    }

    public static void task6(Scanner sc) {
        System.out.print(SumOfDigits(sc.nextInt()));
    }

    public static int reverse(int n) {
        int newNumber = 0;
        while (n != 0) {
            newNumber = newNumber * 10 + n % 10;
            n = n / 10;
        }
        return newNumber;
    }

    public static void task7(Scanner sc) {
        System.out.print(reverse(sc.nextInt()));
    }


    public static boolean IsPalindrome(int n) {
        if (n == reverse(n)) return true;
        else return false;
    }

    public static void task8(Scanner sc) {
        int sum = 0, n = sc.nextInt();

        for (int i = 1; i < n; i++)
            if (IsPalindrome(i)) sum += 1;


        System.out.print(sum);


    }

    public static double powerOfRecursia(double a, int n) {
        if (n > 0) return a * powerOfRecursia(a, n - 1);
        else if (n < 0) return 1 / a * powerOfRecursia(a, n + 1);
        else return 1;
    }

    public static void task21(Scanner sc) {

        System.out.print(powerOfRecursia(sc.nextDouble(), sc.nextInt()));
    }

    public static void task22(Scanner sc) {

        System.out.print(powerOfRecursia(sc.nextDouble(), sc.nextInt()));
    }

    public static double powerOrSuperRecursia(double a,int n)
    {

        if(n!=0)
        {
            if(n%2==0)return  powerOrSuperRecursia(a*=a,n/=2);
            else return a*powerOrSuperRecursia (a,n-=1);
        }
        else return 1 ;

    }

    public static void task23(Scanner sc){

        System.out.print( powerOrSuperRecursia(sc.nextDouble(),sc.nextInt()));
    }



    public static int phi(int n) {
        if (n == 0) return 0;
        else if (n < 2) return 1;
        else return phi(n - 1) + phi(n - 2);
    }

    public static void task24(Scanner sc) {
        System.out.print(phi(sc.nextInt()));
    }

    public static int binom(int n, int k) {
        if (k == 0 || n == k) return 1;
        else return binom(n - 1, k - 1) + binom(n - 1, k);
    }

    public static void task25(Scanner sc) {
        System.out.print(binom(sc.nextInt(), sc.nextInt()));
    }
    public static int[] Creatmas(int n){
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i]= random.nextInt(10); if(array[i]==0) array[i]=1;
            System.out.format("%d ",array[i]);
        }
        System.out.format("%n");
        return array;
    }

    public static int Search(int A[],int n,int x){
        if(n%2!=0) {
            if (A[n - 1] == x) return n - 1;
            n = n - 1;
        }
        for (int i = 0; i < n/2; i++) {
            if(x==A[i]) return i;
            else if(x==A[n-1-i]) return n-1-i;
        }
        return -1;
    }

    public static void task31(Scanner sc) {
        int n = sc.nextInt(), x = sc.nextInt();
        System.out.print(Search(Creatmas(n), n, x));
    }

    public static int CountMax(int A[], int n) {
        int max = -1, maxcount = 1;
        if (n % 2 != 0) {
            max = A[n - 1];
            n = n - 1;
        }
        for (int i = 0; i < n / 2; i++) {
            if (max == A[i]) maxcount++;
            else if (max < A[i]) {
                max = A[i];
                maxcount = 1;
            }
            if (max == A[n - 1 - i]) maxcount++;
            else if (max < A[n - 1 - i]) {
                max = A[n - 1 - i];
                maxcount = 1;
            }

        }
        return maxcount;
    }

    public static void task32(Scanner sc) {
        int n = sc.nextInt();
        System.out.print(CountMax(Creatmas(n), n));
    }

    public static void LastMax(int A[]) {
        int n = A.length;
        int max = -1, maxindex = -1;
        if (n % 2 != 0) {
            max = A[n - 1];
            maxindex = n - 1;
            n = n - 1;
        }
        for (int i = 0; i < n / 2; i++) {
            if (max == A[i]) ;
            else if (max < A[i]) {
                max = A[i];
                maxindex = i;
            }
            if (max == A[n - 1 - i] && maxindex < n - 1 - i) maxindex = n - 1 - i;
            else if (max < A[n - 1 - i]) {
                max = A[n - 1 - i];
                maxindex = n - 1 - i;
            }
        }
        System.out.format("%d %d", max, maxindex);
    }

    public static void task33(Scanner sc) {
        int n = sc.nextInt();
        LastMax(Creatmas(n));
    }

    public static void merge(int A[], int n, int B[], int m, int C[]) {
        int i = 0, j = 0, a, b;
        for (int k = 0; k < C.length; k++) {

            if (i > A.length - 1) {
                a = B[j];
                C[k] = a;
                j++;
            } else if (j > B.length - 1) {
                a = A[i];
                C[k] = a;
                i++;
            } else if (A[i] < B[j]) {
                a = A[i];
                C[k] = a;
                i++;
            } else {
                b = B[j];
                C[k] = b;
                j++;
            }
        }
        System.out.println("sort mass:");
        for (int k = 0; k < A.length; k++) {
            System.out.print(A[k] + " ");
        }
        System.out.println("");
        for (int k = 0; k < B.length; k++) {
            System.out.print(B[k] + " ");
        }
        System.out.println("");
        for (int k = 0; k < C.length; k++) {
            System.out.print(C[k] + " ");
        }
    }

    public static void task34(Scanner sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = Creatmas(n), B = Creatmas(m), C = new int[n + m];
        Arrays.sort(A);
        Arrays.sort(B);
        merge(A, n, B, m, C);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //task1(sc);
        // task2(sc);
        // task3(sc);
        //task4(sc);
        //task5(sc);
        // task6(sc);
        // task7(sc);

        //task21(sc);
        //task22(sc);
        //task23(sc);
        //task24(sc);
        //task25(sc);

        //task31(sc);
        //task32(sc);
        //task33(sc);
        //task34(sc);


    }
}