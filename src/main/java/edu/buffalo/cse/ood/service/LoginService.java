package edu.buffalo.cse.ood.service;

import edu.buffalo.cse.ood.model.Login;
import edu.buffalo.cse.ood.model.Person;

public interface LoginService {

	public Person login(Login login);
	public Login register(Login login);
}
