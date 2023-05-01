/**
*
* Name: Evan Halverson
* Date: 4/28/2023
* Description: I don't know
* Bugs: All of them
* Reflection: 
*
*/
import java.util.*;
import gitalong.*;
  
class Main {
  public static void main(String[] args) {
    CoolCollection<String> randomCollection = new CoolCollection<>(true);

    String[] words = {"never", "trust", "an", "atom,", "they", "make", "up", "everything"};
    for (String word : words) {
        randomCollection.add(word);
    }

    Iterator<String> iterator = randomCollection.iterator();
    System.out.print("Random: ");
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
    System.out.println();

    CoolCollection<String> wellBehavedCollection = new CoolCollection<>(false);
    for (String word : words) {
        wellBehavedCollection.add(word);
    }
    Iterator<String> wellBehavedIterator = wellBehavedCollection.iterator();
    System.out.print("Well Behaved Iterator: ");
    while (wellBehavedIterator.hasNext()) {
        System.out.print(wellBehavedIterator.next() + " ");
    }
    System.out.println();
  }  

}