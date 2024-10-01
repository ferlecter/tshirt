package br.com.tshirt.service;

import br.com.tshirt.dao.request.SignUpRequest;
import br.com.tshirt.dao.request.SigninRequest;
import br.com.tshirt.dao.response.JwtAuthenticationResponse;
import br.com.tshirt.service.Exception.BusinessException;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request) throws BusinessException;

    JwtAuthenticationResponse signin(SigninRequest request);

}
