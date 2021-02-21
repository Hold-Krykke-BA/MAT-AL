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
To unify two elements, find which are the root nodes of each component, and if the root nodes are different, make one of the root nodes be the parent of the other. [1]

#### Comparison
![img](https://i.imgur.com/U2dPyMu.png)[2]

## Description of solution

### [Quick Union](https://github.com/Hold-Krykke-BA/MAT-AL/blob/main/Assignment2/src/solution/QuickUnion.java)
// todo describe
### [Weighted Union](https://github.com/Hold-Krykke-BA/MAT-AL/blob/main/Assignment2/src/solution/WeightedUnion.java)
// todo describe

## Timings

### Timings Quick Union
//Todo  
### Timings Weighted Union
//Todo


## References
[1] [5-part walkthrough by WilliamFiset](https://www.youtube.com/watch?v=ibjEGG7ylHk)  
[2] Algorithms ch. 1.5.
[Booksite](https://algs4.cs.princeton.edu/15uf/)  
