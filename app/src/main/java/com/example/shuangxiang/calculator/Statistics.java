package com.example.shuangxiang.calculator;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by lax on 2016/12/18.
 */

@Entity
public class Statistics {

    @Id
    private Long id;
    @Property(nameInDb = "TIME")
    private String time;
    @Property(nameInDb = "AD")
    private int ad;
    @Property(nameInDb = "DA")
    private int da;
    @Property(nameInDb = "TC")
    private int tc;
    @Property(nameInDb = "PT")
    private int pt;
    @Property(nameInDb = "E08X08T")
    private int e08X08T;
    @Property(nameInDb = "E08X08R")
    private int e08X08R;
    @Property(nameInDb = "E16X")
    private int e16X;
    @Property(nameInDb = "E16T")
    private int e16T;
    @Property(nameInDb = "E16R")
    private int e16R;
    @Generated(hash = 823447131)
    public Statistics(Long id, String time, int ad, int da, int tc, int pt,
            int e08X08T, int e08X08R, int e16X, int e16T, int e16R) {
        this.id = id;
        this.time = time;
        this.ad = ad;
        this.da = da;
        this.tc = tc;
        this.pt = pt;
        this.e08X08T = e08X08T;
        this.e08X08R = e08X08R;
        this.e16X = e16X;
        this.e16T = e16T;
        this.e16R = e16R;
    }
    @Generated(hash = 1975114801)
    public Statistics() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public int getAd() {
        return this.ad;
    }
    public void setAd(int ad) {
        this.ad = ad;
    }
    public int getDa() {
        return this.da;
    }
    public void setDa(int da) {
        this.da = da;
    }
    public int getTc() {
        return this.tc;
    }
    public void setTc(int tc) {
        this.tc = tc;
    }
    public int getPt() {
        return this.pt;
    }
    public void setPt(int pt) {
        this.pt = pt;
    }
    public int getE08X08T() {
        return this.e08X08T;
    }
    public void setE08X08T(int e08X08T) {
        this.e08X08T = e08X08T;
    }
    public int getE08X08R() {
        return this.e08X08R;
    }
    public void setE08X08R(int e08X08R) {
        this.e08X08R = e08X08R;
    }
    public int getE16X() {
        return this.e16X;
    }
    public void setE16X(int e16X) {
        this.e16X = e16X;
    }
    public int getE16T() {
        return this.e16T;
    }
    public void setE16T(int e16T) {
        this.e16T = e16T;
    }
    public int getE16R() {
        return this.e16R;
    }
    public void setE16R(int e16R) {
        this.e16R = e16R;
    }



}
