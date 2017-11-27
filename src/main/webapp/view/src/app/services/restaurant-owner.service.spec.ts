import { TestBed, inject } from '@angular/core/testing';

import { RestaurantOwnerService } from './restaurant-owner.service';

describe('RestaurantOwnerService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RestaurantOwnerService]
    });
  });

  it('should be created', inject([RestaurantOwnerService], (service: RestaurantOwnerService) => {
    expect(service).toBeTruthy();
  }));
});
