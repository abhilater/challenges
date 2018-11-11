# Set theory

## Concept

#### Definition
A set is nothing more than an unordered collection of elements with absolutely no duplicates.

#### Operations
The two most important operations that are performed on sets are **intersections** and 
**unions**.
Two operations that turn up quite a bit in computer science: **set differences** and **relative complements**

<img src="https://cdn-images-1.medium.com/max/1200/1*8FySrL8_5SD6OvZmZVvU9Q.jpeg" alt="Set operations" width="400" height="500"/>

**Note** Relative complements are basically the opposite of set differences, `Y ∖ X`, which is actually results in the exact same returned set as `Y— X`.

**Symmetric difference** of our two sets, which is also sometimes referred to as the **disjunctive union**. The symmetric difference yields all of the elements that exist within either of the two sets, but do not exist at the intersection `(X ∩ Y)` of them. 

<img src="https://cdn-images-1.medium.com/max/1600/1*N3Z94nCNu8IHsFenIAELJw.jpeg" alt="Set operations" width="400" height="500"/>

Finding the symmetric difference is the same as finding the union of relative complements of set X and of set Y. We could write that out as: `X △ Y= (X ∖ Y) ∪ (Y ∖ X)` .

<img src="https://cdn-images-1.medium.com/max/1200/1*tv7QU64uprYlACDS_JBNDg.jpeg" alt="Set operations" width="400" height="500"/>

How does that even happen? Well, as it turns out, many sets are actually implemented by hash tables under the hood! 