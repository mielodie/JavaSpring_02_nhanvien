package com.example.jpa_02_nhanvien.repository;

import com.example.jpa_02_nhanvien.entity.NhanVien;
import com.example.jpa_02_nhanvien.entity.PhanCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {
//    @Query("SELECT c FROM NhanVien c where c.nhanVienID = :uid");
//    List<NhanVien> list(@Param("uid") Integer id);
}
