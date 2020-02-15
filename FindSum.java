package DP;

public class FindSum {

    public static void main(String[] args) {
//        int[] arr={1,3,5,7,6,4,2};
        int[] arr={3,34,4,12,5,2};
        int s=13;
        int i= arr.length-1;
        System.out.println(subset(arr,i,s));
    }

    public static int subset(int[] arr,int i,int s){
        if(s==0){ return 1 ;}
        else if(i==0&&arr[0]==s){return 1;}
        else if(i==0&&arr[0]!=s){return 0;}
        else if(arr[i]>s){return subset(arr,i-1,s);}
        else{
            int A=subset(arr,i-1,s-arr[i]);
            int B=subset(arr,i-1,s);
            return Math.max(A,B);
        }
        }

    }

