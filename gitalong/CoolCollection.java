package gitalong;
import java.util.*;

/**
*
* Name: Evan Halverson
* Date: 4/28/2023
* Description: This code defines a custom implementation of a collection class called CoolCollection, which can iterate either randomly or in a well-behaved manner. Two instances of this class are created in the code, one with the random iteration option and the other with the well-behaved iteration option. 
* Bugs: None
* Reflection: I made the random version of the code without using the iterated because I thought the iterator was unnessecary, but then I refactor it to what the directions asked for. The other inner class was incredibley easy after that. I would have rather started with the basic iterator before moving onto the more complex version. 
*
*/


/**
 * A custom implementation of a collection, which can iterate randomly or in a well-behaved manner.
 *
 * @param iterateRandomly a boolean value indicating whether the collection should iterate randomly or in a well-behaved manner.
 */
public class CoolCollection<E> {
    private ArrayList<E> pieces;
    private boolean iterateRandomly;
    
    /**
     * Constructs a CoolCollection with the specified iteration mode.
     *
     * @param iterateRandomly a boolean value indicating whether the collection should iterate randomly or in a well-behaved manner.
     */
    public CoolCollection(boolean iterateRandomly) {
        this.pieces = new ArrayList<E>();
        this.iterateRandomly = iterateRandomly;
    }

    /**
     * Adds the specified element to the collection.
     *
     * @param element the element to be added
     * @return true if the element was added to the collection, false otherwise
     */
    public boolean add(E element) {
        return this.pieces.add(element);
    }

    /**
     * Adds the specified element at the specified position in the collection.
     *
     * @param pos the position at which to add the element
     * @param element the element to be added
     */
    public void add(int pos, E element) {
        this.pieces.add(pos, element);
    }

    /**
     * Removes the specified element from the collection.
     *
     * @param element the element to be removed
     */
    public void remove(E element) {
        this.pieces.remove(element);
    }

    /**
     * Removes the element at the specified position in the collection.
     *
     * @param pos the position of the element to be removed
     * @return the removed element
     */
    public E remove(int pos) {
        return this.pieces.remove(pos);
    }

    /**
     * Returns an iterator over the elements in the collection.
     * @return an iterator over the elements in the collection
     * @throws IllegalStateException if an error occurs while creating the iterator
     */ 
    public Iterator<E> iterator() {
      try {
          if (this.iterateRandomly) {
              return new RandomIterator(1234567);
          } else {
              return new WellBehavedIterator();
          }
      } catch (IllegalStateException e) {
          System.err.println("An error occurred while creating the iterator: " + e.getMessage());
          System.exit(1);
          return null; // Only here to satisfy the compiler
      }
    }
  
    /**
     * Returns the number of elements in the collection.
     *
     * @return the number of elements in the collection
     */
    public int size() {
        return this.pieces.size();
    }

    /**
     * A private inner class that implements the RandomIterator.
     */
    private class RandomIterator implements Iterator<E> {
      private Random random;
      private Set<Integer> usedIndexes;

      /**
       * Constructs a RandomIterator with the specified seed.
       *
       * @param seed the seed for the random number generator
       */
      public RandomIterator(int seed) {
        this.random = new Random(seed);
        this.usedIndexes = new HashSet<Integer>();
      }

      /**
       * Returns true if there are more elements to iterate over, false otherwise.
       *
       * @return true if there are more elements to iterate over, false otherwise
       */
      public boolean hasNext() {
        return usedIndexes.size() < pieces.size();
      }

      /**
       * Returns the next random element in the collection.
       *
       * @return the next random element in the collection
       */
      public E next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements to iterate");
        }

        int index = random.nextInt(pieces.size());
        while (usedIndexes.contains(index)) {
            index = random.nextInt(pieces.size());
        }

        usedIndexes.add(index);
        return pieces.get(index);
      }
    }

  /**
   * A private inner class that implements the WellBehavedIterator.
   */
  private class WellBehavedIterator implements Iterator<E> {
    private Iterator<E> iterator;

    /**
     * Constructs a new WellBehavedIterator. 
     */
    public WellBehavedIterator() {
        this.iterator = pieces.iterator(); 
    }

    /**
     * Returns true if there is another element to iterate over, and false otherwise.
     * @return true if there is another element to iterate over, and false otherwise.
     */
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    /**
     * Returns the next element in the iteration.
     * @return the next element in the iteration.
     * @throws IllegalStateException if there is no next element to iterate over.
     */
    public E next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements to iterate");
        }
        E element = this.iterator.next();
        return element;
    }
  }


}