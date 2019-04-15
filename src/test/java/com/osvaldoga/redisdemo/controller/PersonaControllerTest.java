package com.osvaldoga.redisdemo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonaControllerTest {

    private RedisTemplate<String, Object> redisTemplate;

    @Mock
    private RedisConnectionFactory connectionFactoryMock;

    @Mock
    private RedisConnection redisConnectionMock;

    @Before
    public void setUp() {

        redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactoryMock);
        when(connectionFactoryMock.getConnection()).thenReturn(redisConnectionMock);

        redisTemplate.afterPropertiesSet();
    }

    @Test
    public void getPersonas() {
                Object deserialized = redisTemplate.opsForHash().entries("DASDA2");
        assertThat(deserialized, notNullValue());
    }
}