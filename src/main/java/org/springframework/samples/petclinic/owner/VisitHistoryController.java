package org.springframework.samples.petclinic.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class VisitHistoryController {

	private final VisitHistoryRepository visitHistoryRepository;

	@Autowired
	public VisitHistoryController(VisitHistoryRepository visitHistoryRepository) {
		this.visitHistoryRepository = visitHistoryRepository;
	}

	// 방문 기록 목록을 보여주는 메서드
	@GetMapping("/owners/history")
	public String showVisitHistory(Model model) {
		List<Visit> visits = visitHistoryRepository.findAllByOrderByDateDesc();
		model.addAttribute("visits", visits);
		return "owners/history"; // 방문 기록 목록 템플릿
	}



	// 방문 기록 상세 보기
	@GetMapping("/owners/history/{visitId}")
	public String showVisitDetail(@PathVariable("visitId") int visitId, Model model) {
		Optional<Visit> visitOpt = visitHistoryRepository.findById(visitId);

		if (visitOpt.isPresent()) {
			Visit visit = visitOpt.get();
			if (visit.getVet() == null) {
				System.out.println("수의사 정보가 없습니다.");  // 로그로 확인
			} else {
				System.out.println("수의사 이름: " + visit.getVet().getName());  // 수의사 이름 확인
			}
			model.addAttribute("visit", visit);
			return "owners/visitDetail"; // 방문 상세 페이지
		} else {
			return "redirect:/owners/history"; // 방문 기록이 없으면 목록 페이지로 리다이렉트
		}
	}


}

