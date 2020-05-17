package com.schedule.suggestion.persistence.repositories;

import com.schedule.suggestion.persistence.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{
    Professor findProfessorByUsernameAndPassword(String username, String password);

}
