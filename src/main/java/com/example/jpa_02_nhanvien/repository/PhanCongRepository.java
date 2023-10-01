package com.example.jpa_02_nhanvien.repository;

import com.example.jpa_02_nhanvien.entity.PhanCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhanCongRepository extends JpaRepository<PhanCong, Integer> {
}
