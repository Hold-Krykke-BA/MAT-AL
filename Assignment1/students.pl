student(ronni, mat).
student(ronni, cs).
student(ulrik, cs).
student(aage, mat).
student(aage, logic).
student(aage, db).
student(hans, db).
student(hans, dsc).
student(steen, dsc).

teacher(anders, mat).
teacher(anders, logic).
teacher(thomas, cs).
teacher(tobias, dsc).
teacher(martin, db).

room(101, mat).
room(101, db).
room(201, cs).
room(301, logic).
room(301, dsc).

class(mat, mon).
class(cs, tue).
class(logic, wed).
class(db, thu).
class(dsc, fri).

day(mon).
day(tue).
day(wed).
day(thu).
day(fri).

teaches(X, Y) :-
	teacher(X, C),
	student(Y, C).
		
rooms(X, Y) :-
	room(X, C),
	class(C, Y).

% lectures(aage, anders,101, W)
% lectures(X, anders,101, W)
% lectures(X, Y,101, mon)
lectures(X, Y, Z, W) :-
	student(X, C),
	teacher(Y, C),
	room(Z, C),
	class(C, W).
	
	
	
	
	
	
	
	
	
	
	
	
	
