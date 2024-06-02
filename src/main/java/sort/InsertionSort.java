package sort;

public class InsertionSort implements Sortable{
    @Override
    public void sort(int[] arr) {
        if (arr == null) throw new IllegalArgumentException("Array should not be null");

        for (int i = 0; i < arr.length; i++){
            int j = i-1;
            while (j >= 0){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                j--;
            }
        }
    }
}
