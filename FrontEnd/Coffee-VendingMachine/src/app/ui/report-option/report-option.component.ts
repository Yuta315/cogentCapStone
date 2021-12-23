import { Component, OnInit } from '@angular/core';
import { Container } from 'src/app/models/container';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ContainerService } from 'src/app/services/container.service';
import { JWTTokenService } from 'src/app/services/jwttoken.service';

@Component({
  selector: 'app-report-option',
  templateUrl: './report-option.component.html',
  styleUrls: ['./report-option.component.css']
})
export class ReportOptionComponent implements OnInit {

  maxCtn: Container;
  availableCtn: Container;
  constructor(private cs:ContainerService, private authService:AuthenticationService) { }

  ngOnInit(): void {
    this.authService.currentUser.subscribe(user=>
    {
      if (user==null) 
        document.getElementById("reportTB").style.visibility="hidden";
      else {
        document.getElementById("reportTB").style.visibility="visible";
        this.cs.getMaxContainerValue().subscribe(c => {this.maxCtn=c});
        this.cs.getAvailableContainerValue().subscribe(c => {this.availableCtn=c});
      }
    })
  }

}
