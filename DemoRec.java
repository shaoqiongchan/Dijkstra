import java.util.Arrays;

public class DemoRec {

    public static void main(String[] args) {
        int[] arr = {7, 5, 2, 6};  //噪声值（千）
        System.out.println(subset(arr));
    }

    public static double subset(int[] arr) {
        double v1 = 1.4;  //端口p1(门限5000，成本1.4)
        double v2 = 1.7;  //端口p1(门限6000，成本1.7)
        double v3 = 1.8;  //端口p1(门限8000，成本1.8)

        if (arr.length == 1) {
            if (arr[0] <= 5) {
                return v1;
            } else if (arr[0] > 5 & arr[0] <= 6) {
                return v2;
            } else {
                return v3;
            }
        } else if (arr.length == 2) {
            if (arr[0] + arr[1] <= 8) {
                return subset(new int[]{arr[0] + arr[1]});
            } else {
                return subset(new int[]{arr[0]}) + subset(new int[]{arr[1]});
            }
        } else {
            if (sum(arr, arr.length) <= 8) {
                return subset(new int[]{sum(arr, arr.length)});
            } else {
                double cost = 10000.0;
                for (int i = 1; i < arr.length; i++) {
                    double A = subset(Arrays.copyOfRange(arr, 0, i)) + subset(Arrays.copyOfRange(arr, i, arr.length));
                    if (A < cost) {
                        cost = A;
                    }
                }
                return cost;
            }
        }
    }

    private static int sum(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        } else {
            return arr[n - 1] + sum(arr, --n);
        }
    }
}