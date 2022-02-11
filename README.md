# Java Collections
By: Sebastian Sanchez.

The Java platform includes the collection framework.A collection is a data structure that represents a group of objects. With this tool we can represent and manipulate collections, enabling collections to be manipulated independently of implementation details.

In this project, "Animal" objects are stored in the collections. These are the attributes of the class:

```java
public class Animal {

    private String name;
    private int population;

    public Animal(String name, int population) {
        this.setName(name);
        this.setPopulation(population);
    }

    public String show() {
        return "Animal: {"
                + "name: " + name + ", "
                + "population: " + population
                + "}";
    }
}
```

You can look the whole class in the file:
```
src/MainPackage/Animal.java
```

These are the collections' implementation, you can look the code in the file:

```
src/MainPackage/Main.java
```

## ArrayList

It's the resizable-array implementation of the List interface. This class provides methods to manipulate the size of the array that is used internally to store the list. Adding n elements to this collection requires O(n) time, retrieving an element takes O(1) time. 

Each ArrayList instance has a capacity, it is the size of the array used to store the elements in the list. As elements are added to an ArrayList, its capacity increases automatically.

This implementation is not synchronized. If multiple threads access an ArrayList instance concurrently, and at least one of the threads modifies the list structurally, it must be synchronized externally.

It is recommended to use an ArrayList when you want to access to its items by an index, taking advantage of the fact that getting an element takes O(1) time.

This is an example of ArrayList implementation, it add a few elements into the ArrayList and then iterates the list printing the info:

```java
ArrayList<Animal> arrayList = new ArrayList<>();
// add elements into the ArrayList
arrayList.add(new Animal("Dog", 1500));
arrayList.add(new Animal("Cat", 2500));

// add elements at a specific position, shifting any subsequent elements
arrayList.add(1, new Animal("Turkey", 5010));

// iterating the ArrayList
System.out.println("ArrayList (first):");
Iterator<Animal> firstIterator= arrayList.iterator();
while (firstIterator.hasNext()) {
    System.out.println(firstIterator.next().show());
}
System.out.println("");
```

Output:

```
ArrayList (first):
Animal: {name: Dog, population: 1500}
Animal: {name: Turkey, population: 5010}
Animal: {name: Cat, population: 2500}
```

Now, it deletes and updates elements from the ArrayList, then it prints the info:

```java
// deleting an element at specific index
arrayList.remove(1);

// deleting a specific object (using the _equals_ method)
arrayList.remove(new Animal("Dog", 1500));

// updating Animal data
arrayList.get(0).setName("Cat (updated)");

// iterating the ArrayList again
System.out.println("ArrayList (second):");
Iterator<Animal> secondIterator= arrayList.iterator();
while (secondIterator.hasNext()) {
    System.out.println(secondIterator.next().show());
}
System.out.println("");
```

Output:

```
ArrayList (second):
Animal: {name: Cat (updated), population: 2500}
```

## Vector

It implements a growable array of objects, it contains elements that can be accessed using an integer index. The size of a Vector can grow or shrink as needed to accommodate adding and removing elements after it has been created.

Each vector tries to optimize storage management by maintaining a capacity and an increment value. The capacity is always at least as large as the vector size, but it is usually larger waiting for more elements to be added in the vector.

Like an ArrayList, It is recommended to use a Vector when you want to access to its items by an index, taking advantage of the fact that getting an element takes O(1) time. This class is roughly equivalent to ArrayList, except that it is synchronized. The major difference between the two is that the vectors are thread-safe.

It is recommended to use a Vector when you want to access to its items by an index, taking advantage of the fact that getting an element takes O(1) time. If you are creating a threaded program you should use a Vector.

This is an example of Vector implementation, it add a few elements into the Vector and then iterates the Vector printing the info:

```java
Vector<Animal> vector = new Vector<>(3); // we set the initial capacity at 3

// adding elements at the end of the Vector
vector.add(new Animal("Cat", 10));
vector.add(new Animal("Fish", 14));
vector.add(new Animal("Turtle", 25));

// adding one element at a specific index, shifting any subsequent elements
vector.add(2, new Animal("Dog", 30));
vector.add(3, new Animal("Spider", 31));

// iterating the Vector
System.out.println("Vector (first), capacity=" + vector.capacity() +" :");
Iterator<Animal> firstIterator = vector.iterator();
while (firstIterator.hasNext()) {
    System.out.println(firstIterator.next().show());
}
System.out.println("");
```

Output:

```
Vector (first), capacity=6 :
Animal: {name: Cat, population: 10}
Animal: {name: Fish, population: 14}
Animal: {name: Dog, population: 30}
Animal: {name: Spider, population: 31}
Animal: {name: Turtle, population: 25}
```

Now, it deletes and updates elements from the Vector:

```java
// deleting an element at specific index
vector.remove(2);

// deleting a specific object (using the _equals_ method)
vector.remove(new Animal("Spider", 31));

// updating Animal data
vector.get(0).setName("Cat (updated)");

// iterating the Vector again
System.out.println("Vector (second), capacity=" + vector.capacity() +" :");
Iterator<Animal> secondIterator = vector.iterator();
while (secondIterator.hasNext()) {
    System.out.println(secondIterator.next().show());
}
System.out.println();
```

Output:
```
Vector (second), capacity=6 :
Animal: {name: Cat (updated), population: 10}
Animal: {name: Fish, population: 14}
Animal: {name: Turtle, population: 25}
```
