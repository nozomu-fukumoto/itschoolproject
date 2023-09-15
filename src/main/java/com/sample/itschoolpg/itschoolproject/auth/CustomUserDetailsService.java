package com.sample.itschoolpg.itschoolproject.auth;

// import java.util.Collections;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.sample.itschoolpg.itschoolproject.mapper.UserMapper;

// @Service
// public class CustomUserDetailsService implements UserDetailsService{

//   @Autowired
//   UserMapper userMapper;

//   @Override
//   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//     return userMapper.findByUsername(username)
//       .map(
//         user -> new CustomUserDetails(
//                 user.getUsername(),
//                 user.getPassword(),
//                 Collections.emptyList()
//         )
//         ).orElseThrow(
//           () -> new UsernameNotFoundException(
//             ""
//           )
//         );
//   }
// }

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sample.itschoolpg.itschoolproject.entitiy.UserEntity;
import com.sample.itschoolpg.itschoolproject.mapper.UserMapper;

@Service
public class CustomUserDetailsService implements UserDetailsService {
  
  @Autowired
  UserMapper userMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity user = userMapper.findByUsername(username);
    if(user == null) {
      throw new UsernameNotFoundException("not found : " + username);
    }
    return (new CustomUserDetails(user));
  }
}