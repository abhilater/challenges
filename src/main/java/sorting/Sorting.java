package sorting;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.Arrays;

/**
 * Created by abhishek on 11/11/18.
 */
@RunWith(JUnitQuickcheck.class)
public class Sorting {

    static void selectionSort(Integer[] array) {
        if (array.length < 2) return;

        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIdx = j;
                }
            }
            swap(array, i, minIdx);
        }
    }

    private static void swap(Integer[] array, int idx1, int idx2) {
        int t = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = t;
    }

    boolean isArraySorted(Integer[] array, int n) {
        if (n == 1 || n == 0) return true;
        if (array[n - 1] < array[n - 2]) return false;
        return isArraySorted(array, n - 1);
    }

    @Property
    public void testSelectionSort(Integer[] array) {
        selectionSort(array);
        System.out.println("Array: " + Arrays.asList(array));
        Assert.assertTrue(isArraySorted(array, array.length));
    }

    public static void main(String[] args) {
//        Integer[] a = new Integer[]{};
//        Integer[] b = {1};
//        Integer[] c = {1, 2, 3};
//        Integer[] d = {3, 2, 1};
//        Integer[] e = {5, 3, 6, 5, 0, -8, 99, 1};
//        Integer[] f = {0, 5, 0, -5};
//        selectionSort(a);
//        selectionSort(b);
//        selectionSort(c);
//        selectionSort(d);
//        selectionSort(e);
//        selectionSort(f);
//        System.out.println(Arrays.asList(a));
//        System.out.println(Arrays.asList(b));
//        System.out.println(Arrays.asList(c));
//        System.out.println(Arrays.asList(d));
//        System.out.println(Arrays.asList(e));
//        System.out.println(Arrays.asList(f));
    }
}
