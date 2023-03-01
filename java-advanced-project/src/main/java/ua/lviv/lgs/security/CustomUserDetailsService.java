package ua.lviv.lgs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.User;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOp = userRepository.findByEmail(username);

        if(userOp.isPresent()) {
            User user = userOp.get();
            return new CustomUserDetails(user, Collections.singletonList(user.getRole().toString()));
        } else {
            throw new UsernameNotFoundException("username " + username + "not found!");
        }
    }
}
