import { Customer } from './customer';
import { Restaurant } from './restaurant';
import { Item } from './item';
import { Deal } from './deal';

export class Order {

  id: number;
  customer: Customer;
  restaurant: Restaurant;
  items: Item[];
  deal: Deal;
  totalPrice: number;

  constructor() {
    this.totalPrice = 0.0;
  }
}
