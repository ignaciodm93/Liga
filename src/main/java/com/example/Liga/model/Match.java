package com.example.Liga.model;


import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String instance;
    private Date date;

    public void setLiga(Liga liga) {
        this.liga = liga;
    }

    @OneToMany(mappedBy="match", fetch=FetchType.EAGER)
    private Set<Team> teams = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="liga_id")
    private Liga liga;

    //region Constructores
    public Match(String instance, Date date, Set<Team> teams) {
        this.instance = instance;
        this.date = date;
        this.teams = teams;

    }

    public Match(String instance, Date date) {
        this.instance = instance;
        this.date = date;
        this.teams = new HashSet<>();

    }

    public Match() {

    }
    //endregion


    public String getInstance() {
        return instance;
    }

    public Date getDate() {
        return date;
    }

    //Lo correcto seria que deuvelva tod y yo lo filtre
    /*public List<String> getTeamNames() {

        List<String> teamNames = teams.stream().map(t -> t.getName()).collect(Collectors.toList());

        return teamNames;

    }*/

    public List<Team> getTeams(){
        return this.teams.stream().collect(Collectors.toList());
    }




    public void addTeam(Team team){

        teams.add(team);
        team.setMatch(this);

    }

    public void setTeams(Team team1, Team team2) {
        this.teams.add(team1);
        this.teams.add(team2);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Liga getLiga() {
        return liga;
    }
}


