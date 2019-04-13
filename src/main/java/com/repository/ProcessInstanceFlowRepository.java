package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.ProcessInstanceFlow;

@Repository
public interface ProcessInstanceFlowRepository  extends JpaRepository<com.model.ProcessInstanceFlow, Long> {

	@Query("from ProcessInstanceFlow u "
			+ " where u.person.id = ?1")
	List<ProcessInstanceFlow> getProcessInstanceFlow(long id);
}
