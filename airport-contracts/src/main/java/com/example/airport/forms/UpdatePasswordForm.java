package com.example.airport.forms;

public class UpdatePasswordForm {
  private String newPassword;
  private String confirmPassword;

  public UpdatePasswordForm( String newPassword, String confirmPassword) {
    this.newPassword = newPassword;
    this.confirmPassword = confirmPassword;
  }

  protected UpdatePasswordForm() {}

  public String getNewPassword() {
    return newPassword;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }
  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

}
