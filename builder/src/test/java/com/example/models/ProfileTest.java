package com.example.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ProfileTest {

  @Test
  public void testProfileCreation() {
    User user = User.builder()
        .id("123e4567-e89b-12d3-a456-556642440000")
        .email("test@example.com")
        .password("password123")
        .build();

    Profile profile = Profile.builder()
        .id("123e4567-e89b-12d3-a456-556642440001")
        .user(user)
        .name("John Doe")
        .avatar("avatar.jpg")
        .build();

    assertNotNull(profile);
    assertEquals("123e4567-e89b-12d3-a456-556642440001", profile.getId());
    assertEquals(user, profile.getUser());
    assertEquals("John Doe", profile.getName());
    assertEquals("avatar.jpg", profile.getAvatar());
  }

  @Test
  public void testInvalidId() {
    assertThrows(IllegalArgumentException.class, () -> {
      Profile.builder()
          .id("invalid-id")
          .user(null)
          .name("John Doe")
          .avatar("avatar.jpg")
          .build();
    });
  }

  @Test
  public void testInvalidName() {
    assertThrows(IllegalArgumentException.class, () -> {
      Profile.builder()
          .id("123e4567-e89b-12d3-a456-556642440001")
          .user(null)
          .name("")
          .avatar("avatar.jpg")
          .build();
    });
  }
}