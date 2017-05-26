package ua.goit.startupserviceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.startupserviceapp.repository.UserDBRepository;
import ua.goit.startupserviceapp.model.Role;
import ua.goit.startupserviceapp.model.UserDB;

import java.util.ArrayList;
import java.util.List;

/**
 *  Implementation of {@link UserDetailsService} interface.
 *
 *  @author Anastasiya Kravchenko
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDBRepository userDBRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserDB user= userDBRepository.findByLogin(login);
        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        for (Role role:user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.
                User(user.getLogin(),user.getPassword(),grantedAuthorities);
    }
}
