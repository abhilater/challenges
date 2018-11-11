# Sorting Algorithms

## Concept

### Classification
![](https://cdn-images-1.medium.com/max/1600/1*gyFGnj6fz08wvonmRf3cIg.jpeg)

![](https://cdn-images-1.medium.com/max/1200/1*eX6Ts3XN9myfT1IXewgc4A.jpeg)

![](https://cdn-images-1.medium.com/max/1200/1*lOOXCrfZft2vu_jbfQNuvw.jpeg)

![](https://cdn-images-1.medium.com/max/1200/1*rUhxtHDRPntdHSZ7bYMBig.jpeg)

![](https://cdn-images-1.medium.com/max/1600/1*zlj1h6uHJ9uLlQtLbc4ZEw.jpeg)

![](https://cdn-images-1.medium.com/max/1600/1*OWZF2CMe2KV1grxNwcdZ9Q.jpeg)

### Algorithms

#### Selection Sort
![](https://cdn-images-1.medium.com/max/1600/1*O6OmnV8MZ7Pdyvt1-xBTxw.jpeg)
![](https://cdn-images-1.medium.com/max/1200/1*PCWPy55bEEZon1uNXunELw.jpeg)
![](https://cdn-images-1.medium.com/max/1600/1*MJ1hJLG58QS8REhXkuo_Hg.jpeg)

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

#### Bubble sort
![](https://cdn-images-1.medium.com/max/1600/1*gxRwophEo5u22AaSgt8JXg.jpeg)
![](https://cdn-images-1.medium.com/max/1200/1*0G-HWCiByHVPedrKXwS8iQ.jpeg)

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

#### Insertion sort
![](https://cdn-images-1.medium.com/max/1600/1*_W4xVv1FM3wEDZg16kvb1w.jpeg)
![](https://cdn-images-1.medium.com/max/1200/1*NDDPPmfZx-l4dzHZw-bTmg.jpeg)

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
**Note:** The best case running time of running an insertion sort algorithm on a nearly-sorted list ends up being linear — or, O(n) — since far fewer comparisons need to be made by the inner loop.
![](https://cdn-images-1.medium.com/max/1600/1*7fLrgRmyYRkEKQ1C4YRKqw.jpeg)

#### Merge sort
![](https://cdn-images-1.medium.com/max/1600/1*T4lE_CveG7rAkEziwKtpAw.jpeg)

**The basic idea behind merge sort is this: it tends to be a lot easier to sort two smaller, sorted lists rather than sorting a single large, unsorted one.**

![](https://cdn-images-1.medium.com/max/1200/1*ZFpPwH6_ssRu5p8tM9T-vQ.jpeg)
![](https://cdn-images-1.medium.com/max/1600/1*p6pvuQ0mKCYkx3ZXv6ufgw.jpeg)
![](https://cdn-images-1.medium.com/max/1600/1*V1QaE66T3SgIIO-jv0-fHw.jpeg)

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
