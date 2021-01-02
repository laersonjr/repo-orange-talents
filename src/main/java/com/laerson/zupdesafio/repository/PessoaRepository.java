package com.laerson.zupdesafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laerson.zupdesafio.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
