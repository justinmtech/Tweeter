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

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User getCurrentAuthenticatedUser() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return getAllUsers().stream().filter(u -> u.getUsername().equals(username)).findFirst().orElseThrow(NullPointerException::new);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
