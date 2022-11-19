import { TestBed } from '@angular/core/testing';

import { EditorialService } from './editorial.service';

describe('EditorialService', () => {
  let service: EditorialService;
  let spy:any;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EditorialService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
  /*
  it ('should not be null', ()=>{
    spy=spyOn(service, "editoriallist").and.returnValues
    const result=service.editoriallist()
    expect(result).not.toBeNull;
   })*/

   


});
