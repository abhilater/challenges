# Sorting Algorithms

# Classification

![](https://cdn-images-1.medium.com/max/1600/1*gyFGnj6fz08wvonmRf3cIg.jpeg)<br><br>

![](https://cdn-images-1.medium.com/max/1200/1*eX6Ts3XN9myfT1IXewgc4A.jpeg)<br><br>

![](https://cdn-images-1.medium.com/max/1200/1*lOOXCrfZft2vu_jbfQNuvw.jpeg)<br><br>

![](https://cdn-images-1.medium.com/max/1200/1*rUhxtHDRPntdHSZ7bYMBig.jpeg)<br><br>

![](https://cdn-images-1.medium.com/max/1600/1*zlj1h6uHJ9uLlQtLbc4ZEw.jpeg)<br><br>

![](https://cdn-images-1.medium.com/max/1600/1*OWZF2CMe2KV1grxNwcdZ9Q.jpeg)<br><br>


# Selection Sort

![](https://cdn-images-1.medium.com/max/1600/1*O6OmnV8MZ7Pdyvt1-xBTxw.jpeg)<br><br>

![](https://cdn-images-1.medium.com/max/1200/1*PCWPy55bEEZon1uNXunELw.jpeg)<br><br>

![](https://cdn-images-1.medium.com/max/1600/1*MJ1hJLG58QS8REhXkuo_Hg.jpeg)<br><br>

```java
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
```

# Bubble sort

![](https://cdn-images-1.medium.com/max/1600/1*gxRwophEo5u22AaSgt8JXg.jpeg)<br><br>

![](https://cdn-images-1.medium.com/max/1200/1*0G-HWCiByHVPedrKXwS8iQ.jpeg)<br><br>

```java
static void bubbleSort(Integer[] array) {
    for(int j = array.length - 1; j > 0; j--){
        for(int i = 0 ; i < j; i++){
            if(array[i] > array[i+1]){
                swap(array, i, i+1);
            }
        }
    }
}
```

# Insertion sort

![](https://cdn-images-1.medium.com/max/1600/1*_W4xVv1FM3wEDZg16kvb1w.jpeg)<br><br>

![](https://cdn-images-1.medium.com/max/1200/1*NDDPPmfZx-l4dzHZw-bTmg.jpeg)<br><br>

```java
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
```

> ## The best case running time of running an insertion sort algorithm on a nearly-sorted 
list ends up being linear — or, O(n) — since far fewer comparisons need to be made by the inner loop.

![](https://cdn-images-1.medium.com/max/1600/1*7fLrgRmyYRkEKQ1C4YRKqw.jpeg)<br><br>

# Merge sort

![](https://cdn-images-1.medium.com/max/1600/1*T4lE_CveG7rAkEziwKtpAw.jpeg)<br><br>

> ## The basic idea behind merge sort is this: it tends to be a lot easier to sort two smaller, 
sorted lists rather than sorting a single large, unsorted one.

![](https://cdn-images-1.medium.com/max/1200/1*ZFpPwH6_ssRu5p8tM9T-vQ.jpeg)<br><br>

![](https://cdn-images-1.medium.com/max/1600/1*p6pvuQ0mKCYkx3ZXv6ufgw.jpeg)<br><br>

![](https://cdn-images-1.medium.com/max/1600/1*V1QaE66T3SgIIO-jv0-fHw.jpeg)<br><br>

```java
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

static void merge(Integer[] la, 
                  Integer[] ra, 
                  Integer[] array) {
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
```
![](https://cdn-images-1.medium.com/max/1600/1*rC_8BDfA-DzTsqMd4LSDhw.jpeg)<br><br>

![](https://cdn-images-1.medium.com/max/1200/1*lc4AdXu_5iTxJGNqphsK1Q.jpeg)<br><br>

> ## Standard merge sort algorithm requires a temporary array structure in order to sort and append 
elements. In other words, it requires a constant, or O(n), amount of space — the memory needed 
for the temporary buffer array. Merge sort needs O(n) amount of memory in order to copy over 
elements as it sorts. This is probably the greatest drawback of the merge sort algorithm: 
it is an out-of-place sorting algorithm, that requires additional memory as its dataset grows.

![](https://cdn-images-1.medium.com/max/1600/1*gBcFx-WSaAaMdA0sIsm0wA.jpeg)<br><br>

> ## Because merge sort is often implemented as an external sorting algorithm, it can do 
the work of sorting outside of main memory, and then later can pull the sorted data back into the internal, main memory.


> ## Both Java and Python, for example, implement **Timsort**, which is a hybrid of insertion sort and 
merge sort, under the hood of their sorting methods.
It knows to use insertion sort for smaller arrays, and merge sort for larger ones.

# Quick Sort
![](https://cdn-images-1.medium.com/max/1600/1*naIVyW99FsqfTZhw06YJ0g.jpeg)<br><br>

![](https://cdn-images-1.medium.com/max/1600/1*sNTntI4oR51kdp9-CQEqxg.jpeg)<br><br>

![](https://cdn-images-1.medium.com/max/1200/1*rjpGqzlhNO8SdqgQYAp76w.jpeg)<br><br>

![](https://cdn-images-1.medium.com/max/1200/1*md0dT0BAlkRiWlWnbH61GQ.jpeg)<br><br>

![](https://cdn-images-1.medium.com/max/1200/1*d5Ampu8dRE_N0X3MLcGBOw.jpeg)<br><br>

> ## One thought we might have here is that quicksort just creates a whole new array and copies over 
the elements in the correct order — right? Well, not exactly. One of the many reasons that quicksort 
is a preferred algorithm is because it doesn’t take up a ton of extra space as it sorts! 
This means that it doesn’t have the luxury of being able to create a duplicated array, 
because that would take up a lot of space and memory.

![](https://cdn-images-1.medium.com/max/1200/1*VRpkrRX_WdPnH3duP0Ak_A.jpeg)<br><br>

![](https://cdn-images-1.medium.com/max/1200/1*sxpPWeeEHFmFh9dL3C0J8Q.jpeg)<br><br>

> ## Choosing the pivot

![](https://cdn-images-1.medium.com/max/1200/1*AuOVk7USUwVhrbmejkg5sQ.jpeg)<br><br>

![](https://cdn-images-1.medium.com/max/1600/1*sYvLxsc-TZTnbA9oPoPSyw.jpeg)<br><br>

```java
static void quickSort(Integer[] array, int leftIdx, int rightIdx){
    if(array.length < 2) return;
    int pivot = partition(array, leftIdx, rightIdx);
    
    // If the left reference hasn't been incremented to
    // reach the pivot yet, we want to keep comparing it.
    if(leftIdx < pivot - 1) quickSort(array, leftIdx, pivot - 1);
    
    // If the right reference hasn't reached the
    // pivotIndex yet, we need to keep comparing it.
    if(rightIdx > pivot) quickSort(array, pivot, rightIdx);
}

static int partition(Integer[] array, int leftIdx, int rightIdx){
    int pivot = array[(leftIdx + rightIdx)/2];
    
    // Once the left reference is greater than the right reference,
    // we have finished sorting this set of items, and we can return.
    while(leftIdx <= rightIdx){
        while(array[leftIdx] < pivot) leftIdx++;
        while(array[rightIdx] > pivot) rightIdx--;
        
        // If the left pointer is larger than the pivot, and the right
        // pointer is not bigger than the pivot, swap the two elements.
        if(leftIdx <= rightIdx){
            swap(array, leftIdx, rightIdx);
            leftIdx++; rightIdx--;
        }
    }
    return leftIdx;
}
```

> ## Quicksort has one major difference with merge sort, and this ends up being a 
defining point between these otherwise super-similar algorithms. This is the 
fact that quicksort is an unstable algorithm. Stability ends up being what causes 
people to choose merge sort over quicksort, and it’s the one area where merge sort 
appears as the obvious winner.

![](https://cdn-images-1.medium.com/max/1200/1*BjEafvcnl_p3mi1sOBcsgw.jpeg)<br><br>