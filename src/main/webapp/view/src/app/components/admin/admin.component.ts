import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Admin } from '../../models/admin';
import { Item } from '../../models/item';
import { RestaurantOwner } from '../../models/restaurantOwner';
import { Restaurant } from '../../models/restaurant';
import { RestaurantOwnerService } from '../../services/restaurant-owner.service';
import { RestaurantService } from '../../services/restaurant.service';
import { ItemService } from '../../services/item.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  admin: Admin;
  show: string;
  owners: RestaurantOwner[];
  msg: string;

  // tslint:disable-next-line:max-line-length
  constructor(private route: Router, private ownerService: RestaurantOwnerService, private itemService: ItemService, private restaurantService: RestaurantService, private activatedRoute: ActivatedRoute) {
    activatedRoute.data.subscribe((val => {
      this.show = val.show;
    }));
    this.msg = localStorage.getItem('msg');
  }

  ngOnInit() {
    if (sessionStorage.getItem('role') !== 'admin') {
      this.route.navigateByUrl('');
    }
    this.admin = JSON.parse(sessionStorage.getItem('user'));
    this.ownerService.getAllRestaurantOwners().subscribe((owners: RestaurantOwner[]) => {
      this.owners = owners;
    });
  }

  addRestaurantOwner(owner: RestaurantOwner) {
    this.ownerService.addRestaurantOwner(owner).subscribe(res => {
      localStorage.setItem('msg', 'Owner added successfully');
      this.route.navigateByUrl('admin');
    });
  }
  addItem(item: Item) {
    this.itemService.addItem(item).subscribe(res => {
      localStorage.setItem('msg', 'Item added successfully');
      this.route.navigateByUrl('admin');
    });
  }
  addRestaurant(restaurant: Restaurant) {
    this.restaurantService.addRestaurant(restaurant).subscribe(res => {
      localStorage.setItem('msg', 'Restaurant added successfully');
      this.route.navigateByUrl('admin');
    });
  }
}
