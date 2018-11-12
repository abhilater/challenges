# Graph

![](https://cdn-images-1.medium.com/max/600/1*AieKoYr68sm0GAFJUcNyDg.jpeg)

In maths graphs are represented as G = (V,E)

![](https://cdn-images-1.medium.com/max/600/1*J9U-CK1N6X7WBAnz_m04SQ.jpeg)

> ## But how do these simple ordered pairs actually look in code and in memory?

![](https://cdn-images-1.medium.com/max/600/1*7xTtxr7I1Eq510-iDmxOsQ.jpeg)

![](https://cdn-images-1.medium.com/max/600/1*bllOr7NiKf4YbNtqg1cEqA.jpeg)

![](https://cdn-images-1.medium.com/max/600/1*awItc9GQX4siLgQAlTQM7A.jpeg)

When both edge lists and adjacency matrices seem to fail us, what are we to do? Why, 
combine them both together, of course! And that’s exactly what an **adjacency list** is — 
a hybrid between an edge list and an adjacency matrix

![](https://cdn-images-1.medium.com/max/600/1*XPH-Z7fBfBT1mEcN03FOJA.jpeg)

![](https://cdn-images-1.medium.com/max/600/1*ZSsASthwtg_2iQHsbSkXSw.jpeg)

![](https://cdn-images-1.medium.com/max/600/1*OuGzFyh22HxjzqLUyNsHDA.jpeg)

![](https://cdn-images-1.medium.com/max/600/1*wBqdISORWCjHLqf9qZ_N-A.jpeg)

# Traversal & Search

![](https://cdn-images-1.medium.com/max/600/1*_v6x7az3pWGaBWYo-fYMwg.jpeg)

```
The backbone of a breadth-first graph traversal consists of these basic steps:
  
1. Add a node/vertex from the graph to a queue of nodes to be “visited”.
2. Visit the topmost node in the queue, and mark it as such.
3. If that node has any neighbors, check to see if they have been “visited” or not.
4. Add any neighboring nodes that still need to be “visited” to the queue.
5. Remove the node we’ve visited from the queue.
```

![](https://cdn-images-1.medium.com/max/600/1*cbf3KkVnodOnJep6-BzE_g.jpeg)

The BFS graph traversal algorithm is a popular search solution, and is particularly handy for quickly determining the shortest path between two locations in a graph. However, what’s even more interesting to me is the strange, and somewhat sad origin of this search algorithm.

![](https://cdn-images-1.medium.com/max/600/1*ri9EgM7xLmrZmywgwt96pQ.jpeg)

![](https://cdn-images-1.medium.com/max/600/1*cskJKPVMALaDnD2WMyJENA.jpeg)

![](https://cdn-images-1.medium.com/max/600/1*rtE7sILnQD0kMkIgvO3I1g.jpeg)
![](https://cdn-images-1.medium.com/max/600/1*ku4di0nVGwOpRMugZImJ3g.jpeg)
![](https://cdn-images-1.medium.com/max/600/1*tDeTb8HZwxr6Ot_0ThGygw.jpeg)
![](https://cdn-images-1.medium.com/max/600/1*D-cseblYreOkyXg5-DnEFg.jpeg)