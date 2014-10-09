Hivoltz Project
Coded by Rafi Long

===

Basic information:

Documentation is in the source headers.

===

Possible fixes:

Generalize move so it works for all cell types, instead of having two seperate moves. This would make the code more efficient, but as there isn't a class that moves both player and mho I wasn't sure which class to put it in and just made 2.

Avoid using findMhos, and instead remove mhos from the ArrayList in the move function. The reason why this wasn't done is that in the AI class the mho number isn't passed between all methods, and doing that would make the code more difficult to understand. While finding the mhos makes the program slower, the amount of lag it might create is very minimal.

===

Fixes:

Made player move function work by inputing the direction to move in, instead of having a separate method for each.

Made the AI move directions work like the above, instead of having one of horizontal, one for vertical, and one for diagonal (encapsulation is awesome!).