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
            return new RandomIterator<E>(this.pieces);
        } else {
            return new WellBehavedIterator<E>(this.pieces);
        }
    }

    public int size() {
        return this.pieces.size();
    }

     private class RandomIterator<T> implements Iterator<T> {
        private Random random;
        private int[] indexOrder;
        private int currentIndex; 

        public RandomIterator(int seed) {
            this.iterator = pieces.iterator();
            this.random = new Random(seed);
            currentIndex = 0;
            indexOrder = new int[pieces.size() - 1];
            indexOrder[0] = random.nextInt(pieces.size());
      
            int i = 1;
            while (i < pieces.size()) {
              int randIndex = random.nextInt(pieces.size());
              while(j <= i && randIndex != indexOrder[j]) {
                j++;
              }
              if(j > i) {
                indexOrder[j] = randIndex;
                i++;
              } 
            }
        }

        public boolean hasNext() {
            return (currentIndex < pieces.size() - 1);
        }

        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more elements to iterate");
            }
            T elemnt = pieces(indexOrder[currentIndex]);
            currentIndex++;
            return element;
        }

     }

}