package TwitterClone.services;

import TwitterClone.repositories.UserRepository;
import TwitterClone.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getCurrentAuthenticatedUser() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return getUserById(username);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
