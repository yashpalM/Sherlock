package com.singhajit.sherlock.core.investigation;

import java.text.SimpleDateFormat;

public class CrashViewModel {
  private Crash crash;

  public CrashViewModel() {
  }

  public CrashViewModel(Crash crash) {
    this.crash = crash;
  }

  public String getPlace() {
    String[] placeTrail = crash.getPlace().split("\\.");
    return placeTrail[placeTrail.length - 1];
  }

  public String getExactLocationOfCrash() {
    return crash.getPlace();
  }

  public String getReasonOfCrash() {
    return crash.getReason();
  }

  public String getStackTrace() {
    return crash.getStackTrace();
  }

  public String getCrashInfo() {
    StringBuilder crashInfo = new StringBuilder();
    crashInfo.append("Device Info:\n");

    crashInfo.append("Name: ");
    crashInfo.append(getDeviceName() + "\n");

    crashInfo.append("Brand: ");
    crashInfo.append(getDeviceBrand() + "\n");

    crashInfo.append("Android API: ");
    crashInfo.append(getDeviceAndroidApiVersion() + "\n\n");

    crashInfo.append("App Info:\n");
    crashInfo.append("Version: ");
    crashInfo.append(getAppInfo().getVersion() + "\n");

    crashInfo.append("Details: ");
    crashInfo.append(getAppInfo().getDetails() + "\n\n");

    crashInfo.append("StackTrace:\n");
    crashInfo.append(getStackTrace() + "\n");

    return crashInfo.toString();
  }

  public String getDeviceManufacturer() {
    return crash.getDeviceInfo().getManufacturer();
  }

  public String getDeviceName() {
    return crash.getDeviceInfo().getName();
  }

  public String getDeviceAndroidApiVersion() {
    return crash.getDeviceInfo().getSdk();
  }

  public String getDeviceBrand() {
    return crash.getDeviceInfo().getBrand();
  }

  public AppInfo getAppInfo() {
    return crash.getAppInfo();
  }

  public int getIdentifier() {
    return crash.getId();
  }

  public String getDate() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a EEE, MMM d, yyyy");
    return simpleDateFormat.format(crash.getDate());
  }

  public void populate(Crash crash) {
    this.crash = crash;
  }
}
