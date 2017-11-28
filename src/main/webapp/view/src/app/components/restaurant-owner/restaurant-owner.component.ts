import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestaurantOwner } from '../../models/restaurantOwner';
import { Restaurant } from '../../models/restaurant';
import { RestaurantService } from '../../services/restaurant.service';
import { DealService } from '../../services/deal.service';
import { RestaurantOwnerService } from '../../services/restaurant-owner.service';
import { ItemService } from '../../services/item.service';
import { Item } from '../../models/item';
import { Deal } from '../../models/deal';
import { AmountDiscountDeal } from '../../models/amountDiscountDeal';
import { MealDiscountDeal } from '../../models/mealDiscountDeal';

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
  showItem: boolean;
  showDeal: boolean;
  amtDeal: boolean;
  mealDeal: boolean;
  itemType: string;

  // tslint:disable-next-line:max-line-length
  constructor(private route: Router, private restaurantService: RestaurantService, private itemService: ItemService, private ownerService: RestaurantOwnerService, private dealService: DealService) { }

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

  loadDeals(dealType: string) {
    if (dealType === 'AmountDiscountDeal') {
      this.showAmtDeal();
    } else {
      this.showMealDeal();
    }
  }
  addItemToRestaurant(item: Item) {
    item.itemType = this.itemType;
    this.ownerService.addItemToRestaurant(this.restaurant.id, item).subscribe(res => {
      console.log(res);
    });
  }
  showAddDeals() {
    this.showItem = false;
    this.showDeal = true;
    this.showAmtDeal();
  }

  showAmtDeal() {
    this.amtDeal = true;
    this.mealDeal = false;
  }

  showMealDeal() {
    this.amtDeal = false;
    this.mealDeal = true;
  }

  addAmtDealToRestaurant(amtDeal: AmountDiscountDeal) {
    this.dealService.addAmtDeal(this.restaurant.id, amtDeal).subscribe((res: AmountDiscountDeal) => {
      console.log(res);
    });
  }

  addMealDealToRestaurant(mealDeal: MealDiscountDeal) {
    this.dealService.addMealDeal(this.restaurant.id, mealDeal).subscribe((res: MealDiscountDeal) => {
      console.log(res);
    });
  }
}
