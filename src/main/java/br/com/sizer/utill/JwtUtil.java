// package br.com.sizer.utill;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;

// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Component;

// import br.com.sizer.model.User;
// import jakarta.annotation.PostConstruct;
// import java.security.Key;
// import java.util.Date;

// @Component
// public class JwtUtil {

// private String secretKey = "mySecretKey"; // Use uma forma mais segura para
// armazenar e gerenciar sua chave secreta
// private Key key;

// @PostConstruct
// public void init() {
// key = Keys.hmacShaKeyFor(secretKey.getBytes());
// }

// public String generateToken(User authenticatedUser) {
// return Jwts.builder()
// .setSubject(authenticatedUser.getUsername())
// .setIssuedAt(new Date())
// .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) //
// 10 horas
// .signWith(SignatureAlgorithm.HS256, key)
// .compact();
// }

// public String extractUsername(String token) {
// return extractAllClaims(token).getSubject();
// }

// public boolean isTokenExpired(String token) {
// return extractAllClaims(token).getExpiration().before(new Date());
// }

// private Claims extractAllClaims(String token) {
// return Jwts.parser()
// .setSigningKey(key)
// .parseClaimsJws(token)
// .getBody();
// }

// public boolean validateToken(String token, UserDetails userDetails) {
// final String username = extractUsername(token);
// return (username.equals(userDetails.getUsername()) &&
// !isTokenExpired(token));
// }

// }
