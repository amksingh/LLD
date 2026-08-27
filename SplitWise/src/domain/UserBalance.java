package domain;

public class UserBalance {
    private int id;
    private User fromUser;
    private User toUser;
    private int amount;

    public UserBalance(int id, User fromUser, User toUser, int amount) {
        this.id = id;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public User getFromUser() {
        return fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public int getAmount() {
        return amount;
    }
}
