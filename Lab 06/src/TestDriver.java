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
    public static void main(String[] args){
        Queue<Integer> q = new ArrayQueue<>(9);
        q.add(2);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        q.add(3);
        q.add(4);
        for (Object i : q.toArray()) {
            System.out.println(i);
        }
    }
}
