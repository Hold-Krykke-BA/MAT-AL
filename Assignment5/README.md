# Analysing Log data

## Assignment

https://datsoftlyngby.github.io/soft2021spring/resources/4a48310c-04-assignment-regex.pdf


## Create a dynamic analyser
Using the provided log entries, we decided to create a system with the following layout:  

- A Login
  - B List items
    - C Get item
      -  D Edit item
      -  E Delete item
    - F Insert item
  - F Insert item
- G Logout

We discussed if `C` should be a state of its own, leading to `D` and `E` but ultimately decided on the above setup.

`AB(C(D|E)F)|F*G`

|   | Login | List Items | Get Item | Edit Item | Delete Item | Insert Item | Logout |
|:-:|:-----:|:----------:|:--------:|:---------:|:-----------:|:-----------:|:------:|
|   |   A   |      B     |     C    |     D     |      E      |      F      |    G   |
| 0 |   1   |    null    |   null   |    null   |     null    |     null    |  null  |
| 1 |  null |      2     |   null   |    null   |     null    |      1      |    4   |
| 2 |  null |    null    |     3    |    null   |     null    |      2      |    4   |
| 3 |  null |    null    |   null   |     2     |      2      |     null    |  null  |
| 4 |  null |    null    |   null   |    null   |     null    |     null    |  null  |  

*Where **4** is END of the session.*

### Solution
The solution can be found in [src](src), with folders for data, interfaces, utilities and the solution itself.

Everything is combined in [src/Main.java](src/Main.java) where the required tasks are completed.

The utility Reader reads our log files from logfile.txt and returns a HashMap of the values needed for the automaton.  
The automaton implementation is built specifically for our alphabet as discussed above.  

Our [logfile](src/data/logfile.txt) holds the following summarized values:  
|    Level    | SystemID | InstanceID |  ActionID  | Timestamp |
|:-----------:|:--------:|:----------:|:----------:|:---------:|
| Information |    23    |    12345   | A, B, F, G |   23:00   |
| Information |    23    |    32512   | A, B, G, F |   23:00   |
| Information |    23    |    41231   |   A, F, F  |   23:00   |  

Or, in other words:  
`12345`: Login -> List Items -> Insert Item -> Logout.  
`32512`: Login -> List Items -> Logout -> Insert Item. (!)  
`41231`: Login -> Insert Item -> Insert Item.  

<details><summary>Program output <b>(click to reveal)</b></summary>
<p>

```java
Printing Automaton
1 0 0 0 0 0 0
0 2 0 0 0 1 4
0 0 3 0 0 2 4
0 0 0 2 2 0 0
0 0 0 0 0 0 0
------
Values read from logfile
41231 [A, F, F] //two insertions, not logged out
32512 [A, B, G, F] //logged out, followed by attempted insertion
12345 [A, B, F, G] //logged out succesfully
------
Are the performed actions allowed?
key: 41231
state 0, action A: true
state 1, action F: true
state 1, action F: true
key: 32512
state 0, action A: true
state 1, action B: true
state 2, action G: true
state 4, action F: false //not allowed after logout
key: 12345
state 0, action A: true
state 1, action B: true
state 2, action F: true
state 2, action G: true
------
List of instances not logged out
Instance ID: 41231 //never logged out
```

</p>
</details>

#### Assignment tasks

- is the action legal according to the present state.  
  For this task [we implemented the `Ok(state, action)` method](https://github.com/Hold-Krykke-BA/MAT-AL/blob/main/Assignment5/src/Main.java#L31-L41) as discussed in class, basically converting the result of the interface method `nextState(state, action)` to a boolean value. 
  `nextState` looks at the current table implementation and determines if the Action (which is a char) is allowed within the State context.  
   ```diff
   - todo example with ascii values?
   ```

- is any instance stuck at a non-final (non-accepting) state.  
  We found this a bit difficult to implement, as there weren't any hints to what such a state was - and we found it comparable to the third task.  
- give a list of the running instances.  
We [implemented a solution](https://github.com/Hold-Krykke-BA/MAT-AL/blob/main/Assignment5/src/Main.java#L44-L57) where we checked if the log had any record of the `G` (logout) action and returned those who had not.


## Create a Finite State Generator
Not completed, as it wasn't strictly required according to AKA, and we felt that the assignment was too vague to complete in a timely manner.
