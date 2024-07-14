import java.util.Random;

public class App {

    public static int mergeCompare = 0;
    public static int quickCompare = 0;

    // Swap fuction for common usage
    public static void swap(int array[], int num1, int num2) {
        int tmp;

        tmp = array[num1];
        array[num1] = array[num2];
        array[num2] = tmp;
    }

    //---------------------------------------------------

    // Selection sort
    public static long selectionSort(int array[], int size) {
        long startTime = System.currentTimeMillis();
        int i, minIndex, compare = 0;

        for(i = 1; i < size; i++) {
            minIndex = i;
            for(int j = i + 1; j < size; j++) {
                compare++;
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            swap(array, i, minIndex);
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("Num of comparisons : %d  ", compare);
        return endTime - startTime;
    }

    //---------------------------------------------------

    // Bubble sort
    public static long bubbleSort(int array[], int size) {
        long startTime = System.currentTimeMillis();
        int i, j, compare = 0;

        for(i = 1; i < (size - 1); i++) {
            for(j = 0; j < (size - i); j++) {
                compare++;
                if(array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("Num of comparisons : %d  ", compare);
        return endTime - startTime;
    }

    //---------------------------------------------------

    // Merge sort and merge sort functions
    public static long mergeSort(int array[], int size) {
        long startTime = System.currentTimeMillis();

        int i;
        int mid = size / 2;
        int[] left = new int[mid];
        int[] right = new int[size - mid];

        if (size < 2) {
            return 0;
        }

        for (i = 0; i < mid; i++) {
            left[i] = array[i];
        }

        for (i = mid; i < size; i++) {
            right[i - mid] = array[i];
        }

        mergeSort(left, (size / 2));
        mergeSort(right, (size - (size / 2)));   
        merge(array, left, right, size);

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void merge(int array[], int left[], int right[], int orgSize) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
              mergeCompare++;
              array[k++] = left[i++];
            } else {
              mergeCompare++;
              array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }  
    }

    public static int getMergeCompare() {
        return mergeCompare;
    }

    //---------------------------------------------------

    // Quick sort and quick sort functions
    public static long quickSort(int array[], int left, int right) {
        long startTime = System.currentTimeMillis();
        int i, j, pivot, pivotIndex;
    
        if (left >= right) {
            return 0;
        }
    
        pivotIndex = left + (int) (Math.random() * (right - left + 1));
        pivot = array[pivotIndex];

        swap(array, pivotIndex, right);
    
        i = left - 1;
        j = right;
    
        while (true) {
            do {
                i++;
                quickCompare++;
            } while (array[i] < pivot);
    
            do {
                j--;
                quickCompare++;
            } while (j >= left && array[j] > pivot);
    
            if (i >= j) {
                break;
            }
    
            swap(array, i, j);
        }
    
        swap(array, i, right);
    
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    
        return System.currentTimeMillis() - startTime;
    }
    
    public static void sort(int array[], int left, int right) {
        int i, j, key;

        for (i = left + 1; i <= right; i++) {
            key = array[i];
            j = i - 1;
    
            while (j >= left && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
    
            array[j + 1] = key;
        }
    }

    public static int getQuickCompare() {
        return quickCompare;
    }

    //---------------------------------------------------

    // Counting sort 
    public static long countingSort(int array[], int size) {
        long startTime = System.currentTimeMillis();

        int compare = 0;
        int max = array[0];
        int i;

        for (i = 1; i < size; i++) {
            if (array[i] > max) {
            max = array[i];
            }
        }

        int[] count = new int[max + 1];
        int[] output = new int[size];
    
        for (i = 0; i < size; i++) {
            count[array[i]]++;
        }
    
        for (i = 1; i <= max; i++) {
            compare++;
            count[i] += count[i - 1];
        }
    
        for (i = (size - 1); i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }
    
        for (i = 0; i < size; i++) {
            array[i] = output[i];
        } 

        long endTime = System.currentTimeMillis();
        System.out.printf("Num of comparisons : %d  ", compare);
        return endTime - startTime;
    }

    //---------------------------------------------------

    // Generate random arrays
    public static int[] generateArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        int i;

        for (i = 0; i < size; i++) {
            array[i] = random.nextInt((int) Math.pow(10, 6));
        }
        return array;
    }
    
    public static void main(String[] args) throws Exception {
        int[] arr1k = generateArray(1000);
        System.out.println();

        System.out.println("For 1000 element :");
        System.out.println("Selection sort : " + selectionSort(arr1k, 1000) + " ms.");
        System.out.println("Bubble sort : " + bubbleSort(arr1k, 1000) + " ms.");
        System.out.println("Merge sort : " + mergeSort(arr1k, 1000) + " ms." + "  Num of comparisons : " + getMergeCompare());
        System.out.println("Quick sort : " + quickSort(arr1k, 0, 999) + " ms." + "  Num of comparisons : " + getQuickCompare());
        System.out.println("Counting sort : " + countingSort(arr1k, 1000) + " ms.");

        int[] arr10k = generateArray(10000);
        System.out.println();
        mergeCompare = 0;
        quickCompare = 0;

        System.out.println("For 10000 element :");
        System.out.println("Selection sort : " + selectionSort(arr10k, 10000) + " ms.");
        System.out.println("Bubble sort : " + bubbleSort(arr10k, 10000) + " ms.");
        System.out.println("Merge sort : " + mergeSort(arr10k, 10000) + " ms." + "  Num of comparisons : " + getMergeCompare());
        System.out.println("Quick sort : " + quickSort(arr10k, 0, 9999) + " ms." + "  Num of comparisons : " + getQuickCompare());
        System.out.println("Counting sort : " + countingSort(arr10k, 10000) + " ms.");


        int[] arr50k = generateArray(50000);
        System.out.println();
        mergeCompare = 0;
        quickCompare = 0;

        System.out.println("For 50000 element :");
        System.out.println("Selection sort : " + selectionSort(arr50k, 50000) + " ms.");
        System.out.println("Bubble sort : " + bubbleSort(arr50k, 50000) + " ms.");
        System.out.println("Merge sort : " + mergeSort(arr50k, 50000) + " ms." + "  Num of comparisons : " + getMergeCompare());
        System.out.println("Quick sort : " + quickSort(arr50k, 0, 49999) + " ms." + "  Num of comparisons : " + getQuickCompare());
        System.out.println("Counting sort : " + countingSort(arr50k, 50000) + " ms.");

        int[] arr100k = generateArray(100000);
        System.out.println();
        mergeCompare = 0;
        quickCompare = 0;

        System.out.println("For 100000 element :");
        System.out.println("Selection sort : " + selectionSort(arr100k, 100000) + " ms.");
        System.out.println("Bubble sort : " + bubbleSort(arr100k, 100000) + " ms.");
        System.out.println("Merge sort : " + mergeSort(arr100k, 100000) + " ms." + "  Num of comparisons : " + getMergeCompare());
        System.out.println("Quick sort : " + quickSort(arr100k, 0, 99999) + " ms." + "  Num of comparisons : " + getQuickCompare());
        System.out.println("Counting sort : " + countingSort(arr100k, 100000) + " ms.");
    }
}

