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
import { Router } from '@angular/router';
import { RestaurantOwnerService } from '../../services/restaurant-owner.service';
import { RestaurantService } from '../../services/restaurant.service';
import { ItemService } from '../../services/item.service';
let AdminComponent = class AdminComponent {
    // tslint:disable-next-line:max-line-length
    constructor(route, ownerService, itemService, restaurantService) {
        this.route = route;
        this.ownerService = ownerService;
        this.itemService = itemService;
        this.restaurantService = restaurantService;
    }
    ngOnInit() {
        if (sessionStorage.getItem('role') !== 'admin') {
            this.route.navigateByUrl('');
        }
        this.admin = JSON.parse(sessionStorage.getItem('user'));
        this.ownerService.getAllRestaurantOwners().subscribe((owners) => {
            this.owners = owners;
        });
    }
    showAddRestaurantOwner() {
        this.showOwner = true;
        this.showItem = false;
        this.showRestaurant = false;
    }
    addRestaurantOwner(owner) {
        this.ownerService.addRestaurantOwner(owner).subscribe(res => {
            console.log(res);
        });
    }
    showAddItem() {
        this.showOwner = false;
        this.showItem = true;
        this.showRestaurant = false;
    }
    addItem(item) {
        this.itemService.addItem(item).subscribe(res => {
            console.log(res);
        });
    }
    showAddRestaurant() {
        this.showOwner = false;
        this.showItem = false;
        this.showRestaurant = true;
    }
    addRestaurant(restaurant) {
        this.restaurantService.addRestaurant(restaurant).subscribe(res => {
            console.log(res);
        });
    }
};
AdminComponent = __decorate([
    Component({
        selector: 'app-admin',
        templateUrl: './admin.component.html',
        styleUrls: ['./admin.component.css']
    }),
    __metadata("design:paramtypes", [Router, RestaurantOwnerService, ItemService, RestaurantService])
], AdminComponent);
export { AdminComponent };
//# sourceMappingURL=admin.component.js.map