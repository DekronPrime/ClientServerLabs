package org.example.repositories;

import org.example.entities.Abiturient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AbiturientRepo extends JpaRepository<Abiturient, Long> {
    List<Abiturient> findByFirstNameIsIgnoreCase(String firstName);
    List<Abiturient> findByAveragePointIsGreaterThan(Double minAveragePoint);
    List<Abiturient> findByNeedHostelIsTrue();
}
