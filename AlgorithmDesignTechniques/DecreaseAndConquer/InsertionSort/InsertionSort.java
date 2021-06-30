package AlgorithmDesignTechniques.DecreaseAndConquer.InsertionSort;

public class InsertionSort {
    private static int[] A = { 89, 45, 68, 90, 29, 34, 17 };

    public static void main(String[] args) {
        System.out.println("INSERTION SORT\n");
        new InsertionSort(A);
    }

    public InsertionSort(int[] A) {
        // Display unsorted array
        display(A, false);
        progress(A);

        int v = 0;
        int j = 0;

        for (int i = 1; i < A.length; i++) {
            v = A[i];
            j = i - 1;

            while (j >= 0 && A[j] > v) {
                A[j + 1] = A[j];
                j = j - 1;
            }

            A[j + 1] = v;

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