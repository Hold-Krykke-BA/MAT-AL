# Assignment 5a

## Assignment description
See [bd35484e-05a-assignment.pdf](bd35484e-05a-assignment.pdf)

## Discussion
We had no idea where to start. These were our initial thoughts:

Camilla: 
> - engine der holder styr på variabler
> - for hver var holde styr på hvilke mulige værdier den var kan have  
> eks  
> hvis en var assignes til true i en blok skal programmet vide at den altid er true efter den kodeblok (det her er sort for mig)

Rúni: 
> så states er for boolean  
> INSTANTIATED, NULL, TRUE, FALSE  
> For integer er det   
> INSTANTIATED, MIN, MAX (constraint between min-max)  
 
Rúni:
> Vi skal have en form for state der gør følgende:  
>Punkt 1:  
>  Holder styr på alle variabler og deres eventuelle værdi (kan bare være oprettet uden værdi)  
>  Holder styr på variablers mulige værdier  
>
> Punkt 2:  
>  Staten skal være partially ordered (det kan jeg ikke lige forklare)  
>
> Punkt 3:  
>  Staten skal understøtte intersection og union som vist i undervisningen  
>  (start ligger på github repo: <https://github.com/datsoftlyngby/soft2021spring-mal/commit/8e9ffaf3dbbebca3607f84ba93bfaa38e19b3593>  

Rúni: 
> Jeg er ikke sikker på hvordan man laver noget partially ordered, men en State som består af  
> ```java
> HashMap<Type t, StateInfo si> variables;
> ```
> Hvor `t` er boolean eller integer. (Enten generisk eller at det kun kan være én af de to typer)  
> og `si` indeholder, for hver variabel (eks. "i", "j"):  
>   nuværende state for hver variabel  
>   Variablens mulige værdier  
> 
> Så for en kodeblok á denne format:
> ```java
> boolean a;
> boolean b = true;
> a = false;
> ```
> vil vi kunne for `boolean a` sige `variables.get("a")`. Eftersom den ikke findes, opretter vi en ny med dens Type (boolean), dens værdi (INSTANTIATED), og dens mulige værdier. 
> 
> Det samme gøres for `boolean b`, hvor dens værdi bare er sat til true.  
> 
> Og når vi sætter `a = false` på linje 3 vil vi kunne se den eksisterer. (modsat i linje 1) Her skal vi så tjekke om dens state er lovlig, og sætte den hvis den er.  
> 
> Ideen er jo så at der oprettes nye states for hver kodeblok..






## Solution
See the solution in [Main.java](src/Main.java). Interfaces and classes can be found in their respective folders.
```diff
- todo
```


## References
Video day 1: https://www.youtube.com/watch?v=WfUZd98esyU&t=10383s  
Video day 2: https://www.youtube.com/watch?v=Zribcfkg6Pw  
