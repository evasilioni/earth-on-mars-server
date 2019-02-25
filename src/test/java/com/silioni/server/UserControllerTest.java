package com.silioni.server;

import com.silionie.server.jwt.security.service.AuthenticationRequest;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserControllerTest extends IntegrationTest{

    @Test
    public void test_authentication() {
        // GIVEN
        AuthenticationRequest request = new AuthenticationRequest();
        request.setUsername("admin");
        request.setPassword("P@ssword1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AuthenticationRequest> httpEntity = new HttpEntity<>(request, headers);

        // WHEN
        ResponseEntity<String> exchange = restTemplate.exchange(
                "http://localhost:" + apiPort + "/signin",
                HttpMethod.POST,
                httpEntity,
                String.class);

        // THEN
        assertTrue(exchange.getBody().contains("token"));
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
    }

    @Test
    public void test_authentication_badcredentials() {
        // GIVEN
        AuthenticationRequest request = new AuthenticationRequest();
        request.setUsername("admin");
        request.setPassword("P@sswo");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AuthenticationRequest> httpEntity = new HttpEntity<>(request, headers);

        try{
            restTemplate.exchange(
                    "http://localhost:" + apiPort + "/signin",
                    HttpMethod.POST,
                    httpEntity,
                    String.class);
        } catch (HttpClientErrorException ex){
            System.out.println(ex);
            assertEquals(HttpStatus.UNAUTHORIZED, ex.getStatusCode());
        }


    }

}
