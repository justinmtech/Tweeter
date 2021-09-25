package TwitterClone.controllers;

import TwitterClone.services.UserService;
import TwitterClone.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{username}")
    public String getProfile(Model model, @PathVariable("username") String username) {
        model.addAttribute("user", userService.getUserById(username));
        model.addAttribute("doFollow", "yes");
        return "profile";
    }

    @PostMapping("/user/{username}")
    public String postProfile(@ModelAttribute String doFollow, Model model, @PathVariable("username") String username) {
        User currentUser = userService.getCurrentAuthenticatedUser();
        User profile = userService.getUserById(username);
        doFollow = "yes";
        model.addAttribute("user", userService.getUserById(username));
        model.addAttribute("doFollow", "yes");
        if (doFollow.equalsIgnoreCase("yes")) {
            profile.getFollowers().add(currentUser);
            userService.saveUser(profile);
            currentUser.getFollowing().add(profile);
            userService.saveUser(currentUser);
        }
        return "profile";
    }
}
