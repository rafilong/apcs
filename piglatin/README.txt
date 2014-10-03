Piglatin Homework Project
Coded by Rafi Long

===

Basic information:

Documentation is in the source headers.

===

Summary:

The piglatin translator works by first asking the user for text to be translated. It then creates an object for the sentence, which it then divides into word objects. It does this by searching for spaces after the word, and then taking the space between the spaces and making a new word object out of it. It also makes sure to check for the end of the word, so the last word isn't left out. The words are then checked to see if they are capitalized. If they are, then the first letter is made lowercase and the second letter capital. The first letter is moved to the back, and "ay" is added to the word. Because words are translated on initialization, the sentence object then compiles these words back into a sentence.

===

Errors:

Sentences with punctuation do not work, as the program does not search for it. This is something that can be fixed in the future.

The program also hasn't been successfully run, as I was getting java.lang.ClassNotFoundException. This is supposedly the "nightmare" of the Java coder, and after spending a stressful 30 minutes trying to figure out my problem realized my IDE was creating the mistake, not my code. I'm guessing that the code should work functionally, but I will post an updated version after I am able to run it.