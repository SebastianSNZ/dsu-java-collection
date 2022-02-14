# Java Collections
By: Sebastian Sanchez.

The Java platform includes the collection framework.A collection is a data structure that represents a group of objects. With this tool we can represent and manipulate collections, enabling collections to be manipulated independently of implementation details.

![Collection hierarchy](https://upload.wikimedia.org/wikipedia/commons/a/ab/Java.util.Collection_hierarchy.svg)

![Map hierarchy](https://upload.wikimedia.org/wikipedia/commons/7/7b/Java.util.Map_hierarchy.svg)

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

To run this project:

```
cd src
javac MainPackage/*.java 
java MainPackage.Main 
```



## Contents

[1. ArrayList](#arraylist)

[2. Vector](#vector)

[3. LinkedList](#linkedlist)

[4. PriorityQue](#priorityqueue)

[5. HashTable](#hashtable)

[6. HashMap](#hashmap)

[7. LinkedHashMap](#linkedhashmap)

[8. TreeMap](#treemap)

[9. HashSet](#hashset)

[10. LinkedHashSet](#linkedhashset)

[11. TreeSet](#treeset)

## ArrayList

It's the resizable-array implementation of the List interface. This class provides methods to manipulate the size of the array that is used internally to store the list. Adding n elements to this collection requires O(n) time, retrieving an element takes O(1) time. 

![Array example](https://www.thedshandbook.com/wp-content/uploads/2019/09/oned_array.svg)

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
## LinkedList

It is the List implementation of a doubly-linked list. A linked list is a linear data structure where the elements are not stored contiguously, like an array, and every element is a separate object, sometimes called a "node". Nodes have a data part and an address part, the address part stores the memory direction of the subsequents nodes using pointers. 

![LinkeList example](https://upload.wikimedia.org/wikipedia/commons/5/5e/Doubly-linked-list.svg) 

Adding, removing and getting an element by an index or position requires O(n) time, where n is the number of elements stored in the LinkedList. Adding or getting an element at the end or the head of the list requires O(1) time, the main benefit of the LinkedList. We can use the linked list when we want to know the first and last elements inserted, the main benefit or difference against ArrayList and Vector.

This is an example of LinkedList implementation, it add a few elements into the list and then iterates the list printing the info:

```java
LinkedList<Animal> linkedList = new LinkedList<>();

// adding elements at the end of the LinkedList
linkedList.add(new Animal("Dog", 500));
linkedList.add(new Animal("Hamster", 600));
linkedList.add(new Animal("Mouse", 700));
linkedList.add(new Animal("Tiger", 200));
linkedList.add(new Animal("Turtle", 100));

// adding elements at a specific position
linkedList.add(2, new Animal("Cat", 900));

// iterating the LinkedList
System.out.println("LinkedList (first):");
Iterator<Animal> firstIterator = linkedList.iterator();
while (firstIterator.hasNext()) {
    System.out.println(firstIterator.next().show());
}
System.out.println("");
```

Output:
```
LinkedList (first):
Animal: {name: Dog, population: 500}
Animal: {name: Hamster, population: 600}
Animal: {name: Cat, population: 900}
Animal: {name: Mouse, population: 700}
Animal: {name: Tiger, population: 200}
Animal: {name: Turtle, population: 100}
```

Now, it deletes and updates elements from the LinkedList:

```java
// deleting an element at specific position
linkedList.remove(2);

// deleting the first element of the LinkedList
linkedList.removeFirst();

// deleting the last element of the LinkedList
linkedList.removeLast();

// updating an element inside the LinkedList
linkedList.get(1).setName("Mouse (updated)");

// iterating the LinkedList
System.out.println("LinkedList (second):");
Iterator<Animal> secondIterator = linkedList.iterator();
while (secondIterator.hasNext()) {
    System.out.println(secondIterator.next().show());
}
System.out.println("");
```

Output:
```
LinkedList (second):
Animal: {name: Hamster, population: 600}
Animal: {name: Mouse (updated), population: 700}
Animal: {name: Tiger, population: 200}
```

## PriorityQueue

It is a priority queue based on a priority heap. The elements of the priority queue are ordered according to their natural ordering or by a `Comparator` object. To apply this natural ordering our object has to implement the interface `Comparable` and implement the `compareTo` method, for example in the Animal class:

```java
public class Animal implements Comparable<Animal>{

    ...

    @Override
    public int compareTo(Animal o) {
        return this.population - o.population;
    }

    ...
}
```

A priority queue does not permit null elements and does not permit insertion of non-comparable objects. The head of this queue is the least element with respect to the specified ordering. If multiple elements are tied for least value, the head is one of these elements. The queue principal operations are: poll to retrieve and remove the head, peek to retrieve the data of the head but don't remove it. The iterator provided in this class is not guaranteed to traverse the elements of the priority queue in any particular order.

You can use a PriorityQueue when you need order in the insertions but you don't need to know the whole sequence of elements stored. 

This is an example of the PriorityQueue implementation:

```java
PriorityQueue<Animal> priorityQueue = new PriorityQueue<>();

// inserting elements into the priority queue
priorityQueue.add(new Animal("Dog", 1000));
priorityQueue.add(new Animal("Cat", 900));
priorityQueue.add(new Animal("Tiger", 1025));
priorityQueue.add(new Animal("Bear", 600));
priorityQueue.add(new Animal("Duck", 1250));
priorityQueue.add(new Animal("Earthworm", 500));
// PriorityQueue inserts in order, using the _compareTo_ method

// deleting an element from the queue

priorityQueue.remove(new Animal("Bear", 500));

// iterating the PriorityQueue
System.out.println("PriorityQueue:");
Animal actual = priorityQueue.poll();
while (actual != null) {
    System.out.println(actual.show());
    actual = priorityQueue.poll();
}
System.out.println();
```
Output:
```
PriorityQueue:
Animal: {name: Earthworm, population: 500}
Animal: {name: Bear, population: 600}
Animal: {name: Cat, population: 900}
Animal: {name: Dog, population: 1000}
Animal: {name: Tiger, population: 1025}
Animal: {name: Duck, population: 1250}
```
The elements are sorted by the `population` attribute.

## Hashtable

This class implements a hash table, which maps keys to values, any non-null object can be used as a key or as a value. To successfully store and retrieve objects from a hashtable, the objects used as keys must implement the `hashCode` method and the `equals` method.

![Hashtable example](https://upload.wikimedia.org/wikipedia/commons/b/b6/Hash_table_simple_999.svg)

An instance of a hashtable has two important parameters: initial capacity and load factor. The `capacity` is the number of buckets in the hash table, and the initial capacity is simply the capacity at the time the hash table is created. Note that the hash table is open: in the case of a "hash collision", a single bucket stores multiple entries, which must be searched sequentially, it requires O(n) time in the worst scenario, n is the number of elements stored in the hashtable. 

The load factor is a measure of how full the hash table is allowed to get before its capacity is automatically increased. Generally, the default load factor (.75) offers a good tradeoff between time and space costs.

This is an example of a Hashtable implementation, it add a few elements into the table and then iterates it printing the info:

```java
Hashtable<String, Animal> hashtable = new Hashtable<>();

// adding elements using a string key
hashtable.put("cat", new Animal("Cat", 10));
hashtable.put("dog", new Animal("Dog", 15));
hashtable.put("hamster", new Animal("Hamster", 150));
hashtable.put("bird", new Animal("Bird", 20));

// iterating the Hashtable
System.out.println("Hashtable (first):");
Set<String> setOfKeys = hashtable.keySet();
Iterator<String> firstIterator = setOfKeys.iterator();
while (firstIterator.hasNext()) {
    String key = firstIterator.next();
    System.out.println("Key: \"" + key + "\" " + hashtable.get(key).show());
}
System.out.println();
```

Output:
```
Hashtable (first):
Key: "cat" Animal: {name: Cat, population: 10}
Key: "dog" Animal: {name: Dog, population: 15}
Key: "bird" Animal: {name: Bird, population: 20}
Key: "hamster" Animal: {name: Hamster, population: 150}
```

Now, it removes an entry and updates a value using a key:

```java
// deleting an element using a string key
hashtable.remove("dog");

// updating a value using a string key
hashtable.replace("hamster", new Animal("New Hamster", 125));

// iterating the Hashtable
System.out.println("Hashtable (second):");
Iterator<String> secondIterator = setOfKeys.iterator();
while (secondIterator.hasNext()) {
    String key = secondIterator.next();
    System.out.println("Key: \"" + key + "\" " + hashtable.get(key).show());
}
System.out.println();
```
Output:
```
Hashtable (second):
Key: "cat" Animal: {name: Cat, population: 10}
Key: "bird" Animal: {name: Bird, population: 20}
Key: "hamster" Animal: {name: New Hamster, population: 125}
```

## HashMap

It is a hash table implementation of the Map interface. This implementation provides all of the optional map operations, and permits null values and the null key. This class does not guarantee that the order of its elements will remain constant over time.

The HashMap class is roughly equivalent to Hashtable, except that it is unsynchronized (it means it isn't thread-safe) and it permits nulls as a key or as a value.

This implementation provides constant-time performance for the basic operations like `get` and `put`, assuming the hash function disperses the elements properly among the buckets. 

This is an example of a HashMap implementation, it add a few elements into the table and then iterates it printing the info:

```java
HashMap<String, Animal> hashMap = new HashMap<>();

// adding elements using a string key
hashMap.put("fish", new Animal("Fish", 95));
hashMap.put("bison", new Animal("Bison", 112));
hashMap.put("rat", new Animal("Rat", 120));
hashMap.put("bird", new Animal("Bird", 40));
hashMap.put(null, new Animal("Albatross", 10));

// iterating the HashMap
System.out.println("HashMap (first):");
Set<String> setOfKeys = hashMap.keySet();
Iterator<String> firstIterator = setOfKeys.iterator();
while (firstIterator.hasNext()) {
    String key = firstIterator.next();
    System.out.println("Key: \"" + key + "\" " + hashMap.get(key).show());
}
// printing the value with null key
System.out.println("Key: null " + hashMap.get(null).show());
System.out.println();
```

Output:
```
HashMap (first):
Key: "null" Animal: {name: Albatross, population: 10}
Key: "rat" Animal: {name: Rat, population: 120}
Key: "fish" Animal: {name: Fish, population: 95}
Key: "bird" Animal: {name: Bird, population: 40}
Key: "bison" Animal: {name: Bison, population: 112}
Key: null Animal: {name: Albatross, population: 10}
```

Now, it removes elements and updates a value using a string key:

```java
// deleting an element using a string key
hashMap.remove("bison");

// deleting an element using the null key
hashMap.remove(null);

// updating a value using a string key
hashMap.replace("rat", new Animal("New Rat", 1000));

// iterating the HashMap again
System.out.println("HashMap (second):");
Iterator<String> secondIterator = setOfKeys.iterator();
while (secondIterator.hasNext()) {
    String key = secondIterator.next();
    System.out.println("Key: \"" + key + "\" " + hashMap.get(key).show());
}
System.out.println();
```

Output:
```
HashMap (second):
Key: "rat" Animal: {name: New Rat, population: 1000}
Key: "fish" Animal: {name: Fish, population: 95}
Key: "bird" Animal: {name: Bird, population: 40}
```

## LinkedHashMap

It is an implementation of a Map using a hash table and linked list. Using this data structure it has predictable iteration order.

This implementation differs from HashMap in that it maintains a doubly-linked list running through all of its buckets. This linked list defines the iteration ordering, which is normally the order in which keys were inserted into the map, an insertion-order. 

![LinkedHashMap example](https://upload.wikimedia.org/wikipedia/commons/d/d0/Hash_table_5_0_1_1_1_1_1_LL.svg)

That insertion order is not affected if a key is re-inserted into the map, for example: a key `k` is reinserted into a map `m` if `m.put(k, v)`.

This permits null elements. Like HashMap, it provides constant-time performance for the basic operations: add, contains and remove; assuming the hash function disperses elements properly among the buckets. Adding, getting and removing an element requires O(n) time in the worst scenario (n is the number of the elements in the map).

This is an example of a LinkedHashMap implementation, it add a few elements into the table and then iterates it printing the info:

```java
LinkedHashMap<String, Animal> linkedHashMap = new LinkedHashMap<>();

// adding elements using a string key
linkedHashMap.put("rabbit", new Animal("Rabbit", 400));
linkedHashMap.put("tortoise", new Animal("Tortoise", 500));
linkedHashMap.put("tiger", new Animal("Tiger", 315));
linkedHashMap.put("toucan", new Animal("Toucan", 270));
linkedHashMap.put("owl", new Animal("Owl", 415));

// iterating the LinkedHashMap
System.out.println("LinkedHashMap (first):");
Set<String> setOfKeys = linkedHashMap.keySet();
Iterator<String> firstIterator = setOfKeys.iterator();
while (firstIterator.hasNext()) {
    String key = firstIterator.next();
    System.out.println("Key: \"" + key + "\" " + linkedHashMap.get(key).show());
}
System.out.println();
```

Output:
```
LinkedHashMap (first):
Key: "rabbit" Animal: {name: Rabbit, population: 400}
Key: "tortoise" Animal: {name: Tortoise, population: 500}
Key: "tiger" Animal: {name: Tiger, population: 315}
Key: "toucan" Animal: {name: Toucan, population: 270}
Key: "owl" Animal: {name: Owl, population: 415}
```

Now, it removes elements and updates a value using a string key:

```java
// deleting an element using a string key
linkedHashMap.remove("tortoise");

// updating a value using a string key
linkedHashMap.replace("tiger", new Animal("White Tiger", 5));

// iterating the LinkedHashMap again
System.out.println("LinkedHashMap (second):");
Iterator<String> secondIterator = setOfKeys.iterator();
while (secondIterator.hasNext()) {
    String key = secondIterator.next();
    System.out.println("Key: \"" + key + "\" " + linkedHashMap.get(key).show());
}
System.out.println();
```

Output:
```
LinkedHashMap (second):
Key: "rabbit" Animal: {name: Rabbit, population: 400}
Key: "tiger" Animal: {name: White Tiger, population: 5}
Key: "toucan" Animal: {name: Toucan, population: 270}
Key: "owl" Animal: {name: Owl, population: 415}
```

## TreeMap

It is an implementation of a `NavigableMap`, a sorted map that may be accessed and traversed in either ascending or descending key order. In the TreeMap the values are ordered using their keys by the natural ordering (using the compareTo method). The basic operations (add, remove and contains) require O(log(n)) time.

![Tree example](https://upload.wikimedia.org/wikipedia/commons/4/45/Tree-data-structure.svg)

You can use the TreeMap when you want to maintain order and use less time during searches of elements. 

This is an example of a TreeMap implementation, it add a few elements into the map and then iterates the map printing the info:

```java
TreeMap<String, Animal> treeMap = new TreeMap<>();

// adding elements using a string key
treeMap.put("spider", new Animal("Spider", 88));
treeMap.put("whale", new Animal("Whale", 12));
treeMap.put("fish", new Animal("Fish", 26));
treeMap.put("albatross", new Animal("Albatross", 29));
treeMap.put("eagle", new Animal("Eagle", 15));

// iterating the TreeMap
// it will show all elements sorted alphabetically (sorted by the string key)
System.out.println("TreeMap (first):");
Set<String> setOfKeys = treeMap.keySet();
Iterator<String> firstIterator = setOfKeys.iterator();
while (firstIterator.hasNext()) {
    String key = firstIterator.next();
    System.out.println("Key: \"" + key + "\" " + treeMap.get(key).show());
}
System.out.println();
```

Output:
```
TreeMap (first):
Key: "albatross" Animal: {name: Albatross, population: 29}
Key: "eagle" Animal: {name: Eagle, population: 15}
Key: "fish" Animal: {name: Fish, population: 26}
Key: "spider" Animal: {name: Spider, population: 88}
Key: "whale" Animal: {name: Whale, population: 12}
```

Now, it deletes elements from the TreeMap :

```java
// deleting an element using a string key
treeMap.remove("fish");

// updating a value using a string key
treeMap.replace("spider", new Animal("Black Widow", 15));

// iterating the TreeMap again
System.out.println("TreeMap (second):");
Iterator<String> secondIterator = setOfKeys.iterator();
while (secondIterator.hasNext()) {
    String key = secondIterator.next();
    System.out.println("Key: \"" + key + "\" " + treeMap.get(key).show());
}
System.out.println();
```
Output:
```
TreeMap (second):
Key: "albatross" Animal: {name: Albatross, population: 29}
Key: "eagle" Animal: {name: Eagle, population: 15}
Key: "spider" Animal: {name: Black Widow, population: 15}
Key: "whale" Animal: {name: Whale, population: 12}
```

## HashSet

This is the implementation of a Set backed by a hash table (a HashMap instance). This collection does not guarantee the iteration order of the set; in particular, it does not guarantee that the order will remain constant over time. 

The basic operation of the HashSet (add, remove, contains and size) requires O(1) time assuming that the hash function disperses the elements properly among the buckets of the hash table. You can use the HashSet when you want to store elements without repetitions and then knowing the full sequence of elements stored. 

This is an example of a HashSet implementation, it add a few elements into the set and then iterates the set printing the info:

```java
HashSet<Animal> hashSet = new HashSet<>(); // HashSet use the _hashCode_ method like a key

// adding elements into the HashSet
hashSet.add(new Animal("Duck", 100));
hashSet.add(new Animal("Wolf", 120));
hashSet.add(new Animal("Worm", 1000));
hashSet.add(new Animal("Ant", 1500));
hashSet.add(new Animal("Dolphin", 90));
hashSet.add(new Animal("Worm", 1000)); // you can't add the same element twice or more

// iterating the HashSet
System.out.println("HashSet (first):");
Iterator<Animal> firstIterator = hashSet.iterator();
while(firstIterator.hasNext()) {
    System.out.println(firstIterator.next().show());
}
System.out.println();
```

Output:
```
HashSet (first):
Animal: {name: Dolphin, population: 90}
Animal: {name: Duck, population: 100}
Animal: {name: Worm, population: 1000}
Animal: {name: Wolf, population: 120}
Animal: {name: Ant, population: 1500}
```


Now, it deletes elements from the HashSet:

```java
// deleting elements from the HashSet
hashSet.remove(new Animal("Duck", 100));
hashSet.remove(new Animal("Wolf", 120));

// iterating the HashSet again
System.out.println("HashSet (second):");
Iterator<Animal> secondIterator = hashSet.iterator();
while(secondIterator.hasNext()) {
    System.out.println(secondIterator.next().show());
}
System.out.println();
```

Output:
```
HashSet (second):
Animal: {name: Dolphin, population: 90}
Animal: {name: Worm, population: 1000}
Animal: {name: Ant, population: 1500}
```

## LinkedHashSet

It is an implementation of a Set using a hash table and a linked list. By using a linked list it has predictable iteration order, which is the order where elements are inserted in the set. This is the main difference from HashSet, the LinkedHashSet maintains a doubly-linked list running through all of its buckets.

Like HashSet, basic operations (add, contains and remove) require O(1) time, assuming the hash function disperses elements properly among the buckets.

You can use the HashSet when you want to store elements without repetitions and you want to maintain the insertion order.. 

This is an example of a LinkedHashSet implementation, it add a few elements into the set and then iterates the set printing the info:

```java
LinkedHashSet<Animal> linkedHashSet = new LinkedHashSet<>();

// adding elements into the LinkedHashSet
linkedHashSet.add(new Animal("Cat", 115));
linkedHashSet.add(new Animal("Cow", 125));
linkedHashSet.add(new Animal("Horse", 35));
linkedHashSet.add(new Animal("Spider", 225));
linkedHashSet.add(new Animal("Horse", 35)); // you can't add the same element twice or more

// iterating the LinkedHashSet
System.out.println("LinkedHashSet (first):");
Iterator<Animal> firstIterator = linkedHashSet.iterator();
while(firstIterator.hasNext()) {
    System.out.println(firstIterator.next().show());
}
System.out.println();
```

Output:
```
LinkedHashSet (first):
Animal: {name: Cat, population: 115}
Animal: {name: Cow, population: 125}
Animal: {name: Horse, population: 35}
Animal: {name: Spider, population: 225}
```

Now, it deletes elements from the LinkedHashSet:

```java
// deleting elements from the LinkedHashSet
linkedHashSet.remove(new Animal("Cow", 125));
linkedHashSet.remove(new Animal("Horse", 35));


// iterating the LinkedHashSet again
System.out.println("LinkedHashSet (second):");
Iterator<Animal> secondIterator = linkedHashSet.iterator();
while(secondIterator.hasNext()) {
    System.out.println(secondIterator.next().show());
}
System.out.println();
```
Output:
```
LinkedHashSet (second):
Animal: {name: Cat, population: 115}
Animal: {name: Spider, population: 225}
```

## TreeSet

It is a Set implementation based on a TreeMap. The elements are ordered using their natural ordering (using the compareTo method). The basic operations (add, remove and contains) require O(log(n)) time.

You can use the TreeSet when you want to store elements without repetitions and you want to maintain order. 

This is an example of a TreeSet implementation, it add a few elements into the set and then iterates the set printing the info:

```java
TreeSet<Animal> treeSet = new TreeSet<>();

// adding elements into the TreeSet
treeSet.add(new Animal("Cat", 32));
treeSet.add(new Animal("Dog", 122));
treeSet.add(new Animal("Dolphin", 47));
treeSet.add(new Animal("Shark", 48));
treeSet.add(new Animal("Dog", 122)); // you can't add the same element twice or more

// iterating the TreeSet
System.out.println("TreeSet (first):");
Iterator<Animal> firstIterator = treeSet.iterator();
while(firstIterator.hasNext()) {
    System.out.println(firstIterator.next().show());
}
System.out.println();
```

Output:
```
TreeSet (first):
Animal: {name: Cat, population: 32}
Animal: {name: Dolphin, population: 47}
Animal: {name: Shark, population: 48}
Animal: {name: Dog, population: 122}
```

Now, it deletes elements from the TreeSet :

```java
// deleting elements from the TreeSet
treeSet.remove(new Animal("Shark", 48));
treeSet.remove(new Animal("Cat", 32));


// iterating the TreeSet again
System.out.println("TreeSet (second):");
Iterator<Animal> secondIterator = treeSet.iterator();
while(secondIterator.hasNext()) {
    System.out.println(secondIterator.next().show());
}
System.out.println();
```

Output:
```
TreeSet (second):
Animal: {name: Dolphin, population: 47}
Animal: {name: Dog, population: 122}
```

## References
- https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html

- https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html

- https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html

- https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html

- https://www.geeksforgeeks.org/linked-list-in-java/

- https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html

- https://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html

- https://docs.oracle.com/javase/10/docs/api/java/util/LinkedHashSet.html

- https://docs.oracle.com/javase/7/docs/api/java/util/TreeSet.html

- https://docs.oracle.com/javase/8/docs/api/java/util/Hashtable.html

- https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html

- https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html

- https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html

- https://docs.oracle.com/javase/8/docs/api/java/util/NavigableMap.html
