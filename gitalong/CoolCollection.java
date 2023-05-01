package gitalong;
import java.util.*;

public class CoolCollection<E> {
    private ArrayList<E> pieces;
    private boolean iterateRandomly;

    public CoolCollection(boolean iterateRandomly) {
        this.pieces = new ArrayList<E>();
        this.iterateRandomly = iterateRandomly;
    }

    public boolean add(E element) {
        return this.pieces.add(element);
    }

    public void add(int pos, E element) {
        this.pieces.add(pos, element);
    }

    public void remove(E element) {
        this.pieces.remove(element);
    }

    public E remove(int pos) {
        return this.pieces.remove(pos);
    }

    // I don't understand if this even correct or not
    public Iterator<E> iterator() {
        if (this.iterateRandomly) {
            return new RandomIterator<E>(this.pieces);
        } else {
            return new WellBehavedIterator<E>(this.pieces);
        }
    }

    public int size() {
        return this.pieces.size();
    }

    // How in the world do I use the iterator interface for this
     private class RandomIterator<T> implements Iterator<T> {
        private ArrayList<T> elements;
        private Random random;
        private Set<Integer> usedIndexes;
    
        public RandomIterator(ArrayList<T> elements, long seed) {
            this.elements = elements;
            this.random = new Random(seed);
            this.usedIndexes = new HashSet<Integer>();
        }
    
        public boolean hasNext() {
            return usedIndexes.size() < elements.size();
        }
    
        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more elements to iterate");
            }
    
            int index = random.nextInt(elements.size());
            while (usedIndexes.contains(index)) {
                index = random.nextInt(elements.size());
            }
    
            usedIndexes.add(index);
            return elements.get(index);
        }

     }
  
  private class WellBehavedIterator<T> implements Iterator<T> {
    private Iterator<T> iterator;

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public T next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements to iterate");
        }
        T element = this.iterator.next();
        return element;
    }
  }

}