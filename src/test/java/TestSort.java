import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class TestSort {
    int[] size = {5,10, 50 ,100, 500, 1000, 5000, 10000, 50000, 100000};
    @Test
    public void testBubbleSort() {
        for (int s : size) {
            int[] arr = Main.populateArray(s);
            Sort sort = new BubbleSort(arr);
            sort.handle();
            Arrays.sort(arr);
            Assert.assertArrayEquals(sort.getArray(), arr);
        }
    }

    @Test
    public void testQuickSort() {
        for (int s : size) {
            int[] arr = Main.populateArray(s);
            Sort sort = new QuickSort(arr);
            sort.handle();
            Arrays.sort(arr);
            Assert.assertArrayEquals(sort.getArray(), arr);
        }
    }
}
