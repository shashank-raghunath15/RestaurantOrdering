import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AmountDiscountDeal } from '../models/amountDiscountDeal';
import { MealDiscountDeal } from '../models/mealDiscountDeal';

@Injectable()
export class DealService {

  constructor(private http: HttpClient) { }

  addMealDeal(id: number, mealDeal: MealDiscountDeal) {
    return this.http.post('http://localhost:8080/mealDiscountDeal/restaurant/' + id, mealDeal);
  }

  addAmtDeal(id: number, amtDeal: AmountDiscountDeal) {
    return this.http.post('http://localhost:8080/amountDiscountDeal/restaurant/' + id, amtDeal);
  }
}
