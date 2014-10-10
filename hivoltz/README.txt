Hivoltz Project
Coded by Rafi Long

===

Basic information:

Documentation is in the source headers.

===

Help:

Board:
Blue circle - You
Green circle - Mho (enemy)
Green square - Electric fence (obstacle)
Gray grid - Empty square


Objective:
The point of Hivoltz is to kill all of the mhos on electric fences without getting killed yourself.


Controls:
Q - Move diagonally up left
W - Move up
E - Move diagonally up right
A - Move left
S - Do not move
D - Move right
Z - Move diagonally down left
X - Move down
C - Move diagonally down right

J - Jump
Jumping moves you into a random square that isn't an electric fence. This does mean that you can land on a mho. However, jumping does not end your turn, so mhos will not move after you jump.

R - Reset


AI rules can be found at Mr. Paley's page here: http://paleyontology.com/AP_CS/hivolts/

===

Explanation of basic program flow:

The Main class contains all of the initialization of game elements, as well as reseting the board. It also contains an instance of Game.

Game contains an instance of Grid, and also keeps track of the status of the game. It is here that the methods called on player loss or win are stored.

Grid contains a two-dimensional array of Cells. It inializes the cells, and also contains variables that reference the player and all of the mhos.

The Cell class contains an enum called Type, which differentiates between the four different types of objects that can be in a cell. The Cell objects also contain the coordinates of the objects. In this way my program functions as Eularian program that contains references to it's objects in a grid. This allows me to create functions that work on a specific cell and still find itss surroundings.

The AI class's sole purpose is to make the AI follow the rules specified by Mr. Paley's webpage (see above). It calculates where the mho is in relationship to the player, and then finds it's movements based on the forementioned preset rules.

The Input class listens for player input and moves the player object. It also checks to see whether the player has moved onto a mho or fence, and ends the game if it has.

===

Bugs:

When running for the first time, the program always thinks that the height and width of the screen are 0, and then adds a bunch of whitespace. After running a second time, the width and height fit perfectly. This happens because the content isn't added to the JFrame yet, so the width and height is 0. I do not know how to fix this though.

===

Better features:

Buttons at the bottom of the page for reset and for help. However, I had very much trouble getting buttons to work, and instead added the instructions to the README. If I had more time, I would very much like to figure out how to get buttons to work.

Animations for mho and player death. Right now it is confusing what is going on unless you know the rules, and for this reason having animation would allow the player to see what was happening instead of seeing the game pieces jump around. Tyler Packard has very nice animations in his game, and it would be nice to implement something similar.

Keeping track of wins and losses would also be nice, especially if high scores were stored in a file.

Have Mho, Fence, and Player all be specialized classes of Cell. I would have done this, except we learned about inheritance and extending classes after I had already started my project. If I were to redo it, I feel this would be the best change.

===

Possible fixes:

Generalize the move function so it works for all cell types, instead of having two seperate moves. This would make the code more efficient, but as there isn't a class that moves both player and mho I wasn't sure which class to put it in and just made 2.

Avoid using findMhos, and instead remove mhos from the ArrayList in the move function. The reason why this wasn't done is that in the AI class the index where the mho is isn't passed between all methods, and doing that would make the code more difficult to understand. While finding the mhos makes the program slower, the amount of lag it might create is very minimal.

===

Implemented fixes:

Made player move function work by inputing the direction to move in, instead of having a separate method for each direction.

Made the AI move directions work like the above, instead of having one of horizontal, one for vertical, and one for diagonal (encapsulation is awesome!).