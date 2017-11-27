import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Item } from '../models/item';


@Injectable()
export class ItemService {

  constructor(private http: HttpClient) { }

  addItem(item: Item) {
    return this.http.post('http://localhost:8080/' + item.itemType + '/', item);
  }

  getRecipeItems(id: number) {
    return this.http.get('http://localhost:8080/recipeItem/restaurant/' + id);
  }

  getDrinkItems(id: number) {
    return this.http.get('http://localhost:8080/drinkItem/restaurant/' + id);
  }

  getSideItems(id: number) {
    return this.http.get('http://localhost:8080/sideItem/restaurant/' + id);
  }
}
