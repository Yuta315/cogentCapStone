import { Component, OnInit } from '@angular/core';
import { shareReplay } from 'rxjs/operators';
import { Refill } from 'src/app/models/refill';
import { RefillService } from 'src/app/services/refill.service';

@Component({
  selector: 'app-refilling-detail',
  templateUrl: './refilling-detail.component.html',
  styleUrls: ['./refilling-detail.component.css']
})
export class RefillingDetailComponent implements OnInit {
  allRf = new Refill;
  todayRf = new Refill;

  constructor(private rs:RefillService) { }

  ngOnInit(): void {
    this.getAllRefill();
    this.getTodayRefill();
  }
  private getAllRefill(){
    this.rs.getRefillList().subscribe(rf => {
      rf.forEach(sr => {
        this.allRf.teaRefill += (sr.teaRefill!=0 ? 1 : 0);
        this.allRf.coffeeRefill += (sr.coffeeRefill!=0 ? 1 : 0);
        this.allRf.milkRefill += (sr.milkRefill!=0 ? 1 : 0);
        this.allRf.sugarRefill += (sr.sugarRefill!=0 ? 1 : 0);
        this.allRf.waterRefill += (sr.waterRefill!=0 ? 1 : 0);
      })
    });
  }

  private getTodayRefill(){
    this.rs.getRefillToday().subscribe(rf => {
      rf.forEach(sr => {
        this.todayRf.teaRefill += (sr.teaRefill!=0 ? 1 : 0);
        this.todayRf.coffeeRefill += (sr.coffeeRefill!=0 ? 1 : 0);
        this.todayRf.milkRefill += (sr.milkRefill!=0 ? 1 : 0);
        this.todayRf.sugarRefill += (sr.sugarRefill!=0 ? 1 : 0);
        this.todayRf.waterRefill += (sr.waterRefill!=0 ? 1 : 0);
      })
    })
  }
}
