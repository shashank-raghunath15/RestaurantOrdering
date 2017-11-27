import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RestaurantOwner } from '../models/restaurantOwner';

@Injectable()
export class RestaurantOwnerService {

  constructor(private http: HttpClient) { }

  addRestaurantOwner(owner: RestaurantOwner) {
    return this.http.post('http://localhost:8080/restaurantOwner/', owner);
  }

  getRestaurantOwner(id: Number) {
    return this.http.get('http://localhost:8080/restaurantOwner/' + id);
  }
}
