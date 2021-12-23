import { Container } from 'src/app/models/container';
import { Component, OnInit } from '@angular/core';
import { ContainerService } from 'src/app/services/container.service';
import { RefillService } from 'src/app/services/refill.service';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-refilling-form',
  templateUrl: './refilling-form.component.html',
  styleUrls: ['./refilling-form.component.css']
})
export class RefillingFormComponent implements OnInit {
  maxCtn: Container = new Container;
  availableCtn: Container = new Container;
  dates:string = (new Date).toISOString();
  msg:string = "";
  alert_type = "alert-light";  

  constructor(private cs: ContainerService, private rs: RefillService, private authService:AuthenticationService) { }

  ngOnInit(): void {
      //console.log(this.cookie.get("accessToken"));
    this.authService.currentUser.subscribe(user =>
      {
        if (user==null){
          document.getElementById("refillContent").style.visibility="hidden";
        }
        else{
          document.getElementById("refillContent").style.visibility="visible";
          this.cs.getMaxContainerValue().subscribe(c => {this.maxCtn=c});
          this.cs.getAvailableContainerValue().subscribe(c => {this.availableCtn=c});
        }

      })
  }

  addRefill(refillForm){
    this.dates = (new Date).toISOString();
    refillForm.value.teaRefill = refillForm.value.teaRefill*1000;
    refillForm.value.coffeeRefill = refillForm.value.coffeeRefill*1000;
    refillForm.value.waterRefill = refillForm.value.waterRefill*1000;
    refillForm.value.sugarRefill = refillForm.value.sugarRefill*1000;
    refillForm.value.milkRefill = refillForm.value.milkRefill*1000;
    refillForm.value.date = (new Date).toISOString();
    var rf  = JSON.stringify(refillForm.value);
    //check if filling value is valid
    if (refillForm.value.teaRefill>0 || refillForm.value.coffeeRefill>0 ||
      refillForm.value.waterRefill>0 || refillForm.value.sugarRefill>0 ||
      refillForm.value.milkRefill>0){
        //console.log(rf);
        //save a record for refill
        this.rs.addRefill(rf).subscribe(rs =>{ 
          this.msg = (rs.refillId!=0)? "Containers are refilled successfully!":"Errors!";
        //reload available containers status
          this.cs.getAvailableContainerValue().subscribe(c => {this.availableCtn=c});
      });
        this.alert_type = "alert-success";
      }
    else {
      this.msg="Please enter the refill amount!";
      this.alert_type = "alert-warning";
    }
    this.msg="Refilling..."
    document.getElementById("alert_msg").style.visibility = "visible";
  }

  hideAlert(){
    document.getElementById("alert_msg").style.visibility="hidden";
  }
}
