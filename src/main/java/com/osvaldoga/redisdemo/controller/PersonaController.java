package com.osvaldoga.redisdemo.controller;

import com.osvaldoga.redisdemo.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    private static final String REDIS_PERSONA_KEY = "PERSONA";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/personas")
    public ResponseEntity<String> crear(@RequestBody Persona persona) {
        redisTemplate.opsForHash().put(REDIS_PERSONA_KEY, "rut", persona.toString());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/personas")
    public ResponseEntity<Object> getPersonas() {
        return new ResponseEntity<Object>(redisTemplate.opsForHash().entries(REDIS_PERSONA_KEY), HttpStatus.OK);
    }
}
