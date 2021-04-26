package java8;

@FunctionalInterface
public interface Printable<T> {
    void print(T s);
}
