package com.springboot.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.model.Batch;

public interface BatchRepository extends JpaRepository<Batch,Long> {

}
