import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Drink } from 'src/app/models/drink';
import { SaleList } from 'src/app/models/sale-list';
import { DrinkService } from 'src/app/services/drink.service';
import { SaleListService } from 'src/app/services/sale-list.service';

@Component({
  selector: 'app-sale-list-detail',
  templateUrl: './sale-list-detail.component.html',
  styleUrls: ['./sale-list-detail.component.css']
})
export class SaleListDetailComponent implements OnInit {
  saleList: SaleList[]=[];
  drinkSaleList: Drink[]=[];
  number_of_cup: number = 0;
  total_cost: number = 0;
  isToday: boolean = false;

  constructor(private sl: SaleListService, private route:ActivatedRoute, private ds: DrinkService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(()=>{
      if (this.route.snapshot.paramMap.get('date')==='today')  this.isToday=true;
      this.getSaleByDrink();
    });
  }

  // //Get list of sales in details
  // private getSaleDetails(){
  //   this.sl.getSaleList().subscribe( list =>{
  //       this.saleList=list;
  //       this.saleList.forEach(dt => {
  //         this.number_of_cup += dt.numberOfCup;
  //         this.ds.getDrink(dt._links.drink.href).subscribe(dr => {
  //           this.total_cost += dr.cost*dt.numberOfCup;
  //           dt.tmpDrink=dr;
  //         });
  //       })
  //     }
  //   );
  // }
  //Get list of sales by drink
  private getSaleByDrink(){
    this.ds.getDrinkList().subscribe(dr => {
      this.drinkSaleList = dr;
      this.drinkSaleList.forEach( dsl =>  {
        dsl.totalCup = 0;
        this.sl.getDrinkSaleList(dsl.id, this.isToday).subscribe(sl => {
          sl.forEach(s =>{
            dsl.totalCup += s.numberOfCup;
          });
          this.number_of_cup += dsl.totalCup;
          this.total_cost += dsl.totalCup*dsl.cost;
        });
      })
    })
    }

}
