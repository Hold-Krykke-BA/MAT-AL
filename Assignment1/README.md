# Assignment #1 - Programming with predicates
Discrete Mathematics

1 PROgramming in LOGic
Create a program i Prolog.
You can either invent your own problem to solve or use one of the ideas described below. The program should include facts and rules. Also a set of meaningful questions to the program should be presented. Please push to github and supply a README.md file.  


## Student calendar
Create a program that models students, classes, rooms, dates, and their relations.


### Example questions to ask

#### Question about which teachers teaches which students:
```prolog
teaches(X, Y) :-
	teacher(X, C),
	student(Y, C).

/* example:
?- teaches(X, Y).
X = anders,
Y = ronni ;

X = anders,
Y = aage ;

X = anders,
Y = aage ;
*/
```

#### Question about what day which classes are held in what rooms:
```prolog		
rooms(X, Y) :-
	room(X, C),
	class(C, Y).
/* example
?- rooms(X, Y).
X = 101,
Y = mon ;

X = 101,
Y = thu ;

X = 201,
Y = tue ;
*/
```

#### Question about which student is taught by who, in which room on what day.
```prolog
lectures(X, Y, Z, W) :-
	student(X, C),
	teacher(Y, C),
	room(Z, C),
	class(C, W).
	
/* example
?- lectures(X, Y, Z, W).
X = ronni,
Y = anders,
Z = 101,
W = mon ;

X = ronni,
Y = thomas,
Z = 201,
W = tue ;

X = ulrik,
Y = thomas,
Z = 201,
W = tue ;
*/
```
