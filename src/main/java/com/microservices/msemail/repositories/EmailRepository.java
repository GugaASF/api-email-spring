package com.microservices.msemail.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservices.msemail.entities.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long>{

	
	@Query(value = "select e from Email e where e.destinatario like :destinatario")
	public List<Email> buscaPorDestinatario(@Param("destinatario") String destinatario);

	
	public List<Email> findByDestinatario(String destinatario);
	
	
}
