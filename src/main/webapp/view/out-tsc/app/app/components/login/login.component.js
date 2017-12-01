var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
import { Component } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';
import { Login } from '../../models/login';
import { AdminService } from '../../services/admin.service';
import { CustomerService } from '../../services/customer.service';
import { RestaurantOwnerService } from '../../services/restaurant-owner.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalComponent } from '../../components/modal/modal.component';
let LoginComponent = class LoginComponent {
    // tslint:disable-next-line:max-line-length
    constructor(loginService, adminService, route, customerService, ownerService, modalService) {
        this.loginService = loginService;
        this.adminService = adminService;
        this.route = route;
        this.customerService = customerService;
        this.ownerService = ownerService;
        this.modalService = modalService;
    }
    ngOnInit() {
    }
    logIn(login) {
        this.loginService.login(login).subscribe((id) => {
            if (id === -1) {
                this.message('Username and or password is incorrect! Did you sign up?');
            }
            else {
                if (login.role === 'admin') {
                    this.adminService.getAdmin(id).subscribe((admin) => {
                        sessionStorage.setItem('user', JSON.stringify(admin));
                        sessionStorage.setItem('role', login.role);
                        this.route.navigateByUrl('/admin');
                    });
                }
                else if (login.role === 'customer') {
                    this.customerService.getCustomer(id).subscribe((customer) => {
                        sessionStorage.setItem('user', JSON.stringify(customer));
                        sessionStorage.setItem('role', login.role);
                        this.route.navigateByUrl('/customer');
                    });
                }
                else {
                    this.ownerService.getRestaurantOwner(id).subscribe((restaurantOwner) => {
                        sessionStorage.setItem('user', JSON.stringify(restaurantOwner));
                        sessionStorage.setItem('role', login.role);
                        this.route.navigateByUrl('/restaurantOwner');
                    });
                }
            }
        });
    }
    registerCustomer(customer) {
        this.customerService.addCustomer(customer).subscribe((cus) => {
            const login = new Login();
            login.username = customer.username;
            login.password = customer.password;
            login.role = 'customer';
            this.logIn(login);
        });
    }
    message(msg) {
        const modalRef = this.modalService.open(ModalComponent, { windowClass: 'dark-modal' });
        modalRef.componentInstance.msg = msg;
    }
};
LoginComponent = __decorate([
    Component({
        selector: 'app-login',
        templateUrl: './login.component.html',
        styleUrls: ['./login.component.css']
    }),
    __metadata("design:paramtypes", [LoginService, AdminService, Router, CustomerService, RestaurantOwnerService, NgbModal])
], LoginComponent);
export { LoginComponent };
//# sourceMappingURL=login.component.js.map