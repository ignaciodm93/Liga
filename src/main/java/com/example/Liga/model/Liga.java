package com.example.Liga.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Liga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String name;
    private String country;

    public Liga() {
        teams = new HashSet<>();
    }


    public Liga(String name, String country) {
        this.name = name;
        this.country = country;
    }


    @OneToMany(mappedBy = "liga", fetch = FetchType.EAGER)
    private Set<Team> teams = new HashSet<Team>();


    @OneToMany(mappedBy = "liga", fetch = FetchType.EAGER)
    private Set<Match> matches = new HashSet<Match>();

    public void addMatch(Match match){
        matches.add(match);
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public void addTeam(Team team){
        teams.add(team);
    }

    public void deleteTeam(Team team){
        teams.remove(team);
    }


}
