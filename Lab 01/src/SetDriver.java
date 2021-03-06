public class SetDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Creating set of Integers...");
        Set<Integer> s = new LinkedSet<>();
        System.out.println("Adding values to set...");
        s.add(42);
        s.add(3);
        s.add(27);
        s.add(99);
        s.add(50);
        s.add(75);
        s.add(-1);
        s.add(32);
        System.out.println("Checking size (should be 8): " + s.size());
        System.out.println("Checking contents of set (should be [42 3 27 99 50 75 -1 32] in no particular order): ");
        for (Object i : s.toArray())
            System.out.print(i + " ");
        System.out.println();
        System.out.println("Testing remove of -3 (should return false): " + s.remove(-3));
        System.out.println("Checking size (should be 8): " + s.size());
        System.out.println("Checking contains of -3 (should return false): " + s.contains(-3));
        System.out.println("Checking contains of 42 (should return true): " + s.contains(42));
        System.out.println("Checking contains of 99 (should return true): " + s.contains(99));
        System.out.println("Checking contains of 32 (should return true): " + s.contains(32));
        
        System.out.println("Testing remove of 99 (should return true): " + s.remove(99));
        System.out.println("Checking size (should be 7): " + s.size());
        System.out.println("Checking contains of 99 (should return false): " + s.contains(99));
        System.out.println("Testing remove of 99 (should return false): " + s.remove(99));
        System.out.println("Checking size (should be 7): " + s.size());
        System.out.println("Testing remove of 42 (should return true): " + s.remove(42));
        System.out.println("Checking size (should be 6): " + s.size());
        System.out.println("Checking contains of 42 (should return false): " + s.contains(42));
        System.out.println("Testing remove of 32 (should return true): " + s.remove(32));
        System.out.println("Checking size (should be 5): " + s.size());
        System.out.println("Checking contains of 32 (should return false): " + s.contains(32));
        System.out.println("Checking contents of set (should be [3 27 50 75 -1] in no particular order): ");
        for (Object i : s.toArray())
            System.out.print(i + " ");
        System.out.println();
        System.out.println("Testing clear...");
        s.clear();
        System.out.println("Checking size (should be 0): " + s.size());
        System.out.println("That's enough for now. Goodbye!");
    }
    
}
