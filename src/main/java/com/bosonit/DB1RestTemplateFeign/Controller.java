package com.bosonit.DB1RestTemplateFeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    @GetMapping("/template/{idPersona}")
    ResponseEntity<Persona> getPersonaRestTemplate(@PathVariable String idPersona) {
        System.out.println("HAGO LA LLAMADA DESDE EL CONTROLLER REST TEMPLATE CON EL ID: " + idPersona);
        ResponseEntity<Persona> rs = new RestTemplate().getForEntity("http://localhost:8080/personas/" + idPersona, Persona.class);
        System.out.println("SE HA EJECUTADO LA LLAMADA, LO QUE ME DEVUELVE ES: " + rs);
        return ResponseEntity.ok(rs.getBody());
    }

    @Autowired
    IFeignClient iFeignClient;

    @GetMapping("/feign/{idPersona}")
    ResponseEntity<Persona> getPersonaFeign(@PathVariable String idPersona) {
        System.out.println("HAGO LA LLAMADA DESDE EL CONTROLLER FEIGN CON EL ID: " + idPersona);
        ResponseEntity<Persona> respuesta = iFeignClient.callPersona(idPersona);
        System.out.println("SE HA EJECUTADO EL FEIGN Y EL RESULTADO ES: " + respuesta);
        return respuesta;
    }

}
