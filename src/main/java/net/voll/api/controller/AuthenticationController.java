package net.voll.api.controller;

import jakarta.validation.Valid;
import net.voll.api.dto.AuthenticationDataDTO;
import net.voll.api.dto.JwtTokenDTO;
import net.voll.api.entity.User;
import net.voll.api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody @Valid AuthenticationDataDTO authenticationDataDTO) {
        var token = new UsernamePasswordAuthenticationToken(authenticationDataDTO.username(), authenticationDataDTO.password());
        var authentication = authenticationManager.authenticate(token);
        var jwtToken = tokenService.create((User) authentication.getPrincipal());
        return ResponseEntity.ok(new JwtTokenDTO(jwtToken));
    }
}
