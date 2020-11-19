public class Main {

    public static int[] populateArray(int size) {
        Instrumentation.instance().startTiming("polulate array");
        int[] arr = new int[size];
        for (int i=0; i<size; i++) {
            arr[i] = (int) (Math.random() * 99999 + 1);
        }
        Instrumentation.instance().stopTiming("polulate array");
        return arr;
    }

    public static void sortRunTime(Sort sort, String comment) {
        Instrumentation ins = Instrumentation.instance();
        ins.startTiming(comment);
        sort.handle();
        ins.stopTiming(comment);
    }

    public static void overHead(int number) {
        Instrumentation instrumentation = Instrumentation.instance();
        instrumentation.activate(true);
        for (int i = 0; i<number; i++) {
            instrumentation.startTiming("overhead looping");
            instrumentation.stopTiming("overhead looping");
        }
        instrumentation.comment("over head finished");
    }

    public static void main(String[] args) {
        int[] size = {5,10, 50 ,100, 500, 1000, 5000, 10000, 50000, 100000};
        int[] num = { 7, 13, 67, 131, 661, 133, 6605, 13331, 66777, 135377};
        Instrumentation ins = Instrumentation.instance();
        ins.activate(true);
        ins.startTiming("main");
        for (int s : size) {
            int[] commonArray = Main.populateArray(s);
            Main.sortRunTime(new BubbleSort(commonArray.clone()), "bubble sort");
            Main.sortRunTime(new QuickSort(commonArray.clone()), "quick sort");
            new BubbleSortInstrumentated(commonArray.clone()).handle();
            new QuickSortInstrumented(commonArray.clone()).handle();
        }
        for (int s : num) {
            ins.startTiming("overhead");
            overHead(s);
            ins.stopTiming("overhead");
        }
        ins.stopTiming("main");
        ins.dump("project-3.log");
        ins.activate(false);
    }


    /*
    public static void main(String[] args) {
        Instrumentation ins = Instrumentation.instance();
        ins.activate(true);
        ins.startTiming("main");
        ins.stopTiming("main");
        ins.dump("project-3-main.log");
        ins.activate(false);
    }
     */

}
