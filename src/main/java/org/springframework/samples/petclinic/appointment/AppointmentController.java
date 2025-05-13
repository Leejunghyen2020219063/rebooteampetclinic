package org.springframework.samples.petclinic.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.samples.petclinic.owner.PetRepository;
import org.springframework.samples.petclinic.vet.VetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private VetRepository vetRepository;

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private PetRepository petRepository;

	@GetMapping
	public String listAppointments(Model model) {
		model.addAttribute("appointments", appointmentService.findAll());
		return "appointments/appointmentList";
	}

	@GetMapping("/new")
	public String showForm(Model model) {
		model.addAttribute("appointment", new Appointment());
		model.addAttribute("vets", vetRepository.findAll());
		model.addAttribute("owners", ownerRepository.findAll());
		model.addAttribute("pets", petRepository.findAll());
		return "appointments/appointmentForm";
	}

	@PostMapping("/new")
	public String create(@ModelAttribute Appointment appointment) {
		appointmentService.save(appointment);
		return "redirect:/appointments";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		appointmentService.deleteById(id);
		return "redirect:/appointments";
	}
}
