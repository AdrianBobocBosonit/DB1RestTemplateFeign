package com.bosonit.DB1RestTemplateFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "simpleFeign", url = "http://localhost:8080/")
public interface IFeignClient {

    @GetMapping("/personas/{idPersona}")
    ResponseEntity<Persona> callPersona(@PathVariable String idPersona);

}
