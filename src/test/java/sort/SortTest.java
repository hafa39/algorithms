package sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Test sort algorithms")
class SortTest {

    int[] toSort;
    int[] sorted = {1, 2, 3, 4, 5};
    @BeforeEach
    void setUp() {
        toSort = new int[]{5, 3, 2, 4, 1};
    }

    @Test
    @DisplayName("insertion sort")
    void testInsertionSort() {
        Sortable sortable = new InsertionSort();
        sortable.sort(toSort);
        assertArrayEquals(sorted, toSort);
    }
    @Test
    @DisplayName("selection sort")
    void testSelectionSort() {
        Sortable sortable = new SelectionSort();
        sortable.sort(toSort);
        assertArrayEquals(sorted, toSort);
    }
    @Test
    @DisplayName("bubble sort")
    void testBubbleSort() {
        Sortable sortable = new BubbleSort();
        sortable.sort(toSort);
        assertArrayEquals(sorted, toSort);
    }
    @Test
    @DisplayName("merge sort")
    void testMergeSort() {
        Sortable sortable = new MergeSort();
        sortable.sort(toSort);
        assertArrayEquals(sorted, toSort);
    }
    @Test
    @DisplayName("quick sort")
    void testQuickSort() {
        Sortable sortable = new QuickSort();
        sortable.sort(toSort);
        assertArrayEquals(sorted, toSort);
    }

    @Test
    @DisplayName("null array test")
    void testNullArray() {
        Sortable selectionSort = new SelectionSort();
        assertThrows(IllegalArgumentException.class, () -> selectionSort.sort(null));

        Sortable insertionSort = new InsertionSort();
        assertThrows(IllegalArgumentException.class, () -> insertionSort.sort(null));

        Sortable bubbleSort = new BubbleSort();
        assertThrows(IllegalArgumentException.class, () -> bubbleSort.sort(null));

        Sortable mergeSort = new MergeSort();
        assertThrows(IllegalArgumentException.class, () -> mergeSort.sort(null));

        Sortable quickSort = new QuickSort();
        assertThrows(IllegalArgumentException.class, () -> quickSort.sort(null));
    }
}