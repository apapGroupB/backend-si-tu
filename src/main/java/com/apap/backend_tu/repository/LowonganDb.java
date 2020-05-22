package com.apap.backend_tu.repository;

import com.apap.backend_tu.model.LowonganModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LowonganDb extends JpaRepository<LowonganModel, Long> {
    LowonganModel findById(long id);
//    LowonganModel findByUuid_user(String uuid);
}