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

    
    public Iterator<E> iterator() {
        if (this.iterateRandomly) {
            return new RandomIterator(1234567);
        } else {
            return new WellBehavedIterator();
        }
    }

    public int size() {
        return this.pieces.size();
    }
  
    private class RandomIterator implements Iterator<E> {
    private Random random;
    private Set<Integer> usedIndexes;

    public RandomIterator(int seed) {
        this.random = new Random(seed);
        this.usedIndexes = new HashSet<Integer>();
    }

    public boolean hasNext() {
        return usedIndexes.size() < pieces.size();
    }

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

  
  private class WellBehavedIterator implements Iterator<E> {
    private Iterator<E> iterator;

    public WellBehavedIterator() {
        this.iterator = pieces.iterator(); 
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public E next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements to iterate");
        }
        E element = this.iterator.next();
        return element;
    }
  }


}