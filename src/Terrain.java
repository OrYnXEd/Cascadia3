import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public enum Terrain implements List<Terrain> {
    STARTER('S',"WHITE"),
    FOREST('F', "Dark green"),
    WETLAND('W', "Light green"),
    RIVER('R', "Blue"),
    MOUNTAIN('M', "Grey"),
    PRAIRIE('P', "Yellow");

    private final char displayChar;
    private final String color;

    Terrain(char displayChar, String color) {
        this.displayChar = displayChar;
        this.color = color;
    }

    public char getDisplayChar() {
        return displayChar;
    }

    public String getAbbreviation() {
        return String.valueOf(displayChar);
    }

    public String getColor() {
        return color;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Terrain> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Terrain terrain) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Terrain> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Terrain> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Terrain get(int index) {
        return null;
    }

    @Override
    public Terrain set(int index, Terrain element) {
        return null;
    }

    @Override
    public void add(int index, Terrain element) {

    }

    @Override
    public Terrain remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Terrain> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Terrain> listIterator(int index) {
        return null;
    }

    @Override
    public List<Terrain> subList(int fromIndex, int toIndex) {
        return null;
    }
}
