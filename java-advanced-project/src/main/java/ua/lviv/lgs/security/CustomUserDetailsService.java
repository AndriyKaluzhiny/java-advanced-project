package ua.lviv.lgs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.dao.UserRoleRepository;
import ua.lviv.lgs.domain.User;

import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;


    @Autowired
    public CustomUserDetailsService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);

        if(user.isPresent()) {
            List<String> userRoles = userRoleRepository.findRoleByUserName(username);
            return new CustomUserDetails(user.get(), userRoles);
        } else {
            throw new UsernameNotFoundException("username " + user.get().getEmail() + "not found!");
        }
    }
}
