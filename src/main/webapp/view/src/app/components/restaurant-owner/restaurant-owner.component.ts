import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestaurantOwner } from '../../models/restaurantOwner';
import { Restaurant } from '../../models/restaurant';
import { RestaurantService } from '../../services/restaurant.service';
import { RestaurantOwnerService } from '../../services/restaurant-owner.service';
import { ItemService } from '../../services/item.service';
import { Item } from '../../models/item';
import { Deal } from '../../models/deal';

@Component({
  selector: 'app-restaurant-owner',
  templateUrl: './restaurant-owner.component.html',
  styleUrls: ['./restaurant-owner.component.css']
})
export class RestaurantOwnerComponent implements OnInit {

  owner: RestaurantOwner;
  restaurant: Restaurant;
  items: Item[];
  recipeItems: Item[];
  drinkItems: Item[];
  sideItems: Item[];
  deals: Deal[];
  showItem: boolean;
  showDeal: boolean;
  itemType: string;

  // tslint:disable-next-line:max-line-length
  constructor(private route: Router, private restaurantService: RestaurantService, private itemService: ItemService, private ownerService: RestaurantOwnerService) { }

  ngOnInit() {
    if (sessionStorage.getItem('role') !== 'restaurantOwner') {
      this.route.navigateByUrl('');
    }
    this.owner = JSON.parse(sessionStorage.getItem('user'));
    this.restaurantService.getByOwnerId(this.owner.id).subscribe((res: Restaurant) => {
      this.restaurant = res;
      this.itemService.getRecipeItems(this.restaurant.id).subscribe((items: Item[]) => {
        this.recipeItems = items;
        this.items = items;
        this.itemType = 'RecipeItem';
      });
      this.itemService.getDrinkItems(this.restaurant.id).subscribe((items: Item[]) => {
        this.drinkItems = items;
      });
      this.itemService.getSideItems(this.restaurant.id).subscribe((items: Item[]) => {
        this.sideItems = items;
      });
    });
  }
  showAddItems() {
    this.showItem = true;
    this.showDeal = false;
  }
  loadItems(itemType: string) {
    this.itemType = itemType;
    if (itemType === 'RecipeItem') {
    } else if (itemType === 'DrinkItem') {
      this.items = this.drinkItems;
    } else {
      this.items = this.sideItems;
    }
  }
  addItemToRestaurant(item: Item) {
    item.itemType = this.itemType;
    this.ownerService.addItemToRestaurant(this.restaurant.id, item).subscribe(res => {
      console.log(res);
    });
  }
  showAddDeal() {
    this.showItem = false;
    this.showDeal = true;
  }
  // addItem(item: Item) {
  //   this.itemService.addItem(item).subscribe(res => {
  //     console.log(res);
  //   });
  // }
}
