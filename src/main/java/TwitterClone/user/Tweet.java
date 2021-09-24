package TwitterClone.user;

import TwitterClone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tweet implements Comparable<Tweet> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne
    private User user;
    private String text;
    private Date timestamp;

    public Tweet() {
        this.timestamp = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int compareTo(Tweet tweet2) {
        if (timestamp.before(tweet2.timestamp)) {
            return 1;
        }

        else if (this.timestamp.after(tweet2.timestamp)) {
            return -1;
        }

        else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return user + "\n" + text + "\n" + timestamp;
    }
}
