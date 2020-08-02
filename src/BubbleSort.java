public class BubbleSort {
    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        int tmp;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    isSorted = false;
                    tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {8, 0, 4, 7, 3, 7, 10, 12, -3};
        // выводим неотсортированный массив
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        bubbleSort(array);
        // выводим отсортированный массив
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
