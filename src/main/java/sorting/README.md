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
```