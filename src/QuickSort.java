public class QuickSort {
    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;
        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int opora = array[middle];

        int i = low;
        int j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }
            while (array[j] > opora) {
                j--;
            }
            if (i <= j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(array, j, low);
        }
        if (high > i) {
            quickSort(array, i, high);
        }
    }

    public static void main(String[] args) {
        int[] array = {8, 0, 4, 7, 3, 7, 10, 12, -3};
        // выводим неотсортированный массив
        System.out.println("Неотсортированный массив");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        int low = 0;
        int high = array.length - 1;
        quickSort(array, low, high);
        // выводим отсортированный массив
        System.out.println("Отсортированный массив");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
