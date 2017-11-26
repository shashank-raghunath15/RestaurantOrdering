package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.dto.Login;
import edu.buffalo.cse.ood.restaurantOrdering.model.Admin;
import edu.buffalo.cse.ood.restaurantOrdering.service.AdminService;

@Service
public class AdminServiceImpl extends ServiceImpl implements AdminService {

	@Override
	public List<Admin> getAllAdmins() {
		return getAdminRepository().findAll();
	}

	@Override
	public Admin getAdminById(Long id) {
		return getAdminRepository().getOne(id);
	}

	@Override
	public void addAdmin(Admin admin) {
		admin.setPassword(BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt()));
		getAdminRepository().save(admin);
	}

	@Override
	public void updateAdmin(Admin admin) {
		getAdminRepository().save(admin);
	}

	@Override
	public void deleteAdmin(Long id) {
		getAdminRepository().delete(id);
	}

	@Override
	public Long login(Login login) {
		Admin admin = getAdminRepository().findByUsername(login.getUserName());
		if (admin != null) {
			if (BCrypt.checkpw(login.getPassword(), admin.getPassword())) {
				return admin.getId();
			}
		}
		return -1l;
	}

}
