/**
 * Double-ended queue, or Deque (pronounced "deck") interface. Based on the
 * Java API implementation.
 * @author Stephen J. Sarma-Weierman
 */
public interface Deque<T> extends Queue<T> {
    public boolean addFirst(T obj);
    public boolean addLast(T obj);
    public boolean offerFirst(T obj);
    public boolean offerLast(T obj);
    public T getFirst();
    public T getLast();
    public T peekFirst();
    public T peekLast();
    public T removeFirst();
    public T removeLast();
    public T pollFirst();
    public T pollLast();
    
    //Queue methods
    
    @Override
    public default boolean add(T obj) {
        return addLast(obj);
    }
    
    @Override
    public default boolean offer(T obj) {
        return offerLast(obj);
    }
    
    @Override
    public default T element() {
        return getFirst();
    }
    
    @Override
    public default T peek() {
        return peekFirst();
    }
    
    @Override
    public default T remove() {
        return removeFirst();
    }
    
    @Override
    public default T poll() {
        return pollFirst();
    }
    
    //Stack methods
    
    public default void push(T obj) {
        addFirst(obj);
    }
    
    public default T pop() {
        return removeFirst();
    }
}
