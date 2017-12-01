import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from '../models/customer';

@Injectable()
export class CustomerService {

  constructor(private http: HttpClient) { }

  addCustomer(customer: Customer) {
    return this.http.post('http://localhost:8080/customer/', customer);
  }

  getCustomer(id: number) {
    return this.http.get('http://localhost:8080/customer/' + id);
  }

  getOrders(id: number) {
    return this.http.get('http://localhost:8080/customer/getOrders/' + id);
  }
}
