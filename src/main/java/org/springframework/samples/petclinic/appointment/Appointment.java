package org.springframework.samples.petclinic.appointment;

import jakarta.persistence.*;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.vet.Vet;

import java.time.LocalDateTime;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Pet pet;

	@ManyToOne
	private Vet vet;

	@ManyToOne
	private Owner owner;

	private LocalDateTime appointmentDate;

	private String description;

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
}
