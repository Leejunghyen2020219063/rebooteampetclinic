package org.springframework.samples.petclinic.appointment;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
	List<Appointment> findByVetId(Integer vetId);
	List<Appointment> findByOwnerId(Integer ownerId);
}
