public class SelectionSort {
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            int tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
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

        selectionSort(array);
        System.out.println("Отсортированный массив");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
