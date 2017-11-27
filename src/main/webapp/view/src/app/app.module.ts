import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { LoginService } from './services/login.service';
import { AdminService } from './services/admin.service';
import { CustomerService } from './services/customer.service';
import { RestaurantOwnerService } from './services/restaurant-owner.service';
import { RestaurantService } from './services/restaurant.service';
import { ItemService } from './services/item.service';
import { DealService } from './services/deal.service';
import { AdminComponent } from './components/admin/admin.component';
import { CustomerComponent } from './components/customer/customer.component';
import { RestaurantOwnerComponent } from './components/restaurant-owner/restaurant-owner.component';
import { NotFoundComponent } from './components/not-found/not-found.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminComponent,
    CustomerComponent,
    RestaurantOwnerComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: 'admin', component: AdminComponent },
      { path: 'customer', component: CustomerComponent },
      { path: 'restaurantOwner', component: RestaurantOwnerComponent },
      { path: '', component: LoginComponent },
      { path: '**', component: NotFoundComponent }
    ])
  ],
  providers: [LoginService, AdminService, CustomerService, RestaurantOwnerService, RestaurantService, DealService, ItemService],
  bootstrap: [AppComponent]
})
export class AppModule { }
