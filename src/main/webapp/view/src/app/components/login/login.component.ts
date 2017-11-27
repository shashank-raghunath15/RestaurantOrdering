import {Component, OnInit} from '@angular/core';
import {LoginService} from '../../services/login.service';
import {Login} from '../../models/login';
import {AdminService} from '../../services/admin.service';
import {CustomerService} from '../../services/customer.service';
import {RestaurantOwnerService} from '../../services/restaurant-owner.service';
import {Admin} from '../../models/admin';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private login: Login;
  private id: Number;

  constructor(private loginService: LoginService, private adminService: AdminService) {

  }

  ngOnInit() {
  }

  loginAdmin(login: Login) {

    this.loginService.login(login).subscribe((id: Number) => {
      if (id === -1) {
        alert('login failed');
      } else {
        if (login.role === 'admin') {
          this.adminService.getAdmin(id).subscribe((admin: Admin) => {
            sessionStorage.setItem('user', JSON.stringify(admin));
            sessionStorage.setItem('role', login.role);
            console.log(sessionStorage.getItem('user'));
          });

        } else if (login.role === 'customer') {

        } else {

        }
      }
    });
  }

}
