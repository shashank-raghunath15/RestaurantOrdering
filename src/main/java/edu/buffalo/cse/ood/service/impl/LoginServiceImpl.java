package edu.buffalo.cse.ood.service.impl;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.model.Login;
import edu.buffalo.cse.ood.model.Person;
import edu.buffalo.cse.ood.service.LoginService;

@Service
public class LoginServiceImpl extends ServiceImpl implements LoginService {

	@Override
	public Person login(Login login) {
		if (getLoginRepository().exists(login.getId())) {
			Login login2 = getLoginRepository().getOne(login.getId());
			if (BCrypt.checkpw(login.getPassword(), login2.getPassword())) {
				return getPersonRepository().getOne(login2.getPerson().getId());
			}
		}
		return null;
	}

	@Override
	public Login register(Login login) {
		System.out.println(login);
		login.setPerson(getPersonRepository().save(login.getPerson()));
		login.setPassword(BCrypt.hashpw(login.getPassword(), BCrypt.gensalt()));
		return getLoginRepository().save(login);
	}

}
