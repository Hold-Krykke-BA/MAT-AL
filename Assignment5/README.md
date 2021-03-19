# Analysing Log data

## Assignment

https://datsoftlyngby.github.io/soft2021spring/resources/4a48310c-04-assignment-regex.pdf


## Create a dynamic analyser

- A Login
  - B List items
    - C Get item
    -  D Edit item
    -  E Delete item
  - F Insert item
- G Logout

`AB(C(D|E))|F*G`

Using the provided log entries, we decided to creater a system with the following layout:  
|   | Login | List Items | Get Item | Edit Item | Delete Item | Insert Item | Logout |
|:-:|:-----:|:----------:|:--------:|:---------:|:-----------:|:-----------:|:------:|
|   |   A   |      B     |     C    |     D     |      E      |      F      |    G   |
| 0 |   1   |      5     |     5    |     5     |      5      |      5      |    5   |
| 1 |   5   |      2     |     5    |     5     |      5      |      1      |    4   |
| 2 |   5   |      5     |     3    |     5     |      5      |      5      |    4   |
| 3 |   5   |      5     |     5    |     2     |      2      |      5      |    5   |
| 4 |   5   |      5     |     5    |     5     |      5      |      5      |    5   |
| 5 |       |            |          |           |             |             |        |

```diff
- todo, add more details, implementation
```

##Create a finite state generator
```diff
- todo
```