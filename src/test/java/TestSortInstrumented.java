import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestSortInstrumented {

    @Test
    public void testBubbleSort() {
        int[] arr = Main.populateArray(1000);
        Sort sort = new BubbleSortInstrumentated(arr);
        sort.handle();
        Arrays.sort(arr);
        Assert.assertArrayEquals(sort.getArray(), arr);
    }

    @Test
    public void testQuickSort() {
        int[] arr = Main.populateArray(1000);
        Sort sort = new QuickSortInstrumented(arr);
        sort.handle();
        Arrays.sort(arr);
        Assert.assertArrayEquals(sort.getArray(), arr);
    }
}
