package com.example.observable_crud_demo.repository;

import com.example.observable_crud_demo.domain.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Long> {


}
