package sort;

import java.util.Objects;

public class BubbleSort implements Sortable{
    @Override
    public void sort(int[] arr) {
        if (arr == null) throw new IllegalArgumentException("Array should not be null");

        for (int i = arr.length - 1; i >= 0; i--){
            for (int j = 0 ; j < i; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
