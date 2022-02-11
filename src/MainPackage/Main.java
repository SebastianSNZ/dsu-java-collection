package MainPackage;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //arrayListTest();
        vectorTest();
        //LinkedListTest();
        //priorityQueueTest();
        //hashSetTest();
        //linkedHashSetTest();
        //treeSetTest();
        //hashtableTest();
    }


    private static void arrayListTest() {
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
    }

    private static void vectorTest() {
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

    }

    private static void linkedListTest() {
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

    }

    private static void priorityQueueTest() {
        PriorityQueue<Animal> priorityQueue = new PriorityQueue<>();

        // inserting elements into the priority queue
        priorityQueue.add(new Animal("Dog", 1000));
        priorityQueue.add(new Animal("Cat", 900));
        priorityQueue.add(new Animal("Tiger", 1025));
        priorityQueue.add(new Animal("Bear", 500));
        priorityQueue.add(new Animal("Duck", 1250));

        // PriorityQueue inserts in order, using the _compareTo_ method

        // iterating the PriorityQueue
        System.out.println("PriorityQueue:");
        Animal actual = priorityQueue.poll();
        while (actual != null) {
            System.out.println(actual.show());
            actual = priorityQueue.poll();
        }
        System.out.println();
    }

    private static void hashSetTest() {
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

    }

    private static void linkedHashSetTest() {
        LinkedHashSet<Animal> linkedHashSet = new LinkedHashSet<>(); // HashSet use the _hashCode_ method like a key

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

        // deleting elements from the HashSet
        linkedHashSet.remove(new Animal("Cow", 125));
        linkedHashSet.remove(new Animal("Horse", 35));


        // iterating the HashSet again
        System.out.println("LinkedHashSet (second):");
        Iterator<Animal> secondIterator = linkedHashSet.iterator();
        while(secondIterator.hasNext()) {
            System.out.println(secondIterator.next().show());
        }
        System.out.println();

    }

    private static void treeSetTest() {
        TreeSet<Animal> treeSet = new TreeSet<>(); // HashSet use the _hashCode_ method like a key

        // adding elements into the LinkedHashSet
        treeSet.add(new Animal("Cat", 32));
        treeSet.add(new Animal("Dog", 122));
        treeSet.add(new Animal("Dolphin", 47));
        treeSet.add(new Animal("Shark", 48));
        treeSet.add(new Animal("Dog", 122)); // you can't add the same element twice or more

        // iterating the LinkedHashSet
        System.out.println("TreeSet (first):");
        Iterator<Animal> firstIterator = treeSet.iterator();
        while(firstIterator.hasNext()) {
            System.out.println(firstIterator.next().show());
        }
        System.out.println();

        // deleting elements from the HashSet
        treeSet.remove(new Animal("Shark", 48));
        treeSet.remove(new Animal("Cat", 32));


        // iterating the HashSet again
        System.out.println("TreeSet (second):");
        Iterator<Animal> secondIterator = treeSet.iterator();
        while(secondIterator.hasNext()) {
            System.out.println(secondIterator.next().show());
        }
        System.out.println();

    }

    private static void hashtableTest() {
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

    }

}
