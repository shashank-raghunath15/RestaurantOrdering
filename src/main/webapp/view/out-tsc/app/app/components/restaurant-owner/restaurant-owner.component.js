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
import { RestaurantService } from '../../services/restaurant.service';
import { RestaurantOwnerService } from '../../services/restaurant-owner.service';
import { ItemService } from '../../services/item.service';
let RestaurantOwnerComponent = class RestaurantOwnerComponent {
    // tslint:disable-next-line:max-line-length
    constructor(route, restaurantService, itemService, ownerService) {
        this.route = route;
        this.restaurantService = restaurantService;
        this.itemService = itemService;
        this.ownerService = ownerService;
    }
    ngOnInit() {
        if (sessionStorage.getItem('role') !== 'restaurantOwner') {
            this.route.navigateByUrl('');
        }
        this.owner = JSON.parse(sessionStorage.getItem('user'));
        this.restaurantService.getByOwnerId(this.owner.id).subscribe((res) => {
            this.restaurant = res;
            this.itemService.getRecipeItems(this.restaurant.id).subscribe((items) => {
                this.recipeItems = items;
                this.items = items;
                this.itemType = 'RecipeItem';
            });
            this.itemService.getDrinkItems(this.restaurant.id).subscribe((items) => {
                this.drinkItems = items;
            });
            this.itemService.getSideItems(this.restaurant.id).subscribe((items) => {
                this.sideItems = items;
            });
        });
    }
    showAddItems() {
        this.showItem = true;
        this.showDeal = false;
    }
    loadItems(itemType) {
        this.itemType = itemType;
        if (itemType === 'RecipeItem') {
        }
        else if (itemType === 'DrinkItem') {
            this.items = this.drinkItems;
        }
        else {
            this.items = this.sideItems;
        }
    }
    addItemToRestaurant(item) {
        item.itemType = this.itemType;
        this.ownerService.addItemToRestaurant(this.restaurant.id, item).subscribe(res => {
            console.log(res);
        });
    }
    showAddDeal() {
        this.showItem = false;
        this.showDeal = true;
    }
};
RestaurantOwnerComponent = __decorate([
    Component({
        selector: 'app-restaurant-owner',
        templateUrl: './restaurant-owner.component.html',
        styleUrls: ['./restaurant-owner.component.css']
    }),
    __metadata("design:paramtypes", [Router, RestaurantService, ItemService, RestaurantOwnerService])
], RestaurantOwnerComponent);
export { RestaurantOwnerComponent };
//# sourceMappingURL=restaurant-owner.component.js.map