package TwitterClone.controllers;

import TwitterClone.services.UserService;
import TwitterClone.user.Feed;
import TwitterClone.user.Tweet;
import TwitterClone.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class FeedController {

    @Autowired
    UserService userService;

    @GetMapping("/feed")
    public String getFeed(Model model) {
        model.addAttribute("tweet", new Tweet());
        model.addAttribute("feed", new Feed(userService));
        return "feed";
    }

    @PostMapping("/feed")
    public String postFeed(@ModelAttribute Tweet tweet, Model model) {
        model.addAttribute("tweet", tweet);
        tweet.setUser(userService.getCurrentAuthenticatedUser());
        userService.getCurrentAuthenticatedUser().getTweets().add(tweet);
        userService.saveUser(userService.getCurrentAuthenticatedUser());
        model.addAttribute("feed", new Feed(userService));
        return "feed";
    }
}
