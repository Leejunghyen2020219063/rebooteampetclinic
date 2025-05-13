package org.springframework.samples.petclinic.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitHistoryService {

	private final VisitHistoryRepository visitHistoryRepository;

	@Autowired
	public VisitHistoryService(VisitHistoryRepository visitHistoryRepository) {
		this.visitHistoryRepository = visitHistoryRepository;
	}

	public List<Visit> getAllVisitsDesc() {
		return visitHistoryRepository.findAllByOrderByDateDesc();
	}

	public Visit getVisitById(int id) {
		return visitHistoryRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("해당 ID의 방문 기록이 없습니다."));
	}
}
