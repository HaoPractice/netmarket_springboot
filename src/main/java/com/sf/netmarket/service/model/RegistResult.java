package com.sf.netmarket.service.model;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class RegistResult {
  public abstract RegistResultEnum result();
  public static RegistResult create(RegistResultEnum result){
    return new AutoValue_RegistResult(result);
  }
}
