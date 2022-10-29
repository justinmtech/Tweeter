package TwitterClone.user;

import TwitterClone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Feed {
    private final User user;
    private List<Tweet> tweets;

    public Feed(UserService userService) {
            this.user = userService.getCurrentAuthenticatedUser();
            this.tweets = new LinkedList<>();
            this.tweets = getOrderedTweets();
    }

    private List<Tweet> getOrderedTweets() {
        tweets.addAll(user.getTweets());
        if (user.getFollowing().size() > 0) {
        for (int i = 0; i < user.getFollowing().size(); i++) {
            tweets.addAll(user.getFollowing().get(i).getTweets());
        }
    }
        Collections.sort(tweets);
        return tweets;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }
}
