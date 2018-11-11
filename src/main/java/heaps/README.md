# Heaps

![](https://cdn-images-1.medium.com/max/1600/1*xxfTylXjspbgcZwfeWSx3A.jpeg)


![](https://cdn-images-1.medium.com/max/1200/1*YsG9jcE4XiDMj-E_VhX03A.jpeg)

![](https://cdn-images-1.medium.com/max/1200/1*0hd7XsIV3D092XKKTZg6Pg.jpeg)

![](https://cdn-images-1.medium.com/max/1200/1*BP0o8V34jxYE4Dn8byJqow.jpeg)

![](https://cdn-images-1.medium.com/max/1200/1*tq8hBeMDKPTvhfp9R_J45g.jpeg)

![](https://cdn-images-1.medium.com/max/1600/1*6bCR-NtCtEh9IfRHTzDn_Q.jpeg)

![](https://cdn-images-1.medium.com/max/1200/1*cN_AR3fwVNRIf-pYIAYqYw.jpeg)

![](https://cdn-images-1.medium.com/max/1200/1*5mhwGo-y-Zw3X2a2l446Qw.jpeg)

> ## Heaps are often implemented as arrays because they are super efficient ways of representing priority queues.

![](https://cdn-images-1.medium.com/max/1600/1*4rG1Dxt18Y5p0FefQDf-1A.jpeg)

# Heap Sort

![](https://cdn-images-1.medium.com/max/1600/1*gL7afN4ItGy5oE409q0DVg.jpeg)
and sequentially sort elements by selecting the root node of a heap, and adding it to the end of the array.

![](https://cdn-images-1.medium.com/max/1200/1*5TQSbehEDfyEN5WtlIQzIQ.jpeg)

![](https://cdn-images-1.medium.com/max/1200/1*KBafG8K6xaO7cY8O30XHdQ.jpeg)
![](https://cdn-images-1.medium.com/max/1600/1*Km1jk3hsH2cc751KKY41EA.jpeg)
![](https://cdn-images-1.medium.com/max/1600/1*RUt3itnTRK00-q3mek8F6g.jpeg)

> ## You’ll remember that heap sort has two important parts to it: buildMaxHeap and heapify. 
We can see them in action in the version of heapSort below.

```java
static void heapSort(Integer[] array) {
    buildMaxHeap(array);
    int lastElement = array.length - 1;

    while (lastElement > 0) {
        swap(array, 0, lastElement);
        maxHeapify(array, 0, lastElement);
        lastElement--;
    }
}

static void buildMaxHeap(Integer[] array) {
    // heapify only non-leaf nodes
    int i = (array.length - 1) / 2;
    while (i >= 0) {
        maxHeapify(array, i, array.length);
        i--;
    }
}

static void maxHeapify(Integer[] array, int i, int n) {
    int maxIdx = i;
    int l = 2 * i + 1; // left = 2*i + 1
    int r = 2 * i + 2; // right = 2*i + 2
    if (l < n && array[l] > array[maxIdx]) maxIdx = l;
    if (r < n && array[r] > array[maxIdx]) maxIdx = r;
    // If largest is not root
    if (maxIdx != i) {
        swap(array, i, maxIdx);
        maxHeapify(array, maxIdx, n);
    }
}
```

![](https://cdn-images-1.medium.com/max/1600/1*-oV9Rwk_47MwW6GstO1JPA.jpeg)

![](https://cdn-images-1.medium.com/max/1600/1*Fmz1Fapal4GZePsoBWUx1Q.jpeg)
