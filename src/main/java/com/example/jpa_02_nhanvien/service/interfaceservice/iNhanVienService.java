package com.example.jpa_02_nhanvien.service.interfaceservice;

import com.example.jpa_02_nhanvien.payload.dto.DuAnDTO;
import com.example.jpa_02_nhanvien.payload.dto.NhanVienDTO;
import com.example.jpa_02_nhanvien.payload.request.DuAnRequest;
import com.example.jpa_02_nhanvien.payload.request.NhanVienRequest;
import com.example.jpa_02_nhanvien.payload.response.ResponseObject;

import java.util.List;

public interface iNhanVienService {
    public ResponseObject<NhanVienDTO> themNhanVien(int duAnID, int soGioLam, NhanVienRequest request);

    public ResponseObject<DuAnDTO> suaDuAn(int duAnID, DuAnRequest request);

    public ResponseObject<NhanVienDTO> xoaNhanVien(int nhanVienID);

    public List<String> tinhLuongNhanVien();
}
