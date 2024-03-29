package TwitterClone.user;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//rename table to users
@Entity(name = "users")
@Table(name = "users")
public class User {
    @Id
    private String username;
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Tweet> tweets;
    @OneToMany(cascade = CascadeType.ALL)
    private List<User> followers;
    @OneToMany(cascade = CascadeType.ALL)
    private List<User> following;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.tweets = new LinkedList<>();
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
    }

    public User() {
        this.tweets = new LinkedList<>();
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
    }

    //public int getId() {
    //    return id;
    //}

    //public void setId(int id) {
    //    this.id = id;
    //}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    @Override
    public String toString() {
        return username;
    }
}
