


package com.vanavihari.users;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.vanavihari.config.CustomUser;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

	
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

//    @PostMapping("/signup")
//    public String saveUser(@RequestBody User user, HttpServletRequest request) {
//        String url = request.getRequestURL().toString();
//        url = url.replace(request.getServletPath(), "");
//
//        User savedUser = userService.saveUser(user, url);
//
//        if (savedUser != null) {
//            return "Register successfully";
//        } else {
//            return "Something went wrong on the server";
//        }
//    }
    
    @PostMapping("/signup")
    public ResponseEntity<Object> saveUser(@RequestBody User user, HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        url = url.replace(request.getServletPath(), "");

        User savedUser = userService.saveUser(user, url);

        if (savedUser != null) {
            return ResponseEntity.ok().body(
                Map.of("success", true, "message", "User registration successful")
            );
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("success", false, "message", "Failed to register user"));
        }
    }

//    
//    @PostMapping("/login")
//    public String loginUser(@RequestBody CustomUser user) {
//        User existingUser = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
//        System.out.println(existingUser);
//
//        if (existingUser != null) {
//            return "Login successful";
//        } else {
//            return "Invalid email or password";
//        }
//    }

    @GetMapping("/verify")
    public String verifyAccount(@RequestParam("code") String code) {
        boolean isVerified = userService.verifyAccount(code);

        if (isVerified) {
            return "Successfully your account is verified";
        } else {
            return "Either your verification code is incorrect or already verified";
        }
    }
    
    
    


    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody CustomUser user) {
        // Find the user in the database by username
        User existingUser = userRepo.findByEmail(user.getUsername());
        System.out.println(existingUser);

        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    
    
    
}
