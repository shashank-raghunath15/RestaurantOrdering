import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import {AppComponent} from './app.component';
import {LoginComponent} from './components/login/login.component';
import {LoginService} from './services/login.service';
import {AdminService} from './services/admin.service';
import {CustomerService} from './services/customer.service';
import {RestaurantOwnerService} from './services/restaurant-owner.service';
import {RestaurantService} from './services/restaurant.service';
import {ItemService} from './services/item.service';
import {DealService} from './services/deal.service';
import { AdminComponent } from './components/admin/admin.component';
import { CustomerComponent } from './components/customer/customer.component';
import { RestaurantOwnerComponent } from './components/restaurant-owner/restaurant-owner.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminComponent,
    CustomerComponent,
    RestaurantOwnerComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [LoginService, AdminService, CustomerService, RestaurantOwnerService, RestaurantService, DealService, ItemService],
  bootstrap: [AppComponent]
})
export class AppModule {}
