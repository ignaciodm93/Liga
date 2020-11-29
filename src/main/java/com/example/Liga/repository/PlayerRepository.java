package com.example.Liga.repository;


import com.example.Liga.model.Player;
import com.example.Liga.model.Team;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PlayerRepository extends JpaRepository<Player, Long> {



}
