package com.apap.backend_tu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.backend_tu.model.JenisSuratModel;


@Repository
public interface JenisSuratDb extends JpaRepository<JenisSuratModel, Long>{
    JenisSuratModel findById(long id);
}