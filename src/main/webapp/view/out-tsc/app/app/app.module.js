var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
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
import { LogoutComponent } from './components/logout/logout.component';
let AppModule = class AppModule {
};
AppModule = __decorate([
    NgModule({
        declarations: [
            AppComponent,
            LoginComponent,
            AdminComponent,
            CustomerComponent,
            RestaurantOwnerComponent,
            NotFoundComponent,
            LogoutComponent
        ],
        imports: [
            BrowserModule,
            FormsModule,
            HttpClientModule,
            NgbModule.forRoot(),
            RouterModule.forRoot([
                { path: 'logout', component: LogoutComponent },
                { path: 'admin', component: AdminComponent },
                { path: 'addItem', component: AdminComponent, data: { show: 'item' } },
                { path: 'addOwner', component: AdminComponent, data: { show: 'owner' } },
                { path: 'addRestaurant', component: AdminComponent, data: { show: 'restaurant' } },
                { path: 'customer', component: CustomerComponent },
                { path: 'restaurantOwner', component: RestaurantOwnerComponent },
                { path: 'addItemRestaurant', component: RestaurantOwnerComponent, data: { show: 'item' } },
                { path: 'addDealRestaurant', component: RestaurantOwnerComponent, data: { show: 'deal', deal: 'amt' } },
                { path: 'addAmtDeal', component: RestaurantOwnerComponent, data: { show: 'deal', deal: 'amt' } },
                { path: 'addMealDeal', component: RestaurantOwnerComponent, data: { show: 'deal', deal: 'meal' } },
                { path: '', component: LoginComponent },
                { path: '**', component: NotFoundComponent }
            ])
        ],
        providers: [LoginService, AdminService, CustomerService, RestaurantOwnerService, RestaurantService, DealService, ItemService],
        bootstrap: [AppComponent]
    })
], AppModule);
export { AppModule };
//# sourceMappingURL=app.module.js.map