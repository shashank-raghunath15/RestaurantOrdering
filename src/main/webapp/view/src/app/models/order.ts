import { Customer } from './customer';
import { Restaurant } from './restaurant';
import { Item } from './item';

export class Order {

  id: number;
  customer: Customer;
  restaurant: Restaurant;
  items: Item[];
  totalPrice: number;

  constructor() {
    this.totalPrice = 0.0;
  }
}
