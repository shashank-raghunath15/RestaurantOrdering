package edu.buffalo.cse.ood.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.buffalo.cse.ood.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
