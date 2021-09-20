import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * READ THIS CAREFULLY:
 * Your task is to implement ArrayDeque. the index head and tail should point to
 * the first value and the last value in the Deque. This is NOT like the implementation
 * of ArrayQueue, where back pointed to the first free value after the last value in the
 * queue.
 * In other words, DO NOT JUST COPY ARRAYQUEUE. IT WON'T WORK.
 * The add methods are included for you. Implement all missing methods.
 */

/**
 *
 * @author sjw
 */
public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private int head, tail, size;
    private Object[] deque;
    public static final int DEFAULT_CAPACITY = 16;

    public ArrayDeque() {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayDeque(int initialCapacity) {
        deque = new Object[initialCapacity];
        tail = -1;
    }
    
    @Override
    public boolean addFirst(T obj) {
        if (atCapacity()) {
            resize(2 * deque.length);
        }
        if (isEmpty()) {
            head = tail = 0;
        } else {
            head = (deque.length + head - 1) % deque.length;
        }
        deque[head] = obj;
        size++;
        return true;
    }

    @Override
    public boolean addLast(T obj) {
        if (atCapacity()) {
            resize(2 * deque.length);
        }
        if (isEmpty()) {
            head = tail = 0;
        } else {
            tail = (tail + 1) % deque.length;
        }
        deque[tail] = obj;
        size++;
        return true;
    }

    @Override
    public boolean offerFirst(T obj) {
         try {
            addFirst(obj);
        } catch (IllegalStateException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean offerLast(T obj) {
         try {
            addLast(obj);
        } catch (IllegalStateException e) {
            return false;
        }
        return true;
    }

    @Override
    public T getFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Empty deque.");
        return (T)deque[head];
    }

    @Override
    public T getLast() {
        if (isEmpty())
            throw new NoSuchElementException("Empty deque.");
        return (T)deque[tail];
    }

    @Override
    public T peekFirst() {
        try {
            return getFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public T peekLast() {
        try {
            return getLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public T removeFirst() {
        T obj = element();
        deque[head] = null;
        head = (head + 1) % deque.length;
        size--;
        return obj;
    }

    @Override
    public T removeLast() {
        T obj = element();
        deque[tail] = null;
        tail = (tail + 1) % deque.length;
        size--;
        return obj;
    }

    @Override
    public T pollFirst() {
        try {
            return removeFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public T pollLast() {
        try {
            return removeLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
    @Override
    public void clear() {
        head = tail = size = 0;
        deque = new Object[deque.length];
    }

    @Override
    public boolean contains(T obj) {
        for (int i = 0; i < size; i++) {
            int index = (head + i) % deque.length;
            if(deque[index] == null && obj==null){
                return true;
            } else if (deque[index] != null && deque[index].equals(obj)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] rarr = new Object[size];
        for (int i=0; i < size; i++) {
            int index = (head + i) % deque.length;
            rarr[i] = deque[index];
        }
        return rarr;
    }
    
    private boolean atCapacity() {
        return size == deque.length;
    }
    
    private void resize(int newCapacity) {
        Object [] temp = new Object[newCapacity];
        for (int i = 0; i < size; i++){
            int index = (head+i) % deque.length;
            temp[i] = deque[index];
        }
        head = 0;
        tail = size-1;
        deque=temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int current = head;
            int counter = 0;
            
            @Override
            public boolean hasNext() {
                return counter<size;
            }
            
            @Override
            public T next() {
                if (hasNext()) {
			T obj = (T)deque[current];
			current = (current+1) % deque.length;
			counter++;
			return obj;
		} else {
			throw new NoSuchElementException();
		}
            }
        };
    }
}
