package TwitterClone.services;

import TwitterClone.user.CustomUserDetails;
import TwitterClone.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getAllUsers().stream().filter(u -> u.getUsername().equals(username)).findFirst().orElseThrow(NullPointerException::new);
        UserDetails userDetails = new CustomUserDetails(user.getUsername(), user.getUsername());
        return userDetails;
    }
}
