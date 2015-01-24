Vocabulary One
Coded by Rafi Long

===

Basic information:

Documentation is in the source headers.

See Main.java for explanation on usage of the vocab words, or below:

===

Explanation:

Public interface of a class
 A public interface of a class are the methods and values accessible from the outside.
 All methods can be described by their public interfaces, and these determine what other methods can access.
 An example in this code is Mini, in which values can't be changed after initialization, but they can be gotten.

Interface
 An interface is a type of class used to specify certain methods that the subclass will use, such as Comparable.
 This allows a coder to easily create a program that will work with certain objects that extend a certain interface.
 An interface in this program is the Car interface, which other cars can extend from.

Encapsulation
 Encapsulation is making private variables accessible through public methods, known as getters and setters.
 An example of encapsulation is shown in the Mini class, where price, color, and numWheels are only accessible
 through their getters. This means that if something needs to be changed, such as returning the number of wheels
 on one side of the car, the getter can easily be changed instead of adding a bunch of code, which makes other
 programs using the class not break when the change happens.

Invariant
 An invariant is a value, or a equation, that stays constant through a certain piece of code.
 An invariant in this code is that when a Mini has a turning signal thing, the color has to be red.
