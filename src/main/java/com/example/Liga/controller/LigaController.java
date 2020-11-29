package com.example.Liga.controller;

import com.example.Liga.dto.PlayerDto;
import com.example.Liga.dto.TeamDto;
import com.example.Liga.model.Player;
import com.example.Liga.repository.PlayerRepository;
import com.example.Liga.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class LigaController {


@Autowired
    PlayerRepository playerRepository;

@RequestMapping("/players")
    public List<Map<String, Object>> getAllPlayers(){
    PlayerDto playerDto = new PlayerDto();
    return playerRepository.findAll()
            .stream()
            .map(player -> playerDto.makePlayerDto(player))
            .collect(Collectors.toList());
}


@Autowired
    TeamRepository teamRepository;

@RequestMapping("/teams")
    public List<Map<String, Object>> getAllTeams(){
    TeamDto teamDto = new TeamDto();
    return teamRepository.findAll()
            .stream()
            .map(team -> teamDto.makeTeamDto(team))
            .collect(Collectors.toList());
}





}
