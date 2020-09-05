import static java.lang.Integer.max;

public class MyerNP {
    private static int count = 0;
    public static void main(String[] args) {
        int[] A = new int[]{2, 1, 3, 4, 5, 2};
        int[] B = new int[]{1, 6, 2, 7, 4, 1, 6, 2};
        calc(A,B);
    }
    public static void calc(int[] A,int[] B){
        int p=-1;
        int m=A.length;
        int n=B.length;
        int d=Math.abs(n - m);
        int[] fp= new int[m+n+1];
        for(int i = 0; i < m+n+1; i++) {
            fp[i] = -1;
        }
        do {
            p = p + 1;
            for (int k = -p; k < d; k++) {
                fp[m + k] = snake(k, max(fp[m + k - 1] + 1, fp[m + k + 1]), A, B);
            }
            for (int k = d + p; k >= d + 1; k--) {
                fp[m + k] = snake(k, max(fp[m + k - 1] + 1, fp[m + k + 1]), A, B);
            }
            fp[m + d] = snake(d, max(fp[m + d - 1] + 1, fp[m + d + 1]), A, B);
        } while (fp[m + d] < n);
        System.out.println("O(NP)  | " + (d+(2*p)) + "            |     " + count);
    }

    private static int snake(int k, int y, int[] A, int[] B) {
        int x = y - k;
        count++;
        while(x < A.length && y < B.length && (A[x] == B[y])) {
            x++;
            y++;
            count++;
        }
        return y;
    }
}
