/**
 * Implementation of Set using a linked chain.
 * @author sjw
 * @param <T>
 */
public class LinkedSet<T> implements Set<T> {
    private int size;
    private Node head;
    
    /**
     * Adds obj to the front of the chain, if obj is not already
     * in the set, and returns true.
     * @param obj
     * @return 
     */
    @Override
    public boolean add(T obj) {
        if (contains(obj)) {
            return false;
        }
        Node newHead = new Node(obj);
        
        newHead.setNext(head);
        link(newHead, head);
        head = newHead;
        size++;
        return true;
    }

    /**
     * Removes obj from the set, if it is contained within the set, and
     * returns true.
     * @param obj
     * @return 
     */
    @Override
    public boolean remove(T obj) {
        if(!contains(obj))
            return false;
        else if (head.getElement().equals(obj)) {
            head = head.getNext();
            link(null, head);
		} else {
            Node toRemove = getNodeContaining(obj);
            Node previous = toRemove.getPrevious();
            link(previous, toRemove.getNext());
        }
        size--;
        return true;
    }

    /**
     * Removes an arbitrary element from the chain, if there is an
     * element in the set, and returns that element.
     * @return 
     */
    @Override
    public T remove() {
        if (head == null)
            return null;
        T ret = head.getElement();
        head = head.getNext();
        link(null, head);  //head.setPrevious(null);
        size--;
        return ret;
    }

    @Override
    public boolean contains(T obj) {
        return getNodeContaining(obj) != null;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] rarr = new Object[size];
        Node current = head;
        for (int i = 0; i < size; i++) {
            rarr[i] = current.getElement();
            current = current.getNext();
        }
        return rarr;
    }
    
    private Node getNodeBefore(T obj) {
        Node n = getNodeContaining(obj);
        return n != null ?n.getPrevious(): null;
    }
    
    private Node getNodeContaining(T obj) {
        return getNodeContaining(obj, head);
    }
    
    private Node getNodeContaining(T obj, Node n){
		if (n == null)
			return null;
		else if (n.getElement().equals(obj))
			return n;
		else
			return getNodeContaining(obj, n.getNext());
	}
    
	private void link(Node previous, Node next) {
        if (previous != null)
            previous.setNext(next);
        if (next != null)
            next.setPrevious(previous);
    }
    
    private class Node {
        private T element;
        private Node next;
        private Node previous;

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
        
        public Node getPrevious() {
            return previous;
	}
		
	public void setPrevious(Node previous) {
            this.previous = previous;
	}
		
		
    }
}
