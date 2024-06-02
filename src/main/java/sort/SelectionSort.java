package sort;

public class SelectionSort implements Sortable{
    @Override
    public void sort(int[] arr) {
        if (arr == null) throw new IllegalArgumentException("Array should not be null");
        for (int i = 0; i < arr.length; i++){
            int min = arr[i];
            int minIndex = i;
            for ( int j = i; j < arr.length; j++){
                if (min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[minIndex] = temp;
        }
    }
}
