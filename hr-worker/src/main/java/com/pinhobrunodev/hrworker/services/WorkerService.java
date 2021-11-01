package com.pinhobrunodev.hrworker.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pinhobrunodev.hrworker.dto.WorkerDTO;
import com.pinhobrunodev.hrworker.entities.Worker;
import com.pinhobrunodev.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository repository;
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(WorkerService.class);

	// Captura informacoes do contexto da aplicacao
	@Autowired
	private Environment env;
	

	@Transactional(readOnly = true)
	public List<WorkerDTO> findAll() {
		return repository.findAll().stream().map(WorkerDTO::new).collect(Collectors.toList());
	}

	/*
	 * Quando fizer uma requisicao nesse servico , vai imprimir no console o numero da porta que ta rodando
	 * 
	 */
	@Transactional(readOnly = true)
	public WorkerDTO findById(Long id) {

		logger.info("PORT: "+env.getProperty("local.server.port"));
		
		Worker obj = repository.findById(id).get();
		return new WorkerDTO(obj);
	}

}
