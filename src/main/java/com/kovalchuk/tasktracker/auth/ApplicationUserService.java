package com.kovalchuk.tasktracker.auth;

import com.kovalchuk.tasktracker.db.impl.UserDaoImpl;
import com.kovalchuk.tasktracker.db.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final UserDaoImpl userDaoImpl;

    @Autowired
    public ApplicationUserService(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDaoImpl.getUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(String.format("Username %s not found", username));
        }
        return new ApplicationUser(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true);
    }
}
