package com.example.Liga.controller;

import com.example.Liga.dto.MatchDto;
import com.example.Liga.dto.PlayerDto;
import com.example.Liga.dto.TeamDto;
import com.example.Liga.model.Match;
import com.example.Liga.model.Player;
import com.example.Liga.model.Team;
import com.example.Liga.repository.LigaRepository;
import com.example.Liga.repository.MatchRepository;
import com.example.Liga.repository.PlayerRepository;
import com.example.Liga.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class LigaController {


    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    //Get
    @RequestMapping("/players")
    public List<Map<String, Object>> getAllPlayers() {
        PlayerDto playerDto = new PlayerDto();
        return playerRepository.findAll()
                .stream()
                .map(player -> playerDto.makePlayerDto(player))
                .collect(Collectors.toList());
    }


    //Get
    @RequestMapping("/teams")
    public List<Map<String, Object>> getAllTeams() {
        TeamDto teamDto = new TeamDto();
        return teamRepository.findAll()
                .stream()
                .map(team -> teamDto.makeTeamDto(team))
                .collect(Collectors.toList());
    }

    //Get
    @RequestMapping("/players/{id}")
    public Map<String, Object> getPlayerInfo(@PathVariable Long id) {
        Map<String, Object> dtoPlayer = new HashMap<>();
        PlayerDto playerDto = new PlayerDto();
        Player player = playerRepository.findById(id).get();

        return playerDto.makePlayerDto(player);
    }

    //Get
    @RequestMapping("/teams/{id}")
    public Map<String, Object> getTeamInfo(@PathVariable Long id){
        Map<String, Object> dtoTeam = new HashMap<>();
        TeamDto teamDto = new TeamDto();

        return teamDto.makeTeamDto(teamRepository.findById(id).get());
    }


    //Post test
    @RequestMapping(value = "/teams", method = RequestMethod.POST)
    public void saveNewTeam(@RequestBody Team team){

        //teamRepository.save(team);
        System.out.println("team saved");
    }


    @Autowired
    LigaRepository ligaRepository;

    @RequestMapping("/liga/{id}")
    public Map<String, Object> getLigaInfo(@PathVariable Long id) {
        Map<String, Object> dtoLiga = new HashMap<>();
        TeamDto teamDto = new TeamDto();
        List<Team> teams = teamRepository.findAll();

        MatchDto matchDto = new MatchDto();
        //dtoLiga.put("teams", teams.stream().map(s -> teamDto.makeTeamDto(s)).collect(Collectors.toList()));
        dtoLiga.put("teams", teams.stream().map(s -> s.getName()));
        dtoLiga.put("matches", ligaRepository.findById(id).get().getMatches().stream().map(m -> matchDto.makeMatchDto(m)).collect(Collectors.toList()));

        return dtoLiga;
    }


    @Autowired
    MatchRepository matchRepository;

    /*@RequestMapping("/matches/{id}")
    public Map<String, Object> getMatch(@PathVariable Long id){
        Map<String, Object> match = new HashMap<>();

        match = matchRepository.findById(id).

    }*/

    @RequestMapping("/matches/{id}")
    public Match getMatch(@PathVariable Long id){
        return matchRepository.findById(id).get();
    }

    @RequestMapping("/matches")
    public List<Map<String, Object>> getMatches(){
        MatchDto matchDto = new MatchDto();
        return matchRepository.findAll()
                .stream()
                .map(m -> matchDto.makeMatchDto(m)).collect(Collectors.toList());
    }


    

    @RequestMapping("/gitTest")
    public Team getTeam(){
        Team newTeam = new Team();
        return newTeam;
    }



}