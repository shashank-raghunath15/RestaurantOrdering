import { Component, OnInit } from '@angular/core';

import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';
import { Login } from '../../models/login';
import { Admin } from '../../models/admin';
import { Customer } from '../../models/customer';

import { AdminService } from '../../services/admin.service';
import { CustomerService } from '../../services/customer.service';
import { RestaurantOwnerService } from '../../services/restaurant-owner.service';
import { RestaurantOwner } from '../../models/restaurantOwner';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private login: Login;
  private id: Number;

  // tslint:disable-next-line:max-line-length
  constructor(private loginService: LoginService, private adminService: AdminService, private route: Router, private customerService: CustomerService, private ownerService: RestaurantOwnerService) {

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
            this.route.navigateByUrl('/admin');
          });
        } else if (login.role === 'customer') {
          this.customerService.getCustomer(id).subscribe((customer: Customer) => {
            sessionStorage.setItem('user', JSON.stringify(customer));
            sessionStorage.setItem('role', login.role);
            this.route.navigateByUrl('/customer');
          });
        } else {
          this.ownerService.getRestaurantOwner(id).subscribe((restaurantOwner: RestaurantOwner) => {
            sessionStorage.setItem('user', JSON.stringify(restaurantOwner));
            sessionStorage.setItem('role', login.role);
            this.route.navigateByUrl('/restaurantOwner');
          });
        }
      }
    });
  }

  registerCustomer(customer: Customer) {
    this.customerService.addCustomer(customer).subscribe(res => {
      console.log(res);
    });
  }

}
