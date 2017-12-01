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
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalComponent } from '../../components/modal/modal.component';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  admin: Admin;
  show: string;
  owners: RestaurantOwner[];

  // tslint:disable-next-line:max-line-length
  constructor(private route: Router, private ownerService: RestaurantOwnerService, private itemService: ItemService, private restaurantService: RestaurantService, private activatedRoute: ActivatedRoute, private modalService: NgbModal) {
    activatedRoute.data.subscribe((val => {
      this.show = val.show;
    }));
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
      this.message('Owner added successfully');
      this.route.navigateByUrl('admin');
    },
      error => {
        this.message('Owner with username already exists');
      });
  }
  addItem(item: Item) {
    this.itemService.addItem(item).subscribe(res => {
      this.message('Item added successfully');
      this.route.navigateByUrl('admin');
    },
      error => {
        this.message('Item with name already exists');
      });
  }
  addRestaurant(restaurant: Restaurant) {
    this.restaurantService.addRestaurant(restaurant).subscribe(res => {
      this.message('Restaurant added successfully');
      this.route.navigateByUrl('admin');
    },
      error => {
        this.message('Restaurant with name already exists');
      });
  }

  message(msg: string) {
    const modalRef = this.modalService.open(ModalComponent, { windowClass: 'dark-modal' });
    modalRef.componentInstance.msg = msg;
  }
}
