package com.example.Liga.dto;


import com.example.Liga.model.Match;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchDto {

    public MatchDto() {
    }


    public Map<String, Object> makeMatchDto(Match match){

        Map<String, Object> dto = new LinkedHashMap<>();
        Map<String, Object> dtoTeams = new HashMap<>();

        try{
            dto.put("Liga", match.getLiga().getName());
        }catch (Exception ex) {
            dto.put("Liga", "empty");
        }

        dto.put("Date", match.getDate());
        dto.put("Instance", match.getInstance());
        dto.put("Teams", match.getTeams().stream().map(s -> s.getName()));

        return dto;

    }


}
