package com.example.Liga;

import com.example.Liga.model.Liga;
import com.example.Liga.model.Match;
import com.example.Liga.model.Player;
import com.example.Liga.model.Team;
import com.example.Liga.repository.LigaRepository;
import com.example.Liga.repository.MatchRepository;
import com.example.Liga.repository.PlayerRepository;
import com.example.Liga.repository.TeamRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class LigaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LigaApplication.class, args);

	}


	@Bean
	public CommandLineRunner initData(TeamRepository teamRepository, PlayerRepository playerRepository, MatchRepository matchRepository, LigaRepository ligaRepository){
		return (args) -> {

			//region Teams

			//region Teams creation
			Team River = new Team("River Plate", LocalDate.of(1901, 05, 25) );
			River.setShield("https://i.pinimg.com/originals/37/53/91/37539180d5476fb63e5def4424a767c1.png");
			teamRepository.save(River);

			Team Boca = new Team("Boca Juniors", LocalDate.of(1905, 04, 3));
			Boca.setShield("https://upload.wikimedia.org/wikipedia/commons/7/7f/Escudo_del_Club_Atl%C3%A9tico_Boca_Juniors_2012.svg");
			teamRepository.save(Boca);

			Team Barcelona = new Team("Barcelona", LocalDate.of(1899 , 9, 29));
			Barcelona.setShield("https://lh3.googleusercontent.com/OQZi4ckWAs7UrOlZEPefXZgJOcdJuSM5FSH9zqD5rMg6c2MOaxcKpV5IMrb1Tju98fWyNmcI33E4RGb0uC09Ej4W");
			teamRepository.save(Barcelona);


			Team RealMadrid = new Team("Real Madrid", LocalDate.of(1902 , 03, 6));
			RealMadrid.setShield("https://assets.stickpng.com/images/584a9b47b080d7616d298778.png");
			teamRepository.save(RealMadrid);


			Team Palmeiras = new Team("Palmeiras", LocalDate.of(1910, 1, 29));
			Palmeiras.setShield("https://upload.wikimedia.org/wikipedia/commons/thumb/1/10/Palmeiras_logo.svg/1200px-Palmeiras_logo.svg.png");
			teamRepository.save(Palmeiras);

			Team Santos = new Team("Santos", LocalDate.of(1889, 6, 10));
			//Santos.setShield();
			teamRepository.save(Santos);

			Team Racing = new Team("Racing", LocalDate.of(1920, 4, 24));
			//Racing.setShield();
			teamRepository.save(Racing);

			Team Gremio = new Team("Gremio", LocalDate.of(1900, 5, 9));
			//Gremio.setShield();
			teamRepository.save(Gremio);



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


			Barcelona.addCup("Champions 2006");
			Barcelona.addCup("Champions 2009");
			Barcelona.addCup("Champions 2015");
			Barcelona.addCup("Champions 2006");
			Barcelona.addCup("Mundial de Clubes 2011");
			Barcelona.addCup("Mundial de Clubes 2015");
			teamRepository.save(Barcelona);

			RealMadrid.addCup("Champions 2016");
			RealMadrid.addCup("Champions 2017");
			RealMadrid.addCup("Champions 2018");
			RealMadrid.addCup("Champions 2014");
			RealMadrid.addCup("Champions 2002");
			RealMadrid.addCup("Champions 2000");
			RealMadrid.addCup("Mundial de Clubes 2011");
			RealMadrid.addCup("Mundial de Clubes 2014");
			RealMadrid.addCup("Mundial de Clubes 2016");
			RealMadrid.addCup("Mundial de Clubes 2017");
			RealMadrid.addCup("Mundial de Clubes 2018");
			teamRepository.save(RealMadrid);



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

			Player LionelM = new Player("Lionel", "Messi", 32);
			Barcelona.addPlayer(LionelM);
			LionelM.setPosition(Player.Eposition.Striker);
			playerRepository.save(LionelM);

			Player KarimB = new Player("Karim", "Benzema", 32);
			RealMadrid.addPlayer(KarimB);
			KarimB.setPosition(Player.Eposition.Striker);
			playerRepository.save(KarimB);

			Player SergioR = new Player("Sergio", "Ramos", 34);
			RealMadrid.addPlayer(SergioR);
			SergioR.setPosition(Player.Eposition.Defense);
			playerRepository.save(SergioR);

			Player AntoineG = new Player("Antoine", "Griezmann", 29);
			Barcelona.addPlayer(AntoineG);
			AntoineG.setPosition(Player.Eposition.Striker);
			playerRepository.save(AntoineG);



			//endregion

			//region Matches

			Match SemisA = new Match("Semifinal A", Date.from(Instant.now()));
			SemisA.addTeam(River);
			SemisA.addTeam(Palmeiras);
			matchRepository.save(SemisA);
			teamRepository.save(River);
			teamRepository.save(Palmeiras);



			Match SemisB = new Match("Semifinal B", Date.from(Instant.now()));
			SemisB.addTeam(Boca);
			SemisB.addTeam(RealMadrid);
			matchRepository.save(SemisB);
			teamRepository.save(Boca);
			teamRepository.save(RealMadrid);
			//endregion


			Liga Libertadores2020 = new Liga("Libertadores 2020", "Latinoamerica");
			Libertadores2020.addTeam(River);
			Libertadores2020.addTeam(RealMadrid);
			Libertadores2020.addTeam(Boca);
			Libertadores2020.addTeam(Palmeiras);
			ligaRepository.save(Libertadores2020);


			Libertadores2020.addMatch(SemisA);
			Libertadores2020.addMatch(SemisA);
			ligaRepository.save(Libertadores2020);

			SemisA.setLiga(Libertadores2020);
			SemisB.setLiga(Libertadores2020);
			matchRepository.save(SemisA);
			matchRepository.save(SemisB);


		};
	}



}
