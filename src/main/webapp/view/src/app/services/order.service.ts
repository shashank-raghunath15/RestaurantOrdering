import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Order } from '../models/order';

@Injectable()
export class OrderService {

  constructor(private http: HttpClient) { }

  addOrder(order: Order) {
    return this.http.post('http://localhost:8080/order/', order);
  }
  reOrder(order: Order) {
    return this.http.post('http://localhost:8080/order/reOrder/', order);
  }
}
