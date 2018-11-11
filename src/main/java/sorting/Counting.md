# Counting Sort

> ### It’s nearly impossible to do better than linearithmic runtime, or O(n log n) in Big O Notation. The keyword here is, of course, nearly. Because, every once in awhile, we can do better

![](https://cdn-images-1.medium.com/max/600/1*aMsSi7khOpDLX0-ysf3jRg.jpeg)<br><br>
The algorithm leverages the fact that it knows beforehand the range of elements to be 
sorted, and the fact that all the elements are integers, and builds up a “count” array, 
which it uses to tally up how many numbers appear in the unsorted collection. It then 
uses some math and a partial hashing function to map the elements to keys in the 
duplicated “count” array.


![](https://cdn-images-1.medium.com/max/600/1*gkUSWvuDICvRhw005CXtiA.jpeg)<br><br>
![](https://cdn-images-1.medium.com/max/600/1*BwE_Lm7lqkD1LTu08Ggsog.jpeg)<br><br>
![](https://cdn-images-1.medium.com/max/600/1*gDDj0iHNPUTsJrGnnUmZQw.jpeg)<br><br>
![](https://cdn-images-1.medium.com/max/600/1*JDUtBNVSdcnPo13ZVjLJ-A.jpeg)<br><br>
![](https://cdn-images-1.medium.com/max/600/1*hD9c_JW2GE7dw_BhO_RBZw.jpeg)<br><br>

```java
static void countingSort(Integer[] array, int min, int max) {
    int z = 0;
    Integer[] count = new Integer[max+1];
    for (int i = min; i <= max; i++) count[i] = 0;

    for (int i = 0; i < array.length; i++) {
        count[array[i]]++;
    }
    // Modify array and move elements into their sorted location.
    for(int i = min; i <= max; i++){
        while(count[i]-- > 0){
            array[z++] = i;
        }
    }
}
```

![](https://cdn-images-1.medium.com/max/600/1*liCFxCuwWgJYh3ALb2I2og.jpeg)
This can be pretty terrible if we want to sort just 5 or 10 elements, but we have to 
create a massive array in order to do that! In such cases, counting sort will be **Very Bad News™**.

Finally, counting sort is unlike other algorithms we’ve looked at in that it is a **non-comparison** 
algorithm. And since we’ve learned that it is iterative in its implementation, we know that it is non-recursive.

