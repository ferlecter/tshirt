package br.com.tshirt.service.impl;

import br.com.tshirt.dao.request.SignUpRequest;
import br.com.tshirt.dao.response.JwtAuthenticationResponse;
import br.com.tshirt.repository.UserRepository;
import br.com.tshirt.service.AuthenticationService;
import br.com.tshirt.service.Exception.BusinessException;
import br.com.tshirt.service.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
class AuthenticationServiceImplTest {

    @InjectMocks
    private AuthenticationService authenticationService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private JwtService jwtService;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private JwtAuthenticationResponse jwtAuthenticationResponse;
    @Mock
    private UserDetails userDetails;

    @BeforeEach
    public void setUp() {
        userRepository = mock(UserRepository.class);
        jwtService = mock(JwtServiceImpl.class);
        passwordEncoder = mock(PasswordEncoder.class);
        jwtAuthenticationResponse = mock(JwtAuthenticationResponse.class);
        authenticationService = new AuthenticationServiceImpl(userRepository, passwordEncoder, jwtService, authenticationManager);
    }

    @Test()
    void signupBusinessException() {
        authenticationService = new AuthenticationServiceImpl(userRepository, passwordEncoder, jwtService, authenticationManager);
        var signup = SignUpRequest.builder().email("email.qualquer@email.com")
                .lastName("ultimo")
                .firstName("primeiro")
                .password("123")
                .build();

        BusinessException e = assertThrows(BusinessException.class, () -> authenticationService.signup(signup));

        assertThat(e).hasMessage("Password deve ter no minino 8 caracteres.");
    }

}