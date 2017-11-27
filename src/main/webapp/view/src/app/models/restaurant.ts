import { RestaurantOwner } from './restaurantOwner';
import { Item } from './item';
import { Deal } from './deal';

export interface Restaurant {
  id: number;
  name: string;
  address: string;
  owner: RestaurantOwner;
  availableItems: Item[];
  availableDeals: Deal[];
  closedDays: string[];
}
