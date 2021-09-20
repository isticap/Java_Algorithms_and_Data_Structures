/**
 *
 * @author Andrew S
 */
public class LinkedSet<T> implements Set<T> {
    private int size;
    private Node head;
    
    @Override
    public boolean add(T obj) { //complete
        if (contains(obj)) {
            return false;
        }
        Node newHead = new Node(obj);
        newHead.setNext(head);
        head = newHead;
        size++;
        return true;
    }

    @Override
    public boolean remove(T obj) { //complete
        if (!contains(obj))
            return false;
        else if (head.getElement().equals(obj)) {
            head = head.getNext();
        } else {
            Node previous = getNodeBefore(obj);
            Node toRemove = previous.getNext();
            previous.setNext(toRemove.getNext());       
        }
        size--;
        return true;
    }

    @Override
    public T remove() { //complete
        if (isEmpty()){
            return null;
        }else {
           T current = head.getElement();
           head = head.getNext();
           return current;
        }
    }

    @Override
    public boolean contains(T obj) { //complete
        return getNodeContaining(obj) != null;
    }

    @Override
    public boolean isEmpty() { //complete
        return size == 0;
    }

    @Override
    public void clear() { //complete
        head = null;
        size = 0;
    }

    @Override
    public int size() { //complete
        return size;
    }

    @Override
    public Object[] toArray() { //complete
        Object [] retArray = new Object[size];
        Node current = head;
        for (int i=0; i<size; i++){
            retArray[i] = current.getElement();
            current = current.getNext();
        }
        return retArray;
    }
    
    private Node getNodeBefore(T obj) { //complete
        Node current = head;
        Node previous = null;
        boolean found = false;
        while (current != null && !found) {
            if(current.getElement().equals(obj)) {
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        return found?previous:null;
    }
    
    private Node getNodeContaining(T obj) { //complete
        Node current = head;
        while (current != null) {
            if(current.getElement().equals(obj))
                return current;
            else
                current = current.getNext();
        }
        return null;
    }
    
    private class Node { //complete
        private T element;
        private Node next;
        
        public Node(T element) {
            this.element = element;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
