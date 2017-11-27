import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
  showOwner: boolean;
  showItem: boolean;
  showRestaurant: boolean;
  owners: RestaurantOwner[];

  // tslint:disable-next-line:max-line-length
  constructor(private route: Router, private ownerService: RestaurantOwnerService, private itemService: ItemService, private restaurantService: RestaurantService) { }

  ngOnInit() {
    if (sessionStorage.getItem('role') !== 'admin') {
      this.route.navigateByUrl('');
    }
    this.admin = JSON.parse(sessionStorage.getItem('user'));
    this.ownerService.getAllRestaurantOwners().subscribe((owners: RestaurantOwner[]) => {
      this.owners = owners;
    });
  }
  showAddRestaurantOwner() {
    this.showOwner = true;
    this.showItem = false;
    this.showRestaurant = false;
  }
  addRestaurantOwner(owner: RestaurantOwner) {
    this.ownerService.addRestaurantOwner(owner).subscribe(res => {
      console.log(res);
    });
  }
  showAddItem() {
    this.showOwner = false;
    this.showItem = true;
    this.showRestaurant = false;
  }
  addItem(item: Item) {
    this.itemService.addItem(item).subscribe(res => {
      console.log(res);
    });
  }
  showAddRestaurant() {
    this.showOwner = false;
    this.showItem = false;
    this.showRestaurant = true;
  }
  addRestaurant(restaurant: Restaurant) {
    this.restaurantService.addRestaurant(restaurant).subscribe(res => {
      console.log(res);
    });
  }
}
