import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../../models/customer';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalComponent } from '../../components/modal/modal.component';
@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customer: Customer;
  constructor(private route: Router, private modalService: NgbModal) { }

  ngOnInit() {
    if (sessionStorage.getItem('role') !== 'customer') {
      this.route.navigateByUrl('');
    }
    this.customer = JSON.parse(sessionStorage.getItem('user'));
  }
  message(msg: string) {
    const modalRef = this.modalService.open(ModalComponent, { windowClass: 'dark-modal' });
    modalRef.componentInstance.msg = msg;
  }
}
