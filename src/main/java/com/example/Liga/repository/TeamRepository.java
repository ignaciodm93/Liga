package com.example.Liga.repository;

import com.example.Liga.model.Player;
import com.example.Liga.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource
public interface TeamRepository extends JpaRepository<Team, Long> {

    //void addPlayer(Player player);



}
