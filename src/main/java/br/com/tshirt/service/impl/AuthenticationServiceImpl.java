package br.com.tshirt.service.impl;

import br.com.tshirt.dao.request.SignUpRequest;
import br.com.tshirt.dao.request.SigninRequest;
import br.com.tshirt.dao.response.JwtAuthenticationResponse;
import br.com.tshirt.entities.Role;
import br.com.tshirt.entities.User;
import br.com.tshirt.repository.UserRepository;
import br.com.tshirt.service.AuthenticationService;
import br.com.tshirt.service.Exception.BusinessException;
import br.com.tshirt.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) throws BusinessException {
        if (request.getPassword().length() < 8)
            throw new BusinessException("Password deve ter no minino 8 caracteres.");
        var user = User.builder().firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            var jwt = jwtService.generateToken(user);
            return JwtAuthenticationResponse.builder().token(jwt).build();
        }
        throw new IllegalArgumentException("Invalid email or password.");
    }
}
