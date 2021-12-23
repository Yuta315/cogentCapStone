import { Container } from 'src/app/models/container';
import { ContainerService } from 'src/app/services/container.service';
import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-container-status',
  templateUrl: './container-status.component.html',
  styleUrls: ['./container-status.component.css']
})
export class ContainerStatusComponent implements OnInit {

  maxCtn: Container = new Container;
  availableCtn: Container = new Container;
  constructor(private cs:ContainerService, private router:Router, private authService:AuthenticationService) { }

  ngOnInit(): void {
    this.authService.currentUser.subscribe(user =>{
      if (user==null){
        document.getElementById("ctnStatus").style.visibility="hidden";
      }
      else{
        document.getElementById("ctnStatus").style.visibility="visible";
        this.cs.getMaxContainerValue().subscribe(c => {this.maxCtn=c});
        this.cs.getAvailableContainerValue().subscribe(c => {this.availableCtn=c});
      }
    })
  }
}
