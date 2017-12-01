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
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalComponent } from '../../components/modal/modal.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // tslint:disable-next-line:max-line-length
  constructor(private loginService: LoginService, private adminService: AdminService, private route: Router, private customerService: CustomerService, private ownerService: RestaurantOwnerService, private modalService: NgbModal) {

  }

  ngOnInit() {
  }

  logIn(login: Login) {

    this.loginService.login(login).subscribe((id: Number) => {
      if (id === -1) {
        this.message('Username and or password is incorrect! Did you sign up?');
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
    },
      error => {
        this.message('Server Error. Please try later.');
      });
  }

  registerCustomer(customer: Customer) {
    this.customerService.addCustomer(customer).subscribe((cus: Customer) => {
      const login = new Login();
      login.username = customer.username;
      login.password = customer.password;
      login.role = 'customer';
      this.logIn(login);
    },
      error => {
        this.message('Username already exists. Please choose different username.');
      });
  }
  message(msg: string) {
    const modalRef = this.modalService.open(ModalComponent, { windowClass: 'dark-modal' });
    modalRef.componentInstance.msg = msg;
  }
}
