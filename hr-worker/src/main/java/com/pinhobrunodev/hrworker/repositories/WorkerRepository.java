package com.pinhobrunodev.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinhobrunodev.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
