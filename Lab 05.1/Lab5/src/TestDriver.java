/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ats60
 */
public class TestDriver {
    public static void main(String [] args){
        StackSort<Integer> stack = new StackSort<>();
        stack.add(1);
        stack.add(0);
        stack.add(-10);
        stack.add(-5);
        stack.add(5);
        stack.add(7);
        stack.add(11);
        stack.add(11);
        stack.add(10);
        System.out.println("should be false: " + stack.remove(18));
        System.out.println("should be true: " + stack.remove(-10));
        
        for (Object i: stack.toArray()) {
            System.out.print(i+ " ");
        }
        System.out.println();
        for (Object i: stack.reverseToArray()) {
           
            System.out.print(i+ " ");
        }
        System.out.println();
        for (Object i: stack.toArray()) {
            System.out.print(i+ " ");
        }
    }
}
