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
let ItemService = class ItemService {
    constructor(http) {
        this.http = http;
    }
    addItem(item) {
        return this.http.post('http://localhost:8080/' + item.itemType + '/', item);
    }
    getRecipeItems(id) {
        return this.http.get('http://localhost:8080/recipeItem/restaurant/' + id);
    }
    getDrinkItems(id) {
        return this.http.get('http://localhost:8080/drinkItem/restaurant/' + id);
    }
    getSideItems(id) {
        return this.http.get('http://localhost:8080/sideItem/restaurant/' + id);
    }
};
ItemService = __decorate([
    Injectable(),
    __metadata("design:paramtypes", [HttpClient])
], ItemService);
export { ItemService };
//# sourceMappingURL=item.service.js.map