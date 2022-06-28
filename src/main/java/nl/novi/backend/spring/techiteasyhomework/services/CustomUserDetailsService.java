package nl.novi.backend.spring.techiteasyhomework.services;

import nl.novi.backend.spring.techiteasyhomework.Dtos.UserDto;
import nl.novi.backend.spring.techiteasyhomework.models.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Autowired
public class CustomUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) {
        UserService userService = null;
        UserDto userDto = userService.getUser(username);

        String password = userDto.getPassword();

        Set<Authority> authorities = userDto.getAuthorities();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority: authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }

        return new org.springframework.security.core.userdetails.User(username, password, grantedAuthorities);
    }



}
