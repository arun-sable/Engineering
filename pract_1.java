//Fibonacci numbers
class pract_1 {
public static void main(String[] args) {
        int n = 10; // Number of terms in the series

        int fibPrev = 0;
        int fibCurrent = 1;

        System.out.print("Fibonacci Series: " + fibPrev + " " + fibCurrent);

        for (int i = 2; i < n; i++) {
            int fibNext = fibPrev + fibCurrent;
            System.out.print(" " + fibNext);
            fibPrev = fibCurrent;
            fibCurrent = fibNext;
        }

        System.out.println();
    }
}

