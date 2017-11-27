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
import { AdminService } from '../../services/admin.service';
import { CustomerService } from '../../services/customer.service';
import { RestaurantOwnerService } from '../../services/restaurant-owner.service';
let LoginComponent = class LoginComponent {
    // tslint:disable-next-line:max-line-length
    constructor(loginService, adminService, route, customerService, ownerService) {
        this.loginService = loginService;
        this.adminService = adminService;
        this.route = route;
        this.customerService = customerService;
        this.ownerService = ownerService;
    }
    ngOnInit() {
    }
    loginAdmin(login) {
        this.loginService.login(login).subscribe((id) => {
            if (id === -1) {
                alert('login failed');
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
        this.customerService.addCustomer(customer).subscribe(res => {
            console.log(res);
        });
    }
};
LoginComponent = __decorate([
    Component({
        selector: 'app-login',
        templateUrl: './login.component.html',
        styleUrls: ['./login.component.css']
    }),
    __metadata("design:paramtypes", [LoginService, AdminService, Router, CustomerService, RestaurantOwnerService])
], LoginComponent);
export { LoginComponent };
//# sourceMappingURL=login.component.js.map