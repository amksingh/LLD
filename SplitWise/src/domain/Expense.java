package domain;

import java.util.ArrayList;
import java.util.List;

public class Expense {

    private int id;
    private User paidBy;
    private List<Split> splits;
    private int amount;

    public Expense(int id, User paidBy, int amount) {
        this.id = id;
        this.paidBy = paidBy;
        this.amount = amount;
        this.splits = new ArrayList<>();
    }

    public void addSplits(Split split){
        this.splits.add(split);
    }

    public int getId() {
        return id;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public int getAmount() {
        return amount;
    }
}
