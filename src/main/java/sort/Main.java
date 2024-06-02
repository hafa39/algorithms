package sort;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        Sortable sortable = new QuickSort();
        sortable.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

    }
}
