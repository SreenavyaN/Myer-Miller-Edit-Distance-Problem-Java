import java.util.Random;

public class Sort {
    private static int RANDOM_NUM_BOUND = 99;
    private static Random rand = new Random(9999);

    public static void main(String args[]) {
        int[] del = {10, 50, 100, 200, 400, 600, 800, 1000};
        int m = 4000, n = 5000;
        int[] B;
        int[] A;
        int k = 0;
        while (k < 8) {
            A = generateA(m);
            B = generateB(A, n, del[k]);
            System.out.println("     " +(k+1)+ " |  Edit Distance  |  No of Comparisions ");
            System.out.println("----------------------------------------------");
            MyerEdit.calc(A, B);
            MyerNP.calc(A, B);
            System.out.println("----------------------------------------------");
            k++;
        }
    }

    private static int[] copyArray(int[] A, int size) {
        int[] B = new int[size];
        int a_length = A.length;
        for (int i = 0; i < a_length; i++) B[i] = A[i];
        for (int i = a_length; i < size; i++) B[i] = rand.nextInt(RANDOM_NUM_BOUND);
        return B;
    }

    public static void replaceRandomArrayElements(int[] X, int subset_length, int n) {
        for (int i = 0; i < n; i++) {
            int pos = rand.nextInt(subset_length);
            X[pos] = rand.nextInt(RANDOM_NUM_BOUND);
        }
    }

    private static int[] generateB(int[] A, int b_length, int del) {
        int[] B = copyArray(A, b_length);
        replaceRandomArrayElements(B, A.length, del);
        return B;
    }

    public static int[] generateA(int a_length) {
        int[] A = new int[a_length];
        for (int i = 0; i < a_length; i++) A[i] = rand.nextInt(RANDOM_NUM_BOUND);
        return A;
    }
}
