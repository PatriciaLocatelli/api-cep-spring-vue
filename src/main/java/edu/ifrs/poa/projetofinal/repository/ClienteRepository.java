package edu.ifrs.poa.projetofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ifrs.poa.projetofinal.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}