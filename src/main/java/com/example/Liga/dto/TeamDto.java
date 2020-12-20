package com.example.Liga.dto;


import com.example.Liga.model.Team;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TeamDto {

    public TeamDto(){
        //Map<String, Object> dto = new LinkedHashMap<>(); no hace falta
    }

    public Map<String, Object> makeTeamDto(Team team){
      Map<String, Object> dto = new LinkedHashMap<>();
      PlayerDto playerDto = new PlayerDto();
      dto.put("name", team.getName());
      dto.put("creation date", team.getCreationDate());
      dto.put("total titles", team.getCups().size());
      dto.put("cups", team.getCups());
      dto.put("total players", team.getPlayers().size());
      dto.put("players", team.getPlayers().stream().map(player -> playerDto.makePlayerDto(player)).collect(Collectors.toList()));

        return dto;
    };





}
