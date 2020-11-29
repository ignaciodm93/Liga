package com.example.Liga.model;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private Eposition position;

    public enum Eposition{
        GoalKeeper,
        Defense,
        Midfielder,
        Striker
    }



    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="team_Id")
    private Team team;


    //region Constructores
    public Player() {
    }

    public Player(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Player(String firstName, String lastName, int age, Team team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.team = team;
    }

    public Player(String firstName, String lastName, int age, Eposition position  , Team team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.position = position;
        this.team = team;
    }
    //endregion

    //region Getters & Setters
    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Team getTeam() {
        return team;
    }

    //explicit name string
    public String getTeamName(){
        return team.getName();
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setPosition(Eposition position) {
        this.position = position;
    }

    public Eposition getPosition() {
        return position;
    }


    //endregion
}
