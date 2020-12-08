package no.nav.security.token.support.demo.spring.rest;

import no.nav.security.token.support.core.api.ProtectedWithClaims;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@RestController
@Documented
@ProtectedWithClaims(issuer = "issuer1")
@Target(TYPE)
@Retention(RUNTIME)
@RequestMapping
public @interface ProtectedRestController {
    @AliasFor(annotation = RequestMapping.class, attribute = "value")
    String[] value() default {};
    @AliasFor(annotation = ProtectedWithClaims.class, attribute = "claimMap")
    String[] claimMap() default {"acr=Level4"};
}