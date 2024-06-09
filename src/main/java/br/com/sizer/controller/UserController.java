package br.com.sizer.controller;

// import br.com.sizer.dto.LoginUserDto;
import br.com.sizer.model.User;
import br.com.sizer.service.UserService;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserController {
    public UserController(UserService userService) {
    }

    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        return ResponseEntity.ok(currentUser);
    }

    // @GetMapping("/")
    // public ResponseEntity<List<User>> findAll() {
    // List<User> users = userService.findAll();

    // return ResponseEntity.ok(users);
    // }
}
