package sort;

public class QuickSort implements Sortable{
    @Override
    public void sort(int[] arr) {
        if (arr == null) throw new IllegalArgumentException("Array should not be null");
        quickSort(arr, 0, arr.length-1);
    }

    private void quickSort(int[] arr, int low, int high){
        if (low < high){
            int pi = partition(arr, low, high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    private int partition(int[] arr, int low, int high){
        int[]temp = new int[arr.length];
        int tempIndex = low;
        int pivot = low;

        for (int i = low; i<=high; i++){
            if (arr[i] < arr[pivot]){
                temp[tempIndex++] = arr[i];
            }
        }
        int pivotIndex = tempIndex+1;

        for (int i = low; i<=high; i++){
            if (arr[i]==arr[pivot]){
                temp[tempIndex++] = arr[i];
            }
        }

        for (int i = low; i<=high; i++){
            if (arr[i]>arr[pivot]){
                temp[tempIndex++] = arr[i];
            }
        }

        for (int i = low ; i<=high; i++){
            arr[i] = temp[i];
        }
        return pivotIndex;
    }
}
