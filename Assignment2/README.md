# Assignment #2 - Implement Union-find

#### In groups:
##### Implement implementations of the Union-find algorithms:  
• Quick-union  
• Weighted-union  
  
The solution accompanied with a description in a README.md file should be uploaded (pushed) to a git repository. The assignment is due Monday 22nd, be prepared to show your solution. To obtain credits, the link must be uploaded to peergrade no later than February 28th.

## Discussion

Union find is a data structure that keeps track of elements which are split into one or more components (sets). It has two primary operations:

##### Find
To find which component a particular element belongs to, find the root of that component by following the parent nodes until a self loop is reached (a node who's parent is itself)

##### Union
To unify two elements, find which are the root nodes of each component, and if the root nodes are different, make one of the root nodes be the parent of the other.[1]

#### Comparison of quick-union and weighted-union
![img](https://i.imgur.com/U2dPyMu.png)[2]

## Description of solution

For all unions we implemented the [IUnionFind](https://github.com/Hold-Krykke-BA/MAT-AL/blob/main/Assignment2/src/solution/IUnionFind.java) interface. This was used in all implementations.

#### [Quick Union](https://github.com/Hold-Krykke-BA/MAT-AL/blob/main/Assignment2/src/solution/QuickUnion.java)

> *To implement find(), we start at the given site, follow its link to another site, follow that sites link to yet another site, and so forth, following links until reaching a root, a site that has a link to itself.  
Two sites are in the same component if and only if this process leads them to the same root.  
To validate this process, we need union(p, q) to maintain this invariant, which is easily arranged: we follow links to find the roots associated with p and q, then
rename one of the components by linking one of these roots to the other; hence the name quick-union.*[2]

Following the example in the book, we have an int array `id` to hold the components and an int `count` for tracking no. of components.  
The constructor takes an int `n` to initialize the abovementioned values.  
For the `findRoot(int p)` method, we start at `p` and loop through the links until `p` matches its link (we found root).  
For the `union(int p, int q)` method we first check if the root of `p` and `q` are the same - if so, they are already in the same component. If not, we set the root of `p` to the root of `q` as to unite them. Finally we decrement `count` as two components now became one.  
Method `count()` simply returns the count.

As a small digression from the solution, for the `findRoot(int p)` method Camilla came up with the following walkthrough:
![img2](https://cdn.discordapp.com/attachments/786207354797555732/812761370835681307/unknown.png)  
```java  
//given union(1,7)
//loop 1
  while (p != id[p]) { // p = 1, id[p] = 7
    p = id[p]; // p sættes til 7 
    }
//loop 2
  while (p != id[p]) { // p = 7, id[p] = 8
    p = id[p]; // p sættes til 8 
    }
//loop 3
  while (p != id[p]) { // p = 8, id[p] = 9
    p = id[p]; // p sættes til 9 
    }
//loop 4
  while (p != id[p]) { // p = 9, id[p] = 9
    //loop breaker, vi har fundet root
    }
```
It's important to understand how `id[p]` changes with `p` as its the reference to the array index.

#### [Weighted Union](https://github.com/Hold-Krykke-BA/MAT-AL/blob/main/Assignment2/src/solution/WeightedUnion.java)

> *Rather than arbitrarily connecting the second tree to the first for union(), we keep track of the size of each tree and always connect the smaller tree to the larger. This change requires slightly more code and another array to hold the node counts, but it leads to substantial improvements in efficiency.*[2]  

Complimenting the book and the Quick Union, much of the code is the same. We also add an int array `size` to keep track of the component sizes based on the root.  
The constructor still takes an int `n` which is used to initialize the now three variables.  
The methods `findRoot(int p)` and `count()` stay the same, but the real change lies in `union(int p, int q)`:  
Using the `size` array we check for the smaller one and unite it with the larger one and at the same time we update the `size` array.  

We add the smaller to the larger one due to the reasons presented in the book, in particular in the pargraph "Weighted quick-union analysis." (pg. 227):
> *These tree structures look complex, but they have the simple property that the height of a tree of 2^n nodes is n. Furthermore, when we merge two trees of 2n nodes, we get a tree of 2^n+1 nodes, and we increase the height of the tree to n+1. This observation generalizes to provide a proof that the weighted algorithm can guarantee logarithmic performance.*  

And the followup on page 229-232 (Proposition H, it's proof, it's corollary and the corollaries proof ending in the _Optimal Algorithms_ and _Amortized cost plots_ paragraphs):  
> (...) *When we combine a tree of size i with a tree of size j with i ≤ j and i+j=k, we increase the depth of each node in the smaller set by 1, but they are now in a tree of size i+j=k, so the property is preserved because 1+ lg i = lg(i+i) ≤ lg(i+j)=lg k.*

#### (Extra) [Weighted Union with Path Compression](https://github.com/Hold-Krykke-BA/MAT-AL/blob/main/Assignment2/src/solution/WeightedUnionPC.java)
Additionally, (as an extra) we added a version of the Weighted Union with Path Compression as discussed in the book. This can be found in `WeightedUnionPC.java` with its own `Main` method. The notable changes are in the [findRoot()](https://github.com/Hold-Krykke-BA/MAT-AL/blob/main/Assignment2/src/solution/WeightedUnionPC.java#L61) method.
In the book it is discussed this way on pg. 231:  
> *To implement path compression, we just add another loop to find() that sets the id[] entry corresponding to each node encountered along the way to link directly to the root. The net result is to flatten the trees almost completely, approximating the ideal achieved by the quick-find algorithm.*  

And the booksite holds a [solution](https://algs4.cs.princeton.edu/15uf/WeightedQuickUnionPathCompressionUF.java.html) as well.

### Results
We manually tested the `union()` (and therefore `find()`) as well as the `connected()` methods in the [Main](https://github.com/Hold-Krykke-BA/MAT-AL/blob/main/Assignment2/src/solution/Main.java) class.

For timings we used the [data files](https://github.com/Hold-Krykke-BA/MAT-AL/tree/main/Assignment2/src/data) provided by the booksite.[3]  
The  files (pre-union) consist of relatively 11, 900 and 2.000.000 connections. After the union these numbers are 2, 3 and 6. (Algorithms pg. 221, pg. 227)  

In the book the execution time is measured using the [Stopwatch class](https://algs4.cs.princeton.edu/14analysis/Stopwatch.java.html), which we also did. The result is of course dependant on the machine the program is run on.

Our timings can be found in [Timings.java](https://github.com/Hold-Krykke-BA/MAT-AL/blob/main/Assignment2/src/solution/Timings.java) and the stopwatch implementation can be found in [Stopwatch.java](https://github.com/Hold-Krykke-BA/MAT-AL/blob/main/Assignment2/src/utils/Stopwatch.java).

#### Timings Quick Union
Timings of the three data files using `QuickUnion.java`.

| User Name | Quick Union `tinyUF.txt` | Quick Union `mediumUF.txt` | Quick Union `largeUF.txt` |
|-----------|--------------------------|----------------------------|---------------------------|
|   Asger   |           NULL           |            NULL            |            NULL           |
|  Camilla  |           1.0ms          |            10.0ms          |            :(             |
|    Rúni   |           18ms           |            66ms            |            **Crash**           |

#### Timings Weighted Union
Timings of the three data files using `WeightedUnion.java`.  

| User Name | Weighted Union `tinyUF.txt` | Weighted Union `mediumUF.txt` | Weighted Union `largeUF.txt` |
|-----------|--------------------------|----------------------------|---------------------------|
|   Asger   |           NULL           |            NULL            |            NULL           |
|  Camilla  |           1.0ms          |            10.0ms          |            2208.8ms       |
|    Rúni   |           1ms            |            25ms            |            3589ms         |

#### (Extra) Timings Weighted Union with Path Comression
Timings of the three data files using `WeightedUnionPC.java`.

| User Name | Weighted Union W/ PC `tinyUF.txt` | Weighted Union W/ PC `mediumUF.txt` | Weighted Union W/ PC `largeUF.txt` |
|-----------|-----------------------|-------------------------|------------------------|
|   Asger   |          NULL         |           NULL          |          NULL          |
|  Camilla  |           1.0ms       |            10.0ms       |          2200.0ms      |
|    Rúni   |          2ms          |           22ms          |          3196ms        |

## References
[1] [5-part walkthrough by WilliamFiset](https://www.youtube.com/watch?v=ibjEGG7ylHk)  
[2] Algorithms ch. 1.5.  
[3] [Booksite](https://algs4.cs.princeton.edu/15uf/)  
