package com.example.Liga;

import com.example.Liga.model.Player;
import com.example.Liga.model.Team;
import com.example.Liga.repository.PlayerRepository;
import com.example.Liga.repository.TeamRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class LigaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LigaApplication.class, args);

	}


	@Bean
	public CommandLineRunner initData(TeamRepository teamRepository, PlayerRepository playerRepository){
		return (args) -> {

			//region Teams

			//region Teams creation
			Team River = new Team("River Plate", LocalDate.of(1901, 05, 25) );
			River.setShield("https://i.pinimg.com/originals/37/53/91/37539180d5476fb63e5def4424a767c1.png");
			teamRepository.save(River);

			Team Boca = new Team("Boca Juniors", LocalDate.of(1905, 04, 3));
			Boca.setShield("https://upload.wikimedia.org/wikipedia/commons/7/7f/Escudo_del_Club_Atl%C3%A9tico_Boca_Juniors_2012.svg");
			teamRepository.save(Boca);
			//endregion

			//region Team cups
			River.addCup("Libertadores 1986");
			River.addCup("Libertadores 1996");
			River.addCup("Libertadores 2015");
			River.addCup("Libertadores 2018");
			River.addCup("Intercontinental 1986");
			teamRepository.save(River);

			Boca.addCup("Libertadores 1977");
			Boca.addCup("Libertadores 1978");
			Boca.addCup("Libertadores 2000");
			Boca.addCup("Libertadores 2001");
			Boca.addCup("Libertadores 2003");
			Boca.addCup("Libertadores 2007");
			Boca.addCup("Intercontinental 2000");
			teamRepository.save(Boca);
			//endregion

			//endregion


			//region Players creation

			//region EnzoPerez
			Player EnzoP = new Player("Enzo", "Perez", 34);
			River.addPlayer(EnzoP);
			EnzoP.setPosition(Player.Eposition.Midfielder);
			playerRepository.save(EnzoP);
			//endregion

			//region Pity
			Player PityA = new Player("Gonzalo", "Martinez", 27);
			River.addPlayer(PityA);
			PityA.setPosition(Player.Eposition.Striker);
			playerRepository.save(PityA);
			//endregion

			//region Ortega
			Player ArielO = new Player("Ariel", "Ortega", 45, River);
			River.addPlayer(ArielO);
			ArielO.setPosition(Player.Eposition.Striker);
			playerRepository.save(ArielO);
			//endregion

			//region Palermo
			//Creo el jugador
			Player MartinP = new Player("Martin", "Palermo", 44);
			//Guardo el jugador
			playerRepository.save(MartinP);

			//Le asigno un equipo al jugador
			Boca.addPlayer(MartinP);
			//Le asigno la posicion
			MartinP.setPosition(Player.Eposition.Striker);
			//Guardo los cambios desde el jugador
			playerRepository.save(MartinP);
			//endregion

			//region Riquelme
			Player RomanR = new Player("Roman", "Riquelme", 43);
			Boca.addPlayer(RomanR);
			RomanR.setPosition(Player.Eposition.Midfielder);
			playerRepository.save(RomanR);
			//endregion


			//endregion


		};
	}



}
