/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ats60
 */
public class StackSort<T extends Comparable<? super T>> {
    private VectorStack<T> store, temp;
    private int size;
    
    public StackSort() {
        store = new VectorStack<>();
        temp = new VectorStack<>();
        int size = 0;
    }
    
    public boolean add(T obj) { //done
        if (obj == null)
            return false;
        findStackLocation(obj);
        store.push(obj);
        size++;
        emptyTempStack();
        return true;
    }
    
    public boolean contains(T obj) { //done
        if (obj == null)
            return false;
        boolean found=false;
        
        findStackLocation(obj);
        
        while (!found && !store.empty() && store.peek().compareTo(obj) == 0) {
            if (store.peek().equals(obj))
                found = true;
            else
                temp.push(store.pop());
        }
        
        emptyTempStack();
        return found;
    }
    
    public boolean remove(T obj) { //done
        if (obj == null)
            return false;
        boolean found=false;
        
        findStackLocation(obj);
        
        while (!found && !store.empty() && store.peek().compareTo(obj) == 0) {
            if (store.peek().equals(obj)) {
                found = true;
                store.pop();
                size--;
            } else {
                temp.push(store.pop());
            }
        }
        
        emptyTempStack();
        return found;
    }
    
    public Object[] toArray() { //done
        Object [] retArray = new Object[size];
        int i = 0;
        while(!store.empty()) {
            temp.push(store.peek());
            retArray[i] = store.pop();
            i++;
        }
        emptyTempStack();
        return retArray;
    }
    
    public Object[] reverseToArray() {
        Object [] corArray = toArray();
        Object [] revArray = new Object[size];
        int j = size-1;
        for(int i=0; i<size; i++) {
            revArray[i] = corArray[j-i];
        }
        return revArray;
    }
    
    private void findStackLocation(T obj) {
        while(!store.empty() && store.peek().compareTo(obj) < 0) {
            temp.push(store.pop());
        }
    }
    
    private void emptyTempStack() {
        while(!temp.empty()) {
            store.push(temp.pop());
        }
    }
}
