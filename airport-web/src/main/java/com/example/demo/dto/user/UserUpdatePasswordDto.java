package com.example.demo.dto.user;

public class UserUpdatePasswordDto {
  private int userId;
  private String newPassword;
  private String confirmPassword;

  public UserUpdatePasswordDto(int userId,  String newPassword, String confirmPassword) {
    this.userId = userId;
    this.newPassword = newPassword;
    this.confirmPassword = confirmPassword;
  }

  protected UserUpdatePasswordDto() {}

  public int getUserId() {
    return userId;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }
}
