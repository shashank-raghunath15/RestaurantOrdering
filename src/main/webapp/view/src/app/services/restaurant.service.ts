import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Restaurant } from '../models/restaurant';
import { Order } from '../models/order';

@Injectable()
export class RestaurantService {

  constructor(public http: HttpClient) { }

  addRestaurant(restaurant: Restaurant) {
    return this.http.post('http://localhost:8080/restaurant/', restaurant);
  }

  getByOwnerId(id: number) {
    return this.http.get('http://localhost:8080/restaurant/owner/' + id);
  }

  getAllRestaurants() {
    return this.http.get('http://localhost:8080/restaurant/');
  }

  applyDeal(order: Order) {
    return this.http.post('http://localhost:8080/restaurant/applyDeal/', order);
  }
}
