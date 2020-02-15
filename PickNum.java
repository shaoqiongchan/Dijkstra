package DP;

public class PickNum {

    public static void main(String[] args) {
//        int[] arr={1,3,5,7,6,4,2};
//        int[] arr={3,34,4,12,5,2};
        int[] arr={1,2,4,1,7,8,3};
        System.out.println(OPT(arr));
    }

    public static int OPT(int[] arr){
        int n=arr.length;
        int[] opt=new int[n];

        opt[0]=arr[0];
        opt[1]=Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            opt[i]=Math.max(opt[i-2]+arr[i],arr[i-1]);
        }
        return opt[n-1];
    }

}
