import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginRfComponent } from './login-rf.component';

describe('LoginRfComponent', () => {
  let component: LoginRfComponent;
  let fixture: ComponentFixture<LoginRfComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginRfComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginRfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
