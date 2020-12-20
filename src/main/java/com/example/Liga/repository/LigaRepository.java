package com.example.Liga.repository;


import com.example.Liga.model.Liga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LigaRepository extends JpaRepository<Liga, Long> {



}
