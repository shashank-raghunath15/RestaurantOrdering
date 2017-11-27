import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../../models/customer';
@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customer: Customer;
  constructor(private route: Router) { }

  ngOnInit() {
    if (sessionStorage.getItem('role') !== 'customer') {
      this.route.navigateByUrl('');
    }
    this.customer = JSON.parse(sessionStorage.getItem('user'));
  }

}
