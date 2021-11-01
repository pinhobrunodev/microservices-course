package com.pinhobrunodev.hrworker.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pinhobrunodev.hrworker.dto.WorkerDTO;
import com.pinhobrunodev.hrworker.entities.Worker;
import com.pinhobrunodev.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository repository;

	@Transactional(readOnly = true)
	public List<WorkerDTO> findAll() {
		return repository.findAll().stream().map(WorkerDTO::new).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public WorkerDTO findById(Long id) {
		Worker obj = repository.findById(id).get();
		return new WorkerDTO(obj);
	}

}
