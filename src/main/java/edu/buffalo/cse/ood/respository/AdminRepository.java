package edu.buffalo.cse.ood.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.buffalo.cse.ood.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

}
