public interface CustomList<T extends Comparable<T>> {
    void add(T el);
    boolean delete(T el);
    void sort();
}
