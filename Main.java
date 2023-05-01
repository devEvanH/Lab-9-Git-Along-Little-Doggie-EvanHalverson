/**
*
* Name: Evan Halverson
* Date: 4/28/2023
* Description: This code creates two instances of the CoolCollection class, one with the option to iterate randomly and another with the option to iterate well-behaved. The collections are populated with a series of words using the add method, and then an iterator is obtained for each collection using the iterator method. The contents of each collection are printed out using the next method of the iterator. The purpose of the code is to showcase the different iteration behaviors of the CoolCollection class.
* Bugs: None
* Reflection: I found this lab to to be alright. The random iterator was a bit confusing and seemed like an odd thing to do, but I got the job. Not a bad lab, just kind of a weird one.  
*
*/
import java.util.*;
import gitalong.*;
  
class Main {
  // This is the main method of the program.
  // It creates two instances of the CoolCollection class, one that iterates randomly and another that iterates in a well-behaved manner.
  public static void main(String[] args) {
    // Create a CoolCollection instance with the option to iterate randomly.
    CoolCollection<String> randomCollection = new CoolCollection<>(true);
    // Add some words to the collection.
    String[] words = {"never", "trust", "an", "atom,", "they", "make", "up", "everything"};
    for (String word : words) {
        randomCollection.add(word);
    }
    // Get an iterator for the collection and print out its contents.
    Iterator<String> iterator = randomCollection.iterator();
    System.out.print("Random: ");
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
    System.out.println();
    System.out.println();
    // Create another CoolCollection instance with the option to iterate in a well-behaved manner.
    CoolCollection<String> wellBehavedCollection = new CoolCollection<>(false);
    // Add the same words to this collection.
    for (String word : words) {
        wellBehavedCollection.add(word);
    }
    // Get an iterator for this collection and print out its contents.
    Iterator<String> wellBehavedIterator = wellBehavedCollection.iterator();
    System.out.print("Well Behaved Iterator: ");
    while (wellBehavedIterator.hasNext()) {
        System.out.print(wellBehavedIterator.next() + " ");
    }
    System.out.println();
  }  

}