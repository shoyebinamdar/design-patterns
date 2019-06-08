# design-patterns

<b>Creational Design Pattern</b>

<b>Singleton</b> :- The Singleton Design Pattern aims to keep a check on initialization of objects of a particular class by ensuring that only one instance of the object exists throughout the Java Virtual Machine.

<b>Factory</b>:-  This pattern “defines an interface for creating an object, but let subclasses decide which class to instantiate. The Factory method lets a class defer instantiation to subclasses”.

<b>Abstract Factory</b>:- Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

<b>Builder</b>:- When the complexity of creating object increases, the Builder pattern can separate out the instantiation process by using another object (a builder) to construct the object.

<b>Object Pool</b>:- Object pool pattern is a software creational design pattern which is used in situations where the cost of initializing a class instance is very high.

<b>Prototype</b>:- A prototype is a template of any object before the actual object is constructed. In java also, it holds the same meaning. Prototype design pattern is used in scenarios where application needs to create a number of instances of a class, which has almost same state or differs very little.

<b>Structural Design Patterns</b>

<b>Adapter</b>:- The Adapter pattern is used for connecting two incompatible interfaces that otherwise cannot be connected directly. An Adapter wraps an existing class with a new interface so that it becomes compatible with the interface needed.

<b>Bridge</b>:- decouple an abstraction from its implementation so that the two can vary independently.
         This means to create a bridge interface that uses OOP principles to separate out responsibilities into different abstract classes.
         
<b>Decorator</b>:- This pattern is useful for enhancing the behavior of an object.

<b>Proxy Pattern</b>:- With this pattern, we create an intermediary that acts as an interface to another resource, e.g., a file, a connection. This secondary access provides a surrogate for the real component and protects it from the underlying complexity.

<b>Facade</b>:- A single class that represents an entire subsystem.

<b>Flyweight</b>:- A fine-grained instance used for efficient sharing.

<b>Behavioral Design Pattern</b>

<b>Chain of Responsibility</b>:- Chain of responsibility pattern is used to achieve loose coupling in software design where a request from the client is passed to a chain of objects to process them. Later, the object in the chain will decide themselves who will be processing the request and whether the request is required to be sent to the next object in the chain or not.

<b>Command</b>:- Chain of responsibility pattern is used to achieve loose coupling in software design where a request from the client is passed to a chain of objects to process them. Later, the object in the chain will decide themselves who will be processing the request and whether the request is required to be sent to the next object in the chain or not.

<b>Iterator Pattern</b>:- The iterator pattern provides a way to access the elements of an aggregate object without exposing its underlying representation.
 
<b>Observer Pattern</b>:- The Observer Pattern defines a one to many dependency between objects so that one object changes state, all of its dependents are notified and updated automatically.

<b>State</b>:- State design pattern is used when an Object changes its behavior based on its internal state.

<b>Strategy</b>:- The strategy pattern (also known as the policy pattern) is a software design pattern that enables an algorithm’s behavior to be selected at runtime.    

<b>Visitor</b>:- Defines a new operation to a class without change.
         