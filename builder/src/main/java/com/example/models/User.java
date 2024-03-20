package com.example.models;

import java.util.regex.Pattern;

public class User {

  private String id;
  private String email;
  private String password;

  private User() {
  }

  public static UserBuilder builder() {
    return new UserBuilder(new User());
  }

  public static class UserBuilder {

    private User user;

    public UserBuilder(User user) {
      this.user = user;
    }

    public UserBuilder id(String id) {
      if (!id.matches("[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}")) {
        throw new IllegalArgumentException("ID must be a valid UUID");
      }
      this.user.setId(id);
      return this;
    }

    public UserBuilder email(String email) {
      if (!Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", email)) {
        throw new IllegalArgumentException("Invalid email format");
      }
      this.user.setEmail(email);
      return this;
    }

    public UserBuilder password(String password) {
      if (password.length() < 8) {
        throw new IllegalArgumentException("Password must be at least 8 characters long");
      }
      this.user.setPassword(password);
      return this;
    }

    public User build() {
      return this.user;
    }

  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", email=" + email + ", password=" + password + "]";
  }

}
