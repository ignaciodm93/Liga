package com.example.Liga.repository;


import com.example.Liga.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MatchRepository extends JpaRepository<Match, Long> {




}
