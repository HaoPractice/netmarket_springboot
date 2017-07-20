package com.sf.netmarket.service.model;

import javax.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LoginResult {
  @Nullable public abstract String authorizeCode();
  public abstract LoginResultEnum result();
  public static Builder builder(){
    return new AutoValue_LoginResult.Builder();
  }
  @AutoValue.Builder
  public static abstract class Builder{
    abstract Builder setAuthorizeCode(String authorizeCode);
    abstract Builder setResult(LoginResultEnum loginResultEnum);
    abstract LoginResult build();
  }
}
