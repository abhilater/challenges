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

```json
function countingSort(array, minimumValue, maximumValue) {
  var z = 0;
  var count = [];

  for (i = minimumValue; i <= maximumValue; i++) {
    count[i] = 0;
  }

  // Build up our index count array.
  for (i=0; i < array.length; i++) {
    count[array[i]]++;
  }

  // Modify array and move elements into their sorted location.
  for (i = minimumValue; i <= maximumValue; i++) {
    while (count[i]-- > 0) {
      console.log('item at index ' + z + ' is: ', array[z]);
      array[z++] = i;
      console.log('moving item ' + i + ' to correct location');
    }
  }
  return array;
}
```

