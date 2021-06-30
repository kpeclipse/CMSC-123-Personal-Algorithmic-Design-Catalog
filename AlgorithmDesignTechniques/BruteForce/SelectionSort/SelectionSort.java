package AlgorithmDesignTechniques.BruteForce.SelectionSort;

public class SelectionSort {
    private static int[] A = { 89, 45, 68, 90, 29, 34, 17 };

    public static void main(String[] args) {
        System.out.println("SELECTION SORT\n");
        new SelectionSort(A);
    }

    public SelectionSort(int[] A) {
        // Display unsorted array
        display(A, false);
        progress(A);

        int min;

        for (int i = 0; i < A.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < A.length; j++)
                if (A[j] < A[min])
                    min = j;

            // Swap A[i] and A[min]
            int temp = A[min];
            A[min] = A[i];
            A[i] = temp;

            // Display current sort of the array
            progress(A);
        }

        // Display sorted array
        display(A, true);
    }

    public void progress(int[] A) {
        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void display(int[] A, boolean sorted) {
        if (!sorted)
            System.out.println("ARRAY: (UNSORTED)");
        else
            System.out.println("\nARRAY: (SORTED)");

        System.out.print("{ ");

        for (int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");

        System.out.print("}");
        System.out.println("\n");
    }
}