package com.example.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class UserTest {

  @Test
  public void testUserCreation() {
    User user = User.builder()
        .id("123e4567-e89b-12d3-a456-556642440000")
        .email("test@example.com")
        .password("password123")
        .build();

    assertNotNull(user);
    assertEquals("123e4567-e89b-12d3-a456-556642440000", user.getId());
    assertEquals("test@example.com", user.getEmail());
    assertEquals("password123", user.getPassword());
  }

  @Test
  public void testInvalidId() {
    assertThrows(IllegalArgumentException.class, () -> {
      User.builder()
          .id("invalid-id")
          .email("test@example.com")
          .password("password123")
          .build();
    });
  }

  @Test
  public void testInvalidEmail() {
    assertThrows(IllegalArgumentException.class, () -> {
      User.builder()
          .id("123e4567-e89b-12d3-a456-556642440000")
          .email("invalid-email")
          .password("password123")
          .build();
    });
  }

  @Test
  public void testShortPassword() {
    assertThrows(IllegalArgumentException.class, () -> {
      User.builder()
          .id("123e4567-e89b-12d3-a456-556642440000")
          .email("test@example.com")
          .password("short")
          .build();
    });
  }
}