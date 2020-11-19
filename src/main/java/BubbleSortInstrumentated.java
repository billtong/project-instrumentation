public class BubbleSortInstrumentated extends SortInstrumented {
    public BubbleSortInstrumentated(int[] array) {
        super(array);
    }

    @Override
    public void handle() {
        Instrumentation instrumentation = Instrumentation.instance();
        instrumentation.activate(true);
        instrumentation.startTiming("bubble sort");
        numberofCalling = 0;
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        instrumentation.stopTiming("bubble sort outer");
        numberofCalling++;
        instrumentation.comment("instrumentation number of call in bubble sort:" + numberofCalling);
    }

}
