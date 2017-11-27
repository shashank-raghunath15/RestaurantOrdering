var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
let RestaurantOwnerService = class RestaurantOwnerService {
    constructor(http) {
        this.http = http;
    }
    addRestaurantOwner(owner) {
        return this.http.post('http://localhost:8080/restaurantOwner/', owner);
    }
    getRestaurantOwner(id) {
        return this.http.get('http://localhost:8080/restaurantOwner/' + id);
    }
    getAllRestaurantOwners() {
        return this.http.get('http://localhost:8080/restaurantOwner/');
    }
    addItemToRestaurant(id, item) {
        return this.http.post('http://localhost:8080/restaurantOwner/' + id + '/add' + item.itemType + '/', item);
    }
};
RestaurantOwnerService = __decorate([
    Injectable(),
    __metadata("design:paramtypes", [HttpClient])
], RestaurantOwnerService);
export { RestaurantOwnerService };
//# sourceMappingURL=restaurant-owner.service.js.map