package edu.buffalo.cse.ood.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.buffalo.cse.ood.model.Login;

public interface LoginRepository extends JpaRepository<Login, String>{

}
