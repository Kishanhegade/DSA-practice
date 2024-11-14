package sorting;

import java.util.Arrays;

public class BubbleSort {

    static int[] doBubbleSortUp(int[] ar){
        for(int i=1;i<ar.length;i++){
            for(int j=0;j<ar.length-i;j++) {
                if (ar[j] > ar[j + 1]) {
                    int temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                }
            }
        }
        return ar;
    }
    static int[] doBubbleSortDown(int[] ar){
        for(int i=0;i<ar.length;i++){
            for(int j=ar.length-1;j>i;j--){
                if(ar[j]<ar[j-1]){
                    int temp = ar[j];
                    ar[j]=ar[j-1];
                    ar[j-1]=temp;
                }
            }
        }
        return ar;
    }

    public static void main(String[] args) {
        int[] ar = {6,5,3,1,8,7,2,4};
        ar = doBubbleSortUp(ar);
        System.out.println(Arrays.toString(ar));
        ar = doBubbleSortDown(ar);
        System.out.println(Arrays.toString(ar));
    }
}
