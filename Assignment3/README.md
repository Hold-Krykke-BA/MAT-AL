# Assignment 3 - Sorting Shakespeare

This is the first of five mini projects - mandatory assignments.
#### In groups:
We want Shakespeares complete works, sorted by word. Meaning that “to be or not to be, that is the question” would be sorted as: “be be is not or question that the to to”.
You can find the complete works [here](https://github.com/datsoftlyngby/soft2020spring-alg/tree/master/data). You shall in groups create a program, that can
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
   ```diff
  - add details (if any)
  ```
### Selection Sort
   ```diff
  - add details
  ```
### Insertion Sort
   ```diff
  - add details
  ```
### Heap Sort
   ```diff
  - add details
  ```
### Merge Sort
Details can be found in chapter 2.2 *Mergesort* (pg. 270) of Algorithms.  

The chapter goes into detail of the different variations of Merge Sort:  
- Abstract in-place merge  
  ```diff
  - add details from chapter
  ```
- Top-down mergesort
   ```diff
  - add details from chapter
  ```
- Bottom-up mergesort
  ```diff
  - add details from chapter
  ```

Additionally, the chapter discusses solutions to optimize the algorithm (pg. 275):
- Using insertion sort for small subarrays:
> *Switching to insertion sort for small subarrays (length 15 or less,
say) will improve the running time of a typical mergesort implementation by 10 to 15
percent.*
- Testing whether the array is already in order:  
> *We can reduce the running time to be linear for arrays that are already in order by adding a test to skip the call to merge() if
a[mid] is less than or equal to a[mid+1].*  
- Eliminating the copy to the auxiliary (temporary) array:  
> *It is possible to eliminate the time (but not
the space) taken to copy to the auxiliary array used for merging. To do so, we use two
invocations of the sort method: one takes its input from the given array and puts the
sorted output in the auxiliary array; the other takes its input from the auxiliary array
and puts the sorted output in the given array.*

As well as touches on the complexity of sorting (pg. 279 onwards).



[Merge sort in 3 minutes](https://www.youtube.com/watch?v=4VqmGXwpLqc) by Michael Sambol on Youtube.  
[Sorts 6 Merge Sort](https://www.youtube.com/watch?v=qdv3i6X0PiQ) by RobEdwards on Youtube.  

### Sorting using a Trie
   ```diff
  - add details 
  ```
## Description of solution
#### Folder content
- [src/solution](src/solution)  
  Holds the interfaces, the different solutions implemented, and a Main class.

- [src/utils](src/utils)  
  Holds the utilities provided in-class.

We implemented two different interfaces, [ISort](src/solution/sorts/ISort.java) as described in the book utilizing `Comparable<T>` as well as [ISortGeneric](src/solution/sorts/ISortGeneric.java) which utilizes Java Generics as shown in class.


### Selection Sort
   ```diff
  - add details about implementation
  ```
### Insertion Sort
   ```diff
  - add details about implementation
  ```
### Heap Sort
   ```diff
  - add details about implementation
  ```
### Merge Sort
   ```diff
  - add details about implementation
  ```
### Sorting using a Trie
   ```diff
  - add details about implementation
  ```

### Future usability
This section refers to the following requirement of the assignment:  
*[the program can] be extended with other sorting algorithms in the future.*  

As already mentioned above, we implemented two interfaces, one from the book which utilizes `Comparable<T>` and one shown in-class that uses Java Generics, both of which can be found in [src/solution/sorts](src/solution/sorts/).  


   ```diff
  - add details about implementation & add to the Comparable Vs Generics above
  ```
### Timings
This section refers to the following requirement of the assignment:  
*[the program can] messure and log the time used for each algorithm as a function of the file size in words.*  

To time our program we utilized the provided [Stopwatch](src/utils/Stopwatch.java) class.  

   ```diff
  - add details about implementation
  ```

## References
Algorithms ch. 2.1, 2.2, 2.3  
