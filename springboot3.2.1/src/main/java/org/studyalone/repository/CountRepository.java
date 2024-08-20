package org.studyalone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.studyalone.domain.Count;

public interface CountRepository extends JpaRepository<Count, Long> {

}
