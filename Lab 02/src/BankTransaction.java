
/**
 *
 * @author ats60
 */
public class BankTransaction implements Comparable<BankTransaction> {

    private int senderID;
    private int recipientID;
    private double amount;

    public BankTransaction(int senderID, int recipientID, double amount) {
        this.senderID = senderID;
        this.recipientID = recipientID;
        this.amount = amount;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getRecipientID() {
        return recipientID;
    }

    public void setRecipientID(int recipientID) {
        this.recipientID = recipientID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.senderID;
        hash = 29 * hash + this.recipientID;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.amount) ^ (Double.doubleToLongBits(this.amount) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BankTransaction other = (BankTransaction) obj;
        if (this.senderID != other.senderID) {
            return false;
        }
        if (this.recipientID != other.recipientID) {
            return false;
        }
        if (Double.doubleToLongBits(this.amount) != Double.doubleToLongBits(other.amount)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BankTransaction{" + "senderID=" + senderID + ", recipientID=" + recipientID + ", amount=" + amount + '}';
    }

    @Override
    public int compareTo(BankTransaction o) {
        if (amount < o.getAmount()) {
            return -1;
        } else if (amount == o.getAmount()) {
            return 0;
        } else {
            return 1;
        }
    }

}
