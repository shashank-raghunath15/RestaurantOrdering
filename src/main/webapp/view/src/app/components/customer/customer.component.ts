import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../../models/customer';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalComponent } from '../../components/modal/modal.component';
import { RestaurantService } from '../../services/restaurant.service';
import { CustomerService } from '../../services/customer.service';
import { Restaurant } from '../../models/restaurant';
import { Item } from '../../models/item';
import { Order } from '../../models/order';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customer: Customer;
  restaurants: Restaurant[];
  items: Item[];
  showItems: boolean;
  orderItems: Item[] = new Array();
  order: Order = new Order();
  pastOrders: Order[];
  show: string;
  // tslint:disable-next-line:max-line-length
  constructor(private route: Router, private modalService: NgbModal, private restaurantService: RestaurantService, private customerService: CustomerService, private activatedRoute: ActivatedRoute) {
    restaurantService.getAllRestaurants().subscribe((res: Restaurant[]) => {
      this.restaurants = res;
    }, error => { });
    activatedRoute.data.subscribe((val => {
      this.show = val.show;
    }));
  }

  ngOnInit() {
    if (sessionStorage.getItem('role') !== 'customer') {
      this.route.navigateByUrl('');
    }
    this.customer = JSON.parse(sessionStorage.getItem('user'));
    this.customerService.getOrders(this.customer.id).subscribe((res: Order[]) => {
      this.pastOrders = res;
    }, error => { });
  }
  loadItems(restaurant: Restaurant) {
    this.showItems = false;
    this.items = restaurant.availableItems;
    this.order.restaurant = restaurant;
    this.showItems = true;
  }

  addItemToOrder(id: number) {
    const item = this.items.filter(itm => id === id)[0];
    this.orderItems.push(item);
    this.order.totalPrice += item.price;
    this.message(item.name + ' added to cart successfully');
  }

  doneItems() {
    this.order.items = this.orderItems;
    this.order.customer = this.customer;
    this.restaurantService.applyDeal(this.order).subscribe((res: Order) => {
      this.order = res;
      this.show = 'order';
    }, error => { });

  }

  message(msg: string) {
    const modalRef = this.modalService.open(ModalComponent, { windowClass: 'dark-modal' });
    modalRef.componentInstance.msg = msg;
  }

}
