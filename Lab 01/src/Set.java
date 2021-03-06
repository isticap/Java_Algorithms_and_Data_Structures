/**
 * A Set is an unordered collection of distinct objects. This is the interface
 * for creating a Set data structure.
 *
 * @author sjw
 */
public interface Set<T> {

    /**
     * Add the object to the set.
     *
     * @param obj the object being added.
     * @return true if the add was successful, false otherwise.
     */
    public boolean add(T obj); //complete

    /**
     * Remove the object from the set.
     *
     * @param obj the object being removed.
     * @return true if the remove was successful, false otherwise.
     */
    public boolean remove(T obj); //complete
    
    /**
     * Remove an unspecified object from the set.
     * 
     * @return an object removed from the set, or null if the set is empty.
     */
    public T remove(); //complete

    /**
     * See if the object is in the set.
     *
     * @param obj the object to be checked if it is contained in the set.
     * @return true if the object is in the set, false if it is not.
     */
    public boolean contains(T obj); //complete

    /**
     * See if the set is empty.
     *
     * @return true if the set size is 0, false otherwise
     */
    public boolean isEmpty(); //complete

    /**
     * Remove all elements from the set.
     */
    public void clear(); //complete

    /**
     * Get the size of the set.
     *
     * @return Number of elements in the set.
     */
    public int size(); //complete

    /**
     * Get an array containing the elements in the set.
     *
     * @return An array containing the elements in the set.
     */
    public Object[] toArray(); //complete
}
