package com.example.demo.device;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import jakarta.validation.constraints.DecimalMin;

@Entity
@Table(name="device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "device_sequence")
    @SequenceGenerator(name = "device_sequence", sequenceName = "device_sequence", allocationSize = 1)
    private Long id;

    @NotNull
    @Min(100)
    @JsonProperty("battery_power")
    private int batteryPower;

    @NotNull
    @JsonProperty("blue")
    private boolean blue;

    @NotNull
    @DecimalMin("0.1")
    @DecimalMax("10.0")
    @JsonProperty("clock_speed")
    private double clockSpeed;

    @NotNull
    @JsonProperty("dual_sim")
    private boolean dualSim;

    @NotNull
    @Min(0)
    @JsonProperty("fc")
    private int fc;

    @NotNull
    @JsonProperty("four_g")
    private boolean fourG;

    @NotNull
    @Min(1)
    @JsonProperty("int_memory")
    private int intMemory;

    @NotNull
    @DecimalMin("0.1")
    @JsonProperty("m_dep")
    private double mDep;

    @NotNull
    @DecimalMin("0.1")
    @JsonProperty("mobile_wt")
    private double mobileWt;

    @NotNull
    @Min(1)
    @JsonProperty("n_cores")
    private int nCores;

    @NotNull
    @Min(1)
    @JsonProperty("pc")
    private int pc;

    @NotNull
    @PositiveOrZero
    @JsonProperty("px_height")
    private int pxHeight;

    @NotNull
    @PositiveOrZero
    @JsonProperty("px_width")
    private int pxWidth;

    @NotNull
    @Min(100)
    @JsonProperty("ram")
    private int ram;

    @NotNull
    @DecimalMin("0.1")
    @JsonProperty("sc_h")
    private double scH;

    @NotNull
    @DecimalMin("0.1")
    @JsonProperty("sc_w")
    private double scW;

    @NotNull
    @Positive
    @JsonProperty("talk_time")
    private int talkTime;

    @NotNull
    @JsonProperty("three_g")
    private boolean threeG;

    @NotNull
    @JsonProperty("touch_screen")
    private boolean touchScreen;

    @NotNull
    @JsonProperty("wifi")
    private boolean wifi;

    @Nullable
    @Min(0)
    @Max(3)
    private Integer priceRange;


    public Device() {}

    // All attributes constructor
    public Device(Long id, int batteryPower, boolean blue, double clockSpeed, boolean dualSim, int fc, boolean fourG, int intMemory, double mDep, double mobileWt, int nCores, int pc, int pxHeight, int pxWidth, int ram, double scH, double scW, int talkTime, boolean threeG, boolean touchScreen, boolean wifi, int priceRange) {
        this.id = id;
        this.batteryPower = batteryPower;
        this.blue = blue;
        this.clockSpeed = clockSpeed;
        this.dualSim = dualSim;
        this.fc = fc;
        this.fourG = fourG;
        this.intMemory = intMemory;
        this.mDep = mDep;
        this.mobileWt = mobileWt;
        this.nCores = nCores;
        this.pc = pc;
        this.pxHeight = pxHeight;
        this.pxWidth = pxWidth;
        this.ram = ram;
        this.scH = scH;
        this.scW = scW;
        this.talkTime = talkTime;
        this.threeG = threeG;
        this.touchScreen = touchScreen;
        this.wifi = wifi;
        this.priceRange = priceRange;
    }

    // No price range constructor
    public Device(Long id, int batteryPower, boolean blue, double clockSpeed, boolean dualSim, int fc, boolean fourG, int intMemory, double mDep, double mobileWt, int nCores, int pc, int pxHeight, int pxWidth, int ram, double scH, double scW, int talkTime, boolean threeG, boolean touchScreen, boolean wifi) {
        this.id = id;
        this.batteryPower = batteryPower;
        this.blue = blue;
        this.clockSpeed = clockSpeed;
        this.dualSim = dualSim;
        this.fc = fc;
        this.fourG = fourG;
        this.intMemory = intMemory;
        this.mDep = mDep;
        this.mobileWt = mobileWt;
        this.nCores = nCores;
        this.pc = pc;
        this.pxHeight = pxHeight;
        this.pxWidth = pxWidth;
        this.ram = ram;
        this.scH = scH;
        this.scW = scW;
        this.talkTime = talkTime;
        this.threeG = threeG;
        this.touchScreen = touchScreen;
        this.wifi = wifi;
    }

    // No Id and price range constructor
    public Device(int batteryPower, boolean blue, double clockSpeed, boolean dualSim, int fc, boolean fourG, int intMemory, double mDep, double mobileWt, int nCores, int pc, int pxHeight, int pxWidth, int ram, double scH, double scW, int talkTime, boolean threeG, boolean touchScreen, boolean wifi) {
        this.batteryPower = batteryPower;
        this.blue = blue;
        this.clockSpeed = clockSpeed;
        this.dualSim = dualSim;
        this.fc = fc;
        this.fourG = fourG;
        this.intMemory = intMemory;
        this.mDep = mDep;
        this.mobileWt = mobileWt;
        this.nCores = nCores;
        this.pc = pc;
        this.pxHeight = pxHeight;
        this.pxWidth = pxWidth;
        this.ram = ram;
        this.scH = scH;
        this.scW = scW;
        this.talkTime = talkTime;
        this.threeG = threeG;
        this.touchScreen = touchScreen;
        this.wifi = wifi;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public boolean isBlue() {
        return blue;
    }

    public double getClockSpeed() {
        return clockSpeed;
    }

    public boolean isDualSim() {
        return dualSim;
    }

    public int getFc() {
        return fc;
    }

    public boolean isFourG() {
        return fourG;
    }

    public int getIntMemory() {
        return intMemory;
    }

    public double getmDep() {
        return mDep;
    }

    public double getMobileWt() {
        return mobileWt;
    }

    public int getnCores() {
        return nCores;
    }

    public int getPc() {
        return pc;
    }

    public int getPxHeight() {
        return pxHeight;
    }

    public int getPxWidth() {
        return pxWidth;
    }

    public int getRam() {
        return ram;
    }

    public double getScH() {
        return scH;
    }

    public double getScW() {
        return scW;
    }

    public int getTalkTime() {
        return talkTime;
    }

    public boolean isThreeG() {
        return threeG;
    }

    public boolean isTouchScreen() {
        return touchScreen;
    }

    public boolean isWifi() {
        return wifi;
    }

    public Integer getPriceRange() {
        return priceRange;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public void setBlue(boolean blue) {
        this.blue = blue;
    }

    public void setClockSpeed(double clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public void setDualSim(boolean dualSim) {
        this.dualSim = dualSim;
    }

    public void setFc(int fc) {
        this.fc = fc;
    }

    public void setFourG(boolean fourG) {
        this.fourG = fourG;
    }

    public void setIntMemory(int intMemory) {
        this.intMemory = intMemory;
    }

    public void setmDep(double mDep) {
        this.mDep = mDep;
    }

    public void setMobileWt(double mobileWt) {
        this.mobileWt = mobileWt;
    }

    public void setnCores(int nCores) {
        this.nCores = nCores;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public void setPxHeight(int pxHeight) {
        this.pxHeight = pxHeight;
    }

    public void setPxWidth(int pxWidth) {
        this.pxWidth = pxWidth;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setScH(double scH) {
        this.scH = scH;
    }

    public void setScW(double scW) {
        this.scW = scW;
    }

    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }

    public void setThreeG(boolean threeG) {
        this.threeG = threeG;
    }

    public void setTouchScreen(boolean touchScreen) {
        this.touchScreen = touchScreen;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public void setPriceRange(Integer priceRange) {
        this.priceRange = priceRange;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", batteryPower=" + batteryPower +
                ", blue=" + blue +
                ", clockSpeed=" + clockSpeed +
                ", dualSim=" + dualSim +
                ", fc=" + fc +
                ", fourG=" + fourG +
                ", intMemory=" + intMemory +
                ", mDep=" + mDep +
                ", mobileWt=" + mobileWt +
                ", nCores=" + nCores +
                ", pc=" + pc +
                ", pxHeight=" + pxHeight +
                ", pxWidth=" + pxWidth +
                ", ram=" + ram +
                ", scH=" + scH +
                ", scW=" + scW +
                ", talkTime=" + talkTime +
                ", threeG=" + threeG +
                ", touchScreen=" + touchScreen +
                ", wifi=" + wifi +
                ", priceRange=" + priceRange +
                '}';
    }
}