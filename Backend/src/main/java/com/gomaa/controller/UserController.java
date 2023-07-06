package com.ahmed.controller;

import com.ahmed.dto.loginResponse;
import com.ahmed.model.User;
import com.ahmed.service.AuthoriseService;
import com.ahmed.service.JwtAuthenticationFilter;
import com.ahmed.dto.JwtLogin;
import com.ahmed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping
public class UserController {

  private   JwtAuthenticationFilter jwtAuthenticationFilter;
  private UserService userService;
  private AuthoriseService authoriseService;
  private PasswordEncoder passwordEncoder;
  @Autowired
  public UserController(JwtAuthenticationFilter jwtAuthenticationFilter, UserService userService
          , AuthoriseService authoriseService, PasswordEncoder passwordEncoder) {
    this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    this.userService = userService;
    this.authoriseService = authoriseService;
    this.passwordEncoder = passwordEncoder;
  }

  /* @Autowired
      public UserController(JwtAuthenticationFilter jwtAuthenticationFilter) {
          this.jwtAuthenticationFilter = jwtAuthenticationFilter;
      }*/



  // http://localhost:8080/signin
  @PostMapping("/signin")

    public loginResponse login(@RequestBody JwtLogin jwtLogin){
      return jwtAuthenticationFilter.login(jwtLogin);
    }


  // http://localhost:8080/signup
    @PostMapping("/signup")
    public void createuser(@RequestBody JwtLogin jwtLogin){
      User user=new User();
      user.setEmail(jwtLogin.getEmail());
      user.setPassword(passwordEncoder.encode(jwtLogin.getPassword()));
      user.setActive(1);
      user.getAuthorities().add(authoriseService.getAuthorities().get(0));
      userService.adduser(user);
    }
}
