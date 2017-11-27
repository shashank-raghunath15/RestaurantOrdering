import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Item } from '../models/item';


@Injectable()
export class ItemService {

  constructor(private http: HttpClient) { }

  addItem(item: Item) {
    return this.http.post('http://localhost:8080/' + item.itemType + '/', item);
  }

}
