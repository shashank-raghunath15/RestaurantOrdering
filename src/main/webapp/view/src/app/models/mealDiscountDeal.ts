import { Restaurant } from './restaurant';
import { Deal } from './deal';

export interface MealDiscountDeal extends Deal {
    id: number;
    discountAmount: number;
}
