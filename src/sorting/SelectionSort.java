package sorting;

import java.util.Arrays;

public class SelectionSort {

    static void doSelectionSort(int[] ar){
        for(int i=0;i<ar.length;i++){
            int smallest = i;
            for(int j=i+1;j<ar.length;j++){
                if(ar[smallest]>ar[j]){
                    smallest = j;
                }
            }
            int temp = ar[i];
            ar[i] = ar[smallest];
            ar[smallest] = temp;
        }
    }

    public static void main(String[] args) {
        int[] ar = {4,3,6,7,8,9,2,10};
        doSelectionSort(ar);
        System.out.println(Arrays.toString(ar));
    }
}
