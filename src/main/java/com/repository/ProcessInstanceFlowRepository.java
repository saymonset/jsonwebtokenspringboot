package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessInstanceFlowRepository  extends JpaRepository<com.model.ProcessInstanceFlow, Long> {

}