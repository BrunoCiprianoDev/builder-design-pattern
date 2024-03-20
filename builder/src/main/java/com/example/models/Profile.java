package com.example.models;

public class Profile {

  private String id;
  private User user;
  private String name;
  private String avatar;

  private Profile() {
  }

  public static ProfileBuilder builder() {
    return new ProfileBuilder(new Profile());
  }

  public static class ProfileBuilder {

    private Profile profile;

    public ProfileBuilder(Profile profile) {
      this.profile = profile;
    }

    public ProfileBuilder id(String id) {
      if (!id.matches("[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}")) {
        throw new IllegalArgumentException("ID must be a valid UUID");
      }
      this.profile.setId(id);
      return this;
    }

    public ProfileBuilder user(User user) {
      this.profile.setUser(user);
      return this;
    }

    public ProfileBuilder name(String name) {
      if (name.equals("") || name.trim() == "") {
        throw new IllegalArgumentException("Invalid name");
      }
      this.profile.setName(name);
      return this;
    }

    public ProfileBuilder avatar(String avatar) {
      this.profile.setAvatar(avatar);
      return this;
    }

    public Profile build() {
      return this.profile;
    }

  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

}
