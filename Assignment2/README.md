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

#### Comparison
![img](https://i.imgur.com/U2dPyMu.png)[2]

## Description of solution

#### [Quick Union](https://github.com/Hold-Krykke-BA/MAT-AL/blob/main/Assignment2/src/solution/QuickUnion.java)
```diff
- todo describe
``` 
*To implement find(), we start at the given site, follow its link to another site, follow that sites link to yet another site, and so forth, following links until reaching a root, a site that has a link to itself.  
Two sites are in the same component if and only if this process leads them to the same root.  
To validate this process, we need union(p, q) to maintain this invariant, which is easily arranged: we follow links to find the roots associated with p and q, then
rename one of the components by linking one of these roots to the other; hence the name quick-union.*[2]

#### [Weighted Union](https://github.com/Hold-Krykke-BA/MAT-AL/blob/main/Assignment2/src/solution/WeightedUnion.java)
```diff
- todo describe
```
*Rather than arbitrarily connecting the second tree to the first for union(), we keep track of the size of each tree and always connect the smaller tree to the larger. This change requires slightly more code and another array to hold the node counts, but it leads to substantial improvements in efficiency.*[2]

### Results
We manually tested the `union()` (and therefore `find()`) as well as the `connected()` methods in the [Main](https://github.com/Hold-Krykke-BA/MAT-AL/blob/main/Assignment2/src/solution/Main.java) class.

In the book the execution time is measured using the [Stopwatch class](https://algs4.cs.princeton.edu/14analysis/Stopwatch.java.html), which we also did. The result is of course dependant on the machine the program is run on.

#### Timings Quick Union
```diff
- todo / find time measurement method
```
#### Timings Weighted Union
```diff
- todo / find time measurement method
```

## References
[1] [5-part walkthrough by WilliamFiset](https://www.youtube.com/watch?v=ibjEGG7ylHk)  
[2] Algorithms ch. 1.5.  
[Booksite](https://algs4.cs.princeton.edu/15uf/)  
