# Assignment 3 - Sorting Shakespeare

This is the first of five mini projects - mandatory assignments.

#### In groups:

We want Shakespeares complete works, sorted by word. Meaning that “to be or not to be, that is the question” would be
sorted as: “be be is not or question that the to to”. You can find the complete
works [here](https://github.com/datsoftlyngby/soft2020spring-alg/tree/master/data). You shall in groups create a
program, that can

* read any textfile (as the above) into an array or List2. The content should be sanitized:
    * All words should be lower case
    * No punktuations - strip commas, full stops, etc.
* sort the array using different sorting algorithms:
    * Selection Sort
    * Insertion Sort
    * Heap Sort
    * Merge Sort
    * Sorting using a Trie
* be extended with other sorting algorithms in the future.
* messure and log the time used for each algorithm as a function of the file size in words.  
  The solution accompanied with a description in a README.md file should be uploaded (pushed) to a git repository.

## Discussion
#### Big O notation chart:  

![image](https://user-images.githubusercontent.com/35559774/109824290-fa0b7600-7c38-11eb-9d32-478c9fa2011f.png)

   ```diff
  - add details (if any)
  ```

### Selection Sort
![image](https://user-images.githubusercontent.com/35559774/109822906-b5330f80-7c37-11eb-9ef5-fc6a914534ea.png)

[Selection sort in 3 minutes](https://www.youtube.com/watch?v=g-PGLbMth_g) by Michael Sambol on Youtube.    
[Sorts 2 Selection Sort](https://www.youtube.com/watch?v=fgYlVyrt1vE) by RobEdwards on Youtube.

Details about implementation of Selection Sort can be found here:
* [Geeks for Geeks Implementation](https://www.geeksforgeeks.org/selection-sort/)

#### Explanation
The Selection Sort algorithm sorts an array by repeatedly looping through it searching for the smallest value and then moves it to the front of the array.

```
arr[] = 64 25 12 22 11

// Find the minimum element in arr[0...4]
// and place it at beginning
11 25 12 22 64

// Find the minimum element in arr[1...4]
// and place it at beginning of arr[1...4]
11 12 25 22 64

// Find the minimum element in arr[2...4]
// and place it at beginning of arr[2...4]
11 12 22 25 64

// Find the minimum element in arr[3...4]
// and place it at beginning of arr[3...4]
11 12 22 25 64 
```

### Insertion Sort
![image](https://user-images.githubusercontent.com/35559774/109822934-bc5a1d80-7c37-11eb-863c-0227b019a457.png)

   ```diff
  - add details
  ```

[Insertion sort in 2 minutes](https://www.youtube.com/watch?v=JU767SDMDvA) by Michael Sambol on Youtube.  
[Insertion Sort Algorithm Made Simple [Sorting Algorithms]](https://www.youtube.com/watch?v=nKzEJWbkPbQ) by Programming
with Mosh on Youtube.  
[Sorts 3 Insertion Sort](https://www.youtube.com/watch?v=eTvQIbB-AuE) by RobEdwards on Youtube.

### Heap Sort
![image](https://user-images.githubusercontent.com/35559774/109822968-c4b25880-7c37-11eb-9e29-9b26d3ad76e4.png)

Details about Heap Sort can be found here:
* [Baeldung Implementation](https://www.baeldung.com/java-heap-sort)
* [Geeks For Geeks Implementation](https://www.geeksforgeeks.org/heap-sort/)
* [Good Stackoverflow explanation of the building of the heap](https://stackoverflow.com/a/52613602)
* [Geeks For Geeks heap visualization](https://www.geeksforgeeks.org/leaf-starting-point-binary-heap-data-structure/)

#### Explanation
For a max heap, a parent node is always greater than the value(s) in its child(ren).

Heap Sort Algorithm: 
* Build a heap. 
* The largest value is the root of the heap. 
  * Swap it with the last item of the heap.
  * Reduce the size of heap by 1. 
  * Heapify the root of the tree. 
* Repeat the above as long as the heap size > 1.

Visualization:
![](https://www.codesdope.com/staticroot/images/algorithm/heapsort2.gif)
```
int[] array = {4, 5, 3, 10, 1}
// index:      0, 1, 2, 3,  4

         4(0)
        /   \
     5(1)   3(2)
    /   \
 10(3)    1(4)
 
 
// Heapify on index 1:

         4(0)
        /   \
 --> 10(1)    3(2)
    /   \
5(3)    1(4)
 
 
// Heapify on index 0:

    --> 10(0)
        /  \
     5(1)  3(2)
    /   \
 4(3)    1(4)
```
    
Position of children and parents in relation to index i:

```
// Children in relation to parent at i:

           parent(i)
         /        \
        /          \
    left(2*i+1)  right(2*i+2)


// Example with values:
 
           parent(3)
          /       \
         /         \
    left(7)    right(8)
    (2*3+1)    (2*3+2)
    
    
// Parents position in relation to child is: (i-1)/2
// Example with i = 7 (left child) and i = 8 (right child):

           parent(3)
          /       \
         /         \
    left(7)    right(8)
    (7-1)/2    (7-1)/2  (integer division is rounded down)
```


[Heap sort in 4 minutes](https://www.youtube.com/watch?v=2DmK_H7IdTo) by Michael Sambol on Youtube.  
[Heaps 5 HeapSort](https://www.youtube.com/watch?v=LbB357_RwlY) by RobEdwards on Youtube.

### Merge Sort
![image](https://user-images.githubusercontent.com/35559774/109822871-ab111100-7c37-11eb-8cb5-21d164e1c115.png)

<img name="img1" alt="" align="right" width="185px" src="https://i.imgur.com/EJkLtY6.png">

Details can be found in chapter 2.2 *Mergesort* (pg. 270) of Algorithms.

The chapter goes into detail of the different variations of Merge Sort:

- #### Abstract in-place merge  (pg. 270)

> *The straightforward approach to implementing merging is to design a method that merges two disjoint ordered arrays of `Comparable` objects into a third array. This strategy is easy to implement: create an output array of the requisite size and then choose successively the smallest remaining item from the two input arrays to be the next item added to the output array.*

It is important to notice how this approach creates only one *auxiliary* array, copying values from `[low..mid..high]`.  
This chapter shortly touches on the issue of using this variation on large arrays, where the cost of creating temporary
arrays gets exponentially worse.

- #### Top-down mergesort (pg. 272)
> *(...) is a recursive
mergesort implementation based on this abstract inplace
merge. It is one of the best-known examples of the
utility of the divide-and-conquer paradigm for efficient
algorithm design. ... To understand mergesort, it is worthwhile to consider
carefully the dynamics of the method calls, shown in the
trace at right. To sort `a[0..15]`, the `sort()` method calls
itself to sort `a[0..7]` then calls itself to sort `a[0..3]`
and `a[0..1]` before finally doing the first merge of `a[0]` with `a[1]` (...)*  

![](https://i.imgur.com/5KeoIs0.png)

- #### Bottom-up mergesort (pg. 277)  
> *Another way to implement mergesort is to organize the merges so that we do
all the merges of tiny subarrays on one pass, then do a second pass to merge those subarrays
in pairs, and so forth, continuing until we
do a merge that encompasses the whole array. (...)*

More details can be found on pg. 278 and the booksite.

Additionally, the chapter discusses solutions to optimize the algorithm (pg. 275):

- Using insertion sort for small subarrays:

> *Switching to insertion sort for small subarrays (length 15 or less, say) will improve the running time of a typical mergesort implementation by 10 to 15 percent.*

- Testing whether the array is already in order:

> *We can reduce the running time to be linear for arrays that are already in order by adding a test to skip the call to merge() if a[mid] is less than or equal to a[mid+1].*

- Eliminating the copy to the auxiliary (temporary) array:

> *It is possible to eliminate the time (but not the space) taken to copy to the auxiliary array used for merging. To do so, we use two invocations of the sort method: one takes its input from the given array and puts the sorted output in the auxiliary array; the other takes its input from the auxiliary array and puts the sorted output in the given array.*

As well as touches on the complexity of sorting (pg. 279 onwards) and how to chose a variant. Here's another discussion on how to chose a variant: [Stackoverflow](https://stackoverflow.com/questions/37341369/what-are-the-different-types-of-merge-sort-used-for).

[Merge sort in 3 minutes](https://www.youtube.com/watch?v=4VqmGXwpLqc) by Michael Sambol on Youtube.  
[Sorts 6 Merge Sort](https://www.youtube.com/watch?v=qdv3i6X0PiQ) by RobEdwards on Youtube.

### Sorting using a Trie

   ```diff
  - add details 
  ```

## Description of solution

#### Folder structure

- [src/solution](src/solution)  
  Holds the interfaces, the different algorithms implemented, and a Main class.

- [src/utils](src/utils)  
  Holds the utilities provided in-class.

- [src/data](src/data)  
  Holds the data file(s).

We implemented two different interfaces, [ISort](src/solution/sorts/ISort.java) as described in the book
utilizing `Comparable<T>` as well as [ISortGeneric](src/solution/sorts/ISortGeneric.java) which utilizes Java Generics
as shown in class.

The implementation and solution to the assignment can be found in [src/solution/Main.java](src/solution/Main.java). As
an example, here is the output for sorting the Shakespeare data file using Merge Sort:

```
Initiating Mergesort on an array of size 930778.
1095,953900ms spent sorting.
Comparisons: 17282216.
```

- `size` is the amount of words from the data file.
- `1095,953900ms` is the time taken calculated by the Stopwatch class.
- `Comparisons` is the amount of calls to the CountComparator.

One take away from this is the average comparisons:  
`17282216/930778 = 18,5674951492` average comparisons per word.

### Selection Sort

   ```diff
  - add details about implementation
  ```

### Insertion Sort

   ```diff
  - add details about implementation
  ```

### Heap Sort
* [Implementation is located here](https://github.com/Hold-Krykke-BA/MAT-AL/blob/main/Assignment3/src/solution/sorts/HeapSort.java)
Heap sort is implemented with a max heap and is made generic, following the interface [ISortGeneric](src/solution/sorts/ISortGeneric.java). It was tested in the main method of the program. 

`isSorted(Comparator<T> comp, T[] array)` assumes the array is sorted in ascending natural order, based on the default `Comparator`, and checks weather that is the case.
  
`sort(Comparator<T> comp, T[] array)` calls `buildHeap(array, comp)` to build the heap from the array and run the intial rounds of heapify. After this the loop swaps the root with the last node (or index) for as long as the heap is greater than 1, counting down and calling _heapify_ each loop.  
`heapify(T[] array, int i, Comparator comp)` assumes i is the largest node, then checks if this is true. If this is not the case the heap is heapified recursively until it is true. 


### Merge Sort

The implementation of Merge Sort followed the one in class, the "Top-down mergesort", as mentioned in the discussion.

- [Basic implementation without interface/generics](https://github.com/Hold-Krykke-BA/MAT-AL/commit/b9cf82e8d75e3890eaae66cfb72e4e708f328b37) (
  Verbose chat output)
- [Generics implementation with double/integer test](https://github.com/Hold-Krykke-BA/MAT-AL/commit/cd804e632ab1f0b6d9fe86607a43c7a143e8b68e) (
  Verbose chat output)
- [Clean generics implementation](https://github.com/Hold-Krykke-BA/MAT-AL/commit/c38b670987edb6250a4f31f439a337ff3f9e6f23) (**
  non**-verbose)

In [the implementation](src/solution/sorts/MergeSort.java) we tested the algorithm in its own Main method, in particular
one for Integers and one for Doubles. The implementation follows the structure of
the [ISortGeneric interface](src/solution/sorts/ISortGeneric.java):

`isSorted(Comparator<T> comp, T[] array)` assumes the array is sorted incrementally, i.e. numbers in ascending order or
words in alphabetical order - this is however based on the implementation of the `Comparator`.

`sort(T[] arr, int left, int right, Comparator<T> comp)` will first check if the array is already sorted, and if not it
will partition the array by sorting recursively: Once from `[0...mid]` and once from `[mid+1...end]`, ending in a call
to `merge()`, a method unique to MergeSort and not part of the ISortGeneric interface.

`merge(T[] arr, int left, int middle, int right, Comparator<T> comp)` starts out by creating and populating temporary
arrays, one for the left and one for the right side of the array being merged.  
Following this, we enter a while loop based on the indices of the temporary arrays, incrementing with each operation: if
the `Comparator` deems `left` to be "smaller or equal" to `right` we set *the original arrays value* to the value from
the temporary `left` array.  
If it is the other way around, we instead set the array value to the value from the `right` temporary array.

When the while loop exits we have a final check for leftover elements, in case of an uneven array. (i.e. the `right`
array is size 2, while the `left` is size 3)  
The check basically does the same as in the while loop, setting the value from the temporary array in the original
array.

### Sorting using a Trie

   ```diff
  - add details about implementation
  ```

### Future usability

This section refers to the following requirement of the assignment:
> *[the program can] be extended with other sorting algorithms in the future.*

As already mentioned above, we implemented two interfaces, one from the book which utilizes `Comparable<T>` and one
shown in-class that uses Java Generics, both of which can be found in [src/solution/sorts](src/solution/sorts/).

We went with ISortGeneric (implementing Generics over `Comparable`) as it seemed more fit for a school assignment like this - however, it is worth noting how the [Java API for Comparable](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html) mentions collections implementing `Comparable` being sortable:  
> *Lists (and arrays) of objects that implement this interface can be sorted automatically by Collections.sort (and Arrays.sort). Objects that implement this interface can be used as keys in a sorted map or as elements in a sorted set, without the need to specify a comparator.*

### Timings

This section refers to the following requirement of the assignment:
> *[the program can] messure and log the time used for each algorithm as a function of the file size in words.*

To time our program we utilized the provided [Stopwatch](src/utils/Stopwatch.java) class.

|         | Selection Sort ![equation](https://latex.codecogs.com/gif.latex?O%5Cleft%28n%5E%7B2%7D%20%5Cright%29) | Insertion Sort ![equation](https://latex.codecogs.com/gif.latex?O%5Cleft%28n%5E%7B2%7D%20%5Cright%29)| Heap Sort ![equation](https://latex.codecogs.com/gif.latex?O%5Cleft%28n%5Clog%5Cleft%20%28%20n%20%5Cright%20%29%20%5Cright%29)| Merge Sort ![equation](https://latex.codecogs.com/gif.latex?O%5Cleft%28n%5Clog%5Cleft%20%28%20n%20%5Cright%20%29%20%5Cright%29)| Using a Trie |
|:-------:|:---------------------:|:--------------------:|:-----------------:|:-------------------:|:------------:|
|  Asger  |      NULL             |      NULL            |    NULL           |    NULL             |     NULL     |
| Camilla |      6.443.783ms      |      9.851.730ms     |    953ms          |    678ms            |     NULL     |
|   Rúni  |      NULL             |      NULL            |    1532ms           |    1095ms           |     NULL     |

## References

Algorithms ch. 2.1, 2.2, 2.3  
https://algs4.cs.princeton.edu/22mergesort/  
https://algs4.cs.princeton.edu/21elementary/  
https://algs4.cs.princeton.edu/24pq/  
https://algs4.cs.princeton.edu/lectures/keynote/52Tries-2x2.pdf  
