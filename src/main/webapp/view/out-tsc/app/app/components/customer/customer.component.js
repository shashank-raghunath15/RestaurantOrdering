var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalComponent } from '../../components/modal/modal.component';
import { RestaurantService } from '../../services/restaurant.service';
import { CustomerService } from '../../services/customer.service';
import { Order } from '../../models/order';
import { ActivatedRoute } from '@angular/router';
import { OrderService } from '../../services/order.service';
let CustomerComponent = class CustomerComponent {
    // tslint:disable-next-line:max-line-length
    constructor(route, modalService, restaurantService, customerService, activatedRoute, orderService) {
        this.route = route;
        this.modalService = modalService;
        this.restaurantService = restaurantService;
        this.customerService = customerService;
        this.activatedRoute = activatedRoute;
        this.orderService = orderService;
        this.orderItems = new Array();
        this.order = new Order();
        restaurantService.getAllRestaurants().subscribe((res) => {
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
        this.customerService.getOrders(this.customer.id).subscribe((res) => {
            this.pastOrders = res;
        }, error => { });
    }
    loadItems(restaurant) {
        this.showItems = false;
        this.items = restaurant.availableItems;
        this.restaurant = restaurant;
        this.order.restaurant = restaurant;
        this.showItems = true;
    }
    addItemToOrder(id) {
        const item = this.items.filter(itm => itm.id === id['id'])[0];
        this.orderItems.push(item);
        this.order.totalPrice += item.price;
        this.message(item.name + ' added to cart successfully');
    }
    doneItems() {
        this.order.items = this.orderItems;
        this.order.customer = this.customer;
        this.restaurantService.applyDeal(this.order).subscribe((res) => {
            this.order = res;
            this.show = 'order';
        }, error => { });
    }
    message(msg) {
        const modalRef = this.modalService.open(ModalComponent, { windowClass: 'dark-modal' });
        modalRef.componentInstance.msg = msg;
    }
    orderDone() {
        this.orderService.addOrder(this.order).subscribe((res) => {
            this.message('Order successfull. Your Order Id is: ' + res.id);
            this.show = 'items';
            this.order = new Order();
            this.orderItems = new Array();
            this.order.restaurant = this.restaurant;
            this.route.navigateByUrl('customer');
        });
    }
    reOrder(order) {
        this.orderService.reOrder(order).subscribe((res) => {
            this.message('Order successfull. Your Order Id is: ' + res.id);
            this.show = 'items';
            this.route.navigateByUrl('customer');
        });
    }
    recordfeedBack(customer) {
        this.customer.feedBack = customer.feedBack;
        this.customerService.recordFeedBack(this.customer).subscribe((cus) => {
            this.show = 'items';
            this.message('We appreciate your feedback. It has been recorded successfully');
            this.route.navigateByUrl('customer');
        });
    }
};
CustomerComponent = __decorate([
    Component({
        selector: 'app-customer',
        templateUrl: './customer.component.html',
        styleUrls: ['./customer.component.css']
    }),
    __metadata("design:paramtypes", [Router, NgbModal, RestaurantService, CustomerService, ActivatedRoute, OrderService])
], CustomerComponent);
export { CustomerComponent };
//# sourceMappingURL=customer.component.js.map