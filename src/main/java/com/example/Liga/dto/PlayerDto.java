package com.example.Liga.dto;


import com.example.Liga.model.Player;

import java.util.LinkedHashMap;
import java.util.Map;

public class PlayerDto {

    public PlayerDto(){
       // Map<String, Object> dto = new LinkedHashMap<>();  no hace falta
    }


    public Map<String, Object> makePlayerDto(Player player){
        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("fullname", player.getFirstName() + " " + player.getLastName());
        //dto.put("firstname", player.getFirstName());
        //dto.put("lastname", player.getLastName());
        dto.put("position", player.getPosition());
        dto.put("age", player.getAge());
        dto.put("team", player.getTeam().getName());
        //dto.put("team", player.getTeam());    este al darme el get team me provoca el loop.

        return dto;
    };



}
