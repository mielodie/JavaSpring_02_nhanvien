package com.example.jpa_02_nhanvien.payload.converter;

import com.example.jpa_02_nhanvien.entity.DuAn;
import com.example.jpa_02_nhanvien.entity.NhanVien;
import com.example.jpa_02_nhanvien.payload.dto.DuAnDTO;
import com.example.jpa_02_nhanvien.payload.dto.NhanVienDTO;
import com.example.jpa_02_nhanvien.payload.request.DuAnRequest;
import com.example.jpa_02_nhanvien.payload.request.NhanVienRequest;

public class NhanVienConverter {
    public NhanVienDTO entityToNhanVienDTO(NhanVien nhanVien) {
        NhanVienDTO dto = new NhanVienDTO();
        dto.setHoTen(nhanVien.getHoTen());
        dto.setDiaChi(nhanVien.getDiaChi());
        dto.setEmail(nhanVien.getEmail());
        dto.setSoDienThoai(nhanVien.getSoDienThoai());
        dto.setHeSoLuong(nhanVien.getHeSoLuong());
        return dto;
    }

    public DuAnDTO entityToDuAnDTO(DuAn duAn) {
        DuAnDTO dto = new DuAnDTO();
        dto.setTenDuAn(duAn.getTenDuAn());
        dto.setGhiChu(duAn.getGhiChu());
        dto.setMoTa(duAn.getMoTa());
        return dto;
    }

    public NhanVien themNhanVien(NhanVienRequest request) {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setHoTen(request.getHoTen());
        nhanVien.setDiaChi(request.getDiaChi());
        nhanVien.setEmail(request.getEmail());
        nhanVien.setSoDienThoai(request.getSoDienThoai());
        nhanVien.setHeSoLuong(request.getHeSoLuong());
        return nhanVien;
    }

    public DuAn suaDuAn(DuAn duAn, DuAnRequest request) {
        duAn.setTenDuAn(request.getTenDuAn());
        duAn.setGhiChu(request.getGhiChu());
        duAn.setMoTa(request.getMoTa());
        return duAn;
    }

    public NhanVienConverter() {
    }
}
