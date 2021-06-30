package AlgorithmDesignTechniques.TransformAndConquer.HeapSort;

public class HeapSort {
    private static int[] arr = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };

    public static void main(String[] args) {
        new HeapSort(arr);
    }

    public HeapSort(int[] H) {
        System.out.println("Heap and Heapsort\n");

        System.out.print("Input: ");
        showHeap(H);

        System.out.println();

        System.out.print("Heap: ");
        int[] maxHeap = constructHeap(H);
        showHeap(maxHeap);

        System.out.println();

        System.out.print("Heapsort: ");
        maxHeap = heapsort(maxHeap);
        showHeap(maxHeap);
    }

    public int[] heapsort(int[] heap) {
        for (int i = heap.length - 1; i >= 0; i--) {

            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;

            heapify(heap, i, 0);
        }

        return heap;
    }

    public int[] constructHeap(int[] H) {
        // boolean heap;

        for (int i = (H.length / 2); i >= 0; i--) {
            heapify(H, H.length, i);
        }

        return H;
    }

    public void heapify(int[] H, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && H[l] > H[largest])
            largest = l;

        if (r < n && H[r] > H[largest])
            largest = r;

        if (largest != i) {
            int swap = H[i];
            H[i] = H[largest];
            H[largest] = swap;

            heapify(H, n, largest);
        }
    }

    public void showHeap(int[] H) {
        for (int i : H) {
            System.out.print(i + " ");
        }
    }
}