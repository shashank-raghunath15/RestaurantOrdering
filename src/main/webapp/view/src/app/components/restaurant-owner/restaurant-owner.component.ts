import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { RestaurantOwner } from '../../models/restaurantOwner';
import { Restaurant } from '../../models/restaurant';
import { RestaurantService } from '../../services/restaurant.service';
import { DealService } from '../../services/deal.service';
import { RestaurantOwnerService } from '../../services/restaurant-owner.service';
import { ItemService } from '../../services/item.service';
import { Item } from '../../models/item';
import { AmountDiscountDeal } from '../../models/amountDiscountDeal';
import { MealDiscountDeal } from '../../models/mealDiscountDeal';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalComponent } from '../../components/modal/modal.component';

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
  show: string;
  deal: string;
  itemType: string;

  // tslint:disable-next-line:max-line-length
  constructor(private route: Router, private restaurantService: RestaurantService, private itemService: ItemService, private ownerService: RestaurantOwnerService, private dealService: DealService, private activatedRoute: ActivatedRoute, private modalService: NgbModal) {
    this.activatedRoute.data.subscribe(val => {
      this.show = val.show;
      this.deal = val.deal;
    });
  }

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
    if (dealType === 'mealDiscountDeal') {
      this.route.navigateByUrl('addMealDeal');
    } else {
      this.route.navigateByUrl('addAmtDeal');
    }
  }
  addItemToRestaurant(item: Item) {
    item.itemType = this.itemType;
    this.ownerService.addItemToRestaurant(this.restaurant.id, item).subscribe(res => {
      this.message('Item added successfully');
      this.route.navigateByUrl('restaurantOwner');
    });
  }
  addAmtDealToRestaurant(amtDeal: AmountDiscountDeal) {
    this.dealService.addAmtDeal(this.restaurant.id, amtDeal).subscribe((res: AmountDiscountDeal) => {
      this.message('Deal added successfully');
      this.route.navigateByUrl('restaurantOwner');
    });
  }

  addMealDealToRestaurant(mealDeal: MealDiscountDeal) {
    this.dealService.addMealDeal(this.restaurant.id, mealDeal).subscribe((res: MealDiscountDeal) => {
      this.message('Deal added successfully');
      this.route.navigateByUrl('restaurantOwner');
    });
  }
  message(msg: string) {
    const modalRef = this.modalService.open(ModalComponent, { windowClass: 'dark-modal' });
    modalRef.componentInstance.msg = msg;
  }
}
