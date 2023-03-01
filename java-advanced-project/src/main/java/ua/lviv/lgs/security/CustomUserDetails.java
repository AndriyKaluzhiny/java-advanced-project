package ua.lviv.lgs.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ua.lviv.lgs.domain.Role;
import ua.lviv.lgs.domain.User;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails extends User implements UserDetails {

    List<String> roles;
    private Integer userId;
    private String userName;

    public CustomUserDetails(User user, List<String> roles){
        super(user);
        this.roles = roles;
        this.userId = user.getId();
        this.userName = user.getEmail();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String userRoles = StringUtils.collectionToCommaDelimitedString(roles);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(userRoles);
    }

    @Override
    public String getUsername() {
        return super.getEmail();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public byte[] getFile() {
        return super.getFile();
    }

    @Override
    public String getEncodedImage() {
        return super.getEncodedImage();
    }

    @Override
    public Role getRole() {
        return super.getRole();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
