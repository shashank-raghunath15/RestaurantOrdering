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
import { FormControl, FormGroup } from '@angular/forms';
let LoginComponent = class LoginComponent {
    constructor(loginService) {
        this.loginService = loginService;
    }
    ngOnInit() {
        this.login = new FormGroup({
            username: new FormControl(''),
            password: new FormControl('')
        });
        //    this.loginService.login(this.login).subscribe((data) => {
        //      console.log(data);
        //    });
    }
    loginAdmin({ value, valid }) {
        console.log(this.login);
    }
};
LoginComponent = __decorate([
    Component({
        selector: 'app-login',
        templateUrl: './login.component.html',
        styleUrls: ['./login.component.css']
    }),
    __metadata("design:paramtypes", [LoginService])
], LoginComponent);
export { LoginComponent };
//# sourceMappingURL=login.component.js.map