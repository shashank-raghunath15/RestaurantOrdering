import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestaurantOwner } from '../../models/restaurantOwner';

@Component({
  selector: 'app-restaurant-owner',
  templateUrl: './restaurant-owner.component.html',
  styleUrls: ['./restaurant-owner.component.css']
})
export class RestaurantOwnerComponent implements OnInit {

  owner: RestaurantOwner;
  constructor(private route: Router) { }

  ngOnInit() {
    if (sessionStorage.getItem('role') !== 'restaurantOwner') {
      this.route.navigateByUrl('');
    }
    this.owner = JSON.parse(sessionStorage.getItem('user'));
  }

}
