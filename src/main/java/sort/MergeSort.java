package sort;

public class MergeSort implements Sortable{
    @Override
    public void sort(int[] arr) {
        if (arr == null) throw new IllegalArgumentException("Array should not be null");
        mergeSort(arr, 0, arr.length-1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right){
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        int i = left;
        int j = mid+1;
        int k = left;
        while (i <= mid && j <= right){
            if (arr[i] < arr[j]){
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid){
            temp[k++] = arr[i++];
        }
        while (j <= right){
            temp[k++] = arr[j++];
        }
        for (int l = left; l <= right; l++){
            arr[l] = temp[l];
        }
    }




}
