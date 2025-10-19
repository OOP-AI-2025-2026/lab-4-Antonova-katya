package ua.opnu;
import java.util.Objects;

public class BankingAccount {
    private int balance;

    public BankingAccount(Startup s) {
        this.balance = s.getBalance();
    }

    public void debit(Debit d) {
        if (d != null) {
            balance += d.getBalance();
        }
    }

    public void credit(Credit c) {
        if (c != null) {
            balance -= c.getBalance();
        }
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        return this == o ||
                (o != null && getClass() == o.getClass() && balance == ((BankingAccount) o).balance);
    }

    @Override
    public String toString() {
        return "BankingAccount[balance=" + balance + "]";
    }
}
