package org.springframework.samples.petclinic.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	public List<Appointment> findAll() {
		return (List<Appointment>) appointmentRepository.findAll();
	}

	public List<Appointment> findByVetId(Integer vetId) {
		return appointmentRepository.findByVetId(vetId);
	}

	public List<Appointment> findByOwnerId(Integer ownerId) {
		return appointmentRepository.findByOwnerId(ownerId);
	}

	public Appointment save(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	public void deleteById(Integer id) {
		appointmentRepository.deleteById(id);
	}

	public Optional<Appointment> findById(Integer id) {
		return appointmentRepository.findById(id);
	}
}
