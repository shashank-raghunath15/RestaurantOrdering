import { Restaurant } from './restaurant';
import { Deal } from './deal';

export interface AmountDiscountDeal extends Deal {
    eligibilityAmount: number;
}
