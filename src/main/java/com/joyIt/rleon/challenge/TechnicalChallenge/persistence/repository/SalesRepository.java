package com.joyIt.rleon.challenge.TechnicalChallenge.persistence.repository;

import com.joyIt.rleon.challenge.TechnicalChallenge.persistence.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
}
