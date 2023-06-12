package com.example.EquipmentRental;

import com.example.EquipmentRental.Model.Equipment;
import com.example.EquipmentRental.Repository.EquipmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EquipmentRentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquipmentRentalApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(EquipmentRepository equipmentRepository){
		return  args -> {
			Equipment eq1 = new Equipment();
			eq1.setEquipmentId(Long.parseLong("1"));
			eq1.setCategory("Cricket");
			eq1.setName("Bat");
			eq1.setImage("https://upload.wikimedia.org/wikipedia/commons/a/a5/A_Modern_Cricket_Bat.jpg");
			eq1.setPricePerDay(99.99);

			Equipment eq2 = new Equipment();
			eq2.setEquipmentId(Long.parseLong("2"));
			eq2.setCategory("Cricket");
			eq2.setName("Ball");
			eq2.setImage("https://upload.wikimedia.org/wikipedia/commons/6/62/Cricket-ball-red-madeinaustralia.jpg");
			eq2.setPricePerDay(49.99);

			Equipment eq3 = new Equipment();
			eq3.setEquipmentId(Long.parseLong("3"));
			eq3.setCategory("Tennis");
			eq3.setName("Tennis Racket");
			eq3.setImage("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Tennis_Racket_and_Balls.jpg/220px-Tennis_Racket_and_Balls.jpg");
			eq3.setPricePerDay(79.99);

			Equipment eq4 = new Equipment();
			eq4.setEquipmentId(Long.parseLong("4"));
			eq4.setCategory("Tennis");
			eq4.setName("Tennis ball");
			eq4.setImage("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c4/Tennis_ball.svg/1200px-Tennis_ball.svg.png");
			eq4.setPricePerDay(29.99);

			Equipment eq5 = new Equipment();
			eq5.setEquipmentId(Long.parseLong("5"));
			eq5.setCategory("Table tennis");
			eq5.setName("bat and ball");
			eq5.setImage("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Table_tennis_bat_and_ball.jpg/1200px-Table_tennis_bat_and_ball.jpg");
			eq5.setPricePerDay(19.99);

			equipmentRepository.save(eq1);
			equipmentRepository.save(eq2);
			equipmentRepository.save(eq3);
			equipmentRepository.save(eq4);
			equipmentRepository.save(eq5);


		};
	}

}
