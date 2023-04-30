package gitalong;
import java.util.ArrayList;
import java.util.Iterator;

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