Vocabulary 2
Coded by Rafi Long

===

Basic information:

Documentation is in the source headers.

See Main.java for explanation on usage of the vocab words, or below:

===

Explanation:

Inheritance
 Inheritance is extending a certain class to create a subclass that has some of the same attributes.
 Both Mini and Nissan extend from the Car class.
 
Delegation
 Delegation is the act of having a method who's purpose is fulfilled by calling another method through an object.
 This is done in the Car class in the numCylinders() method, which is delegated to Engine's getNumCylinders()

Polymorphism
 Polymorphism is having an object of a superclass, and setting its value to be a subclass of that superclass.
 This is done with the myCar field in the Main class, as it is switched from having a value of Mini to Nissan.
 It is demonstrated through the toString method, which in Mini does one thing and in Nissan does another.

Overloading
 Overloading is the act of making to methods with the same name that differ with the type and number of arguments.
 This is done in Mini, as it has an overloaded constructor that has 2 arguments that are automatically inferred
 from default car types (color and turning signal type)