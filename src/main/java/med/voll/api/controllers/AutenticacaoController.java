package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.domains.DTOs.DadosTokenJWT;
import med.voll.api.domains.models.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import med.voll.api.domains.DTOs.DadosAutenticacao;
import med.voll.api.configurations.authorization.TokenService;

@RestController
@RequestMapping(value = "/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<DadosTokenJWT> auth(@RequestBody @Valid DadosAutenticacao dto) {
        var authToken = new UsernamePasswordAuthenticationToken(dto.login(), dto.senha());
        var authentication = authenticationManager.authenticate(authToken);
        var jwtToken = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(jwtToken));
    }

}
