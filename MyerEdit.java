public class MyerEdit {

    public static void main(String[] args)
    {
        int[] A=new int[]{2,1,3,4,5,2};
        int[] B=new int[]{1,6,2,7,4,1,6,2};
        calc(A,B);
    }

    public static int calc(int[] A, int[] B){
        int m = A.length;
        int n = B.length;
        int max = m+n;
        int v[] = new int[2 * max + 1];
        v[0]=0;
        int d = 0, x = 0, y = 0, count = 0;
        for (d = 0; d <= max; d++)
        {
            for(int k = -d; k <= d; k = k+2)
            {
                if((k == -d || k != d) && (v[max + k - 1] < v[max + k + 1])) {
                    x = v[max + k + 1];
                } else {
                    x = v[max + k - 1] + 1;
                }
                y = x - k;
                count++;
                while((x < m) && (y < n) && (A[x] == B[y])) {
                        x++;
                        y++;
                        count++;
                }
                v[max + k] = x;
                if (x >= m && y >= n) {
                    System.out.println("O(ND)  | " + d + "            |    " + count);
                    return d;
                }
            }
        }
        System.out.println("Length of an SES is greater than MAX: " + max + " with num of comparisons: " + count);
        return 0;
    }
}
