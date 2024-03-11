package edu.festu.ivankuznetsov.eventsapp.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.festu.ivankuznetsov.eventsapp.model.Role;
import edu.festu.ivankuznetsov.eventsapp.model.User;
import edu.festu.ivankuznetsov.eventsapp.repository.UserRepository;
import edu.festu.ivankuznetsov.eventsapp.security.AuthDetails;
import edu.festu.ivankuznetsov.eventsapp.security.SecurityConfig;


@Service
public class UserService implements UserDetailsService  {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {
            Optional<User> user = userRepository.findByEmail(username);
            return new AuthDetails(user.
            orElseThrow(()->new UsernameNotFoundException("User with username "+
                                                            username+
                                                            " not found!")));
        }

   public List<User> getAll(){
        return userRepository.findAll();
   }
   public User create(String email, String password){
        var user = new User();
        user.setIdUser(UUID.randomUUID());
        user.setEmail(email);
        user.setPassword(SecurityConfig.passwordEncoder().encode(password));
        user.setIsActive(true);
        user.setIsExpired(false);
        user.setIsLocked(false);
        var role = new Role();
        role.setRoleName("USER");
        user.setRole(Set.of(role));

        return userRepository.save(user);
   }
}
