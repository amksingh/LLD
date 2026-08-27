package domain;

public class Split {
    private  int id;
    private User user;
    private int amount;

    public Split(int id, User user, int amount) {
        this.id = id;
        this.user = user;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public int getAmount() {
        return amount;
    }
}
