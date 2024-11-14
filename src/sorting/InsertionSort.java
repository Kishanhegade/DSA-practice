package sorting;

import java.util.Arrays;

public class InsertionSort {

    static void doInsertionSort(int[] ar){
        for(int i=1;i<ar.length;i++){
            int j=i-1;
            int key = ar[i];
            while(j>=0 && ar[j]>key){
                ar[j+1]=ar[j];
                j--;
            }
            ar[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] ar = {3,2,5,4,7,6,9,8};
        doInsertionSort(ar);
        System.out.println(Arrays.toString(ar));
    }
}
