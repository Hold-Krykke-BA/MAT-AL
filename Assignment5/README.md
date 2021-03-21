# Analysing Log data

## Assignment

https://datsoftlyngby.github.io/soft2021spring/resources/4a48310c-04-assignment-regex.pdf


## Create a dynamic analyser
Using the provided log entries, we decided to creater a system with the following layout:  

- A Login
  - B List items
    - C Get item
      -  D Edit item
      -  E Delete item
    - F Insert item
  - F Insert item
- G Logout

We discussed if `C` should be a state of its own, leading to D and E but ultimately decided on the above setup.

`AB(C(D|E)F)|F*G`

|   | Login | List Items | Get Item | Edit Item | Delete Item | Insert Item | Logout |
|:-:|:-----:|:----------:|:--------:|:---------:|:-----------:|:-----------:|:------:|
|   |   A   |      B     |     C    |     D     |      E      |      F      |    G   |
| 0 |   1   |      null  |     null    |     null     |      null      |      null      |    null   |
| 1 |   null   |      2     |     null    |     null     |      null      |      1      |    4   |
| 2 |   null   |      null     |     3    |     null     |      null      |      2      |    4   |
| 3 |   null   |      null     |     null    |     2     |      2      |      null      |    null   |
| 4 |   null   |      null     |     null    |     null     |      null      |      null      |    null   |

*Where **4** is END of the session.*
