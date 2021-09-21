package TwitterClone.user;

import java.util.Date;

public class Tweet {
    private String text;
    //onetomany
    private User user;
    private Date timestamp;

    public Tweet(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public Tweet() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
