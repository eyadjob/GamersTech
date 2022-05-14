import { TestBed } from '@angular/core/testing';

import { GamersFunService } from './gamers-fun.service';

describe('GamersFunService', () => {
  let service: GamersFunService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GamersFunService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
