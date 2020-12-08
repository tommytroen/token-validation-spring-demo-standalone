package no.nav.security.token.support.demo.spring.rest;

import no.nav.security.token.support.core.api.Protected;
import no.nav.security.token.support.core.api.ProtectedWithClaims;
import no.nav.security.token.support.core.api.Unprotected;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@ProtectedRestController(value = "/demo/protectedwithclaims", claimMap = {"acr=Level4"})
@RestController
public class DemoController {

    @GetMapping("/demo/protected")
    public String protectedPath(){
        return "i am protected";
    }

    @Unprotected
    @GetMapping("/demo/unprotected")
    public String unprotectedPath(){
        return "i am unprotected";
    }

    @GetMapping
    public String protectedWithClaims(){
        return "i am protected with claims";
    }
}
