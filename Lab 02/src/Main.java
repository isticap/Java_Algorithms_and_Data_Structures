import java.util.Scanner;

/**
 *
 * @author ats60
 */
public class Main {

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sender, recipient;
        double amount;
        BankTransaction t1, t2;
        
        System.out.print("Enter sender ID for Transaction 1: ");
        sender = in.nextInt();
        
        System.out.print("Enter recipient ID for transaction 1: ");
        recipient = in.nextInt();
        
        System.out.print("Enter amount for transaction 1: ");
        amount = in.nextDouble();
        
        t1 = new BankTransaction(sender, recipient, amount);
        
        System.out.print("Enter sender ID for Transaction 2: ");
        sender = in.nextInt();
        
        System.out.print("Enter recipient ID for transaction 2: ");
        recipient = in.nextInt();
        
        System.out.print("Enter amount for transaction 2: ");
        amount = in.nextDouble();
        
        t2 = new BankTransaction(sender, recipient, amount);
        
        
        if (t1.compareTo(t2)==0)
            System.out.println("The transactions are equivalent.");
        else if (t1.compareTo(t2) < 0)
            System.out.println(t1.toString() + "is the smaller transaction.");
        else
            System.out.println(t2.toString() + "is the smaller transaction.");
    }
    
}
