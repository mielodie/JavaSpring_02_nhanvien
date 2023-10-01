package com.example.jpa_02_nhanvien.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "duan")
public class DuAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int duAnID;
    @Column(name = "tenduan")
    private String tenDuAn;
    @Column(name = "mota")
    private String moTa;
    @Column(name = "ghichu")
    private String ghiChu;
    @OneToMany(mappedBy = "duAn")
    @JsonManagedReference
    private List<PhanCong> phanCongs;

    public int getDuAnID() {
        return duAnID;
    }

    public void setDuAnID(int duAnID) {
        this.duAnID = duAnID;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public List<PhanCong> getPhanCongs() {
        return phanCongs;
    }

    public void setPhanCongs(List<PhanCong> phanCongs) {
        this.phanCongs = phanCongs;
    }
}
