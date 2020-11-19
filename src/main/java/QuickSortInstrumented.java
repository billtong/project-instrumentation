public class QuickSortInstrumented extends SortInstrumented {


    public QuickSortInstrumented(int[] array) {
        super(array);
    }

    private int partition(int low, int high) {
        int pivot = array[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++) {
            // If current element is smaller than the pivot
            if (array[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;
        return i+1;
    }

    private void quickSort(int low, int high) {
        Instrumentation.instance().startTiming("quick sort recursion");
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
        Instrumentation.instance().stopTiming("quick sort recursion");
        numberofCalling++;
    }

    @Override
    public void handle() {
        numberofCalling = 0;
        Instrumentation.instance().startTiming("quick sort");
        quickSort(0, array.length - 1);
        Instrumentation.instance().stopTiming("quick sort");
        Instrumentation.instance().comment("instrumentation number of call in quick sort:" + numberofCalling);
    }
}
