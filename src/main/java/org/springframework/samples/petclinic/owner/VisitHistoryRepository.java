package org.springframework.samples.petclinic.owner;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository

public interface VisitHistoryRepository extends JpaRepository<Visit, Integer> {
	Optional<Visit> findById(int id);

	// 방문 기록을 날짜 내림차순으로 찾는 메서드
	List<Visit> findAllByOrderByDateDesc();
}
