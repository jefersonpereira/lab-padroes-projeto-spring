// package br.com.sizer.service;

// import br.com.sizer.exception.DuplicateUserNameException;
// import br.com.sizer.exception.ResourceNotFoundException;
// import br.com.sizer.model.User;
// import br.com.sizer.repository.UserRepository;
// import org.springframework.beans.factory.annotation.Autowired;

// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import
// org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Service;

// import java.util.Optional;

// @Service
// public class UserServiceImpl implements UserDetailsService, UserService {

// @Autowired
// private UserRepository userRepository;

// public void UserService(UserRepository userRepository) {
// this.userRepository = userRepository;
// }

// @Override
// public Optional<User> findOne(String email) {
// return userRepository.findByEmail(email);
// }

// @Override
// public UserDetails loadUserByUsername(String username) throws
// UsernameNotFoundException {
// User user = userRepository.findByEmail(username)
// .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
// return new UserDetailsImpl(user);
// }

// @Override
// public User create(User user) {
// if (user.getUsername() == null)
// throw new ResourceNotFoundException("Username is required", "Username",
// user.getUsername());

// if (user.getPassword() == null)
// throw new ResourceNotFoundException("Password is required", "Password",
// user.getPassword());

// Optional<User> usr = userRepository.findByEmail(user.getUsername());
// if (usr != null)
// throw new DuplicateUserNameException("Username Already exists.");

// BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
// user.setPassword(encoder.encode(user.getPassword()));
// return userRepository.save(user);
// }

// public User update(Long id, User userDetails) {
// User user =
// userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
// if (user == null) {
// throw new ResourceNotFoundException("User", "id", user);
// }

// BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
// user.setPassword(encoder.encode(userDetails.getPassword()));
// return userRepository.save(user);

// }

// public void delete(Long id) {
// User user =
// userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
// if (user == null) {
// throw new ResourceNotFoundException("User", "id", user);
// }
// userRepository.delete(user);
// }

// }
