package sorting;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

/**
 * Created by abhishek on 11/11/18.
 */
@RunWith(JUnitQuickcheck.class)
public class Sorting {

    static void selectionSort(Integer[] array) {
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

    static void bubbleSort(Integer[] array) {
        for(int j = array.length - 1; j > 0; j--){
            for(int i = 0 ; i < j; i++){
                if(array[i] > array[i+1]){
                    swap(array, i, i+1);
                }
            }
        }
    }

    static void insertionSort(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            int currentUnsortedItem = array[i];
            int j = i;
            for (; j > 0 && currentUnsortedItem < array[j - 1];
                 j--) {
                array[j] = array[j - 1]; // shifting right
            }
            array[j] = currentUnsortedItem;
        }
    }

    static void mergeSort(Integer[] array){
        if(array.length <= 1) return;

        int n = array.length / 2;
        List<Integer> l = Arrays.asList(array);
        Integer[] leftArray = l.subList(0, n)
                .toArray(new Integer[n]);
        Integer[] rightArray = l.subList(n, l.size())
                .toArray(new Integer[l.size() - n]);
        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(leftArray, rightArray, array);
    }

    static void merge(Integer[] la, Integer[] ra, Integer[] array) {
        int index = 0, l = 0, r = 0;
        while (l < la.length && r < ra.length) {
            if (la[l] < ra[r]) {
                array[index++] = la[l++];
            } else {
                array[index++] = ra[r++];
            }
        }
        while (l < la.length) {
            array[index++] = la[l++];
        }
        while (r < ra.length) {
            array[index++] = ra[r++];
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
        Assert.assertTrue(isArraySorted(array, array.length));
    }

    @Property
    public void testBubbleSort(Integer[] array) {
        bubbleSort(array);
        Assert.assertTrue(isArraySorted(array, array.length));
    }

    @Property
    public void testInsertionSort(Integer[] array) {
        insertionSort(array);
        Assert.assertTrue(isArraySorted(array, array.length));
    }

    @Property
    public void testMergeSort(Integer[] array) {
        mergeSort(array);
        Assert.assertTrue(isArraySorted(array, array.length));
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{};
        Integer[] b = {1};
        Integer[] c = {1, 2, 3};
        Integer[] d = {3, 2, 1};
        Integer[] e = {5, 3, 6, 5, 0, -8, 99, 1};
        Integer[] f = {0, 5, 0, -5};
        //mergeSort(a);
        //mergeSort(b);
        mergeSort(c);
        //mergeSort(d);
        //mergeSort(e);
        //mergeSort(f);
        //System.out.println(Arrays.asList(a));
        //System.out.println(Arrays.asList(b));
        System.out.println(Arrays.asList(c));
        //System.out.println(Arrays.asList(d));
        //System.out.println(Arrays.asList(e));
        //System.out.println(Arrays.asList(f));
    }
}
