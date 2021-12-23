import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  userInfo = "";
  constructor(private router:Router, private authService:AuthenticationService) { 
  }

  ngOnInit(): void {
    this.authService.currentUser.subscribe(user =>{
        if (user==null)
      { 
        document.getElementById("logBtn").innerHTML="Login";
        document.getElementById("adminTag").style.visibility="hidden";
      }
      else
      { 
        this.userInfo = `${user.username}[${user.roles[0]}]`;
        document.getElementById("logBtn").innerHTML="Logout";
        document.getElementById("adminTag").style.visibility="visible";
      }
    });
    
  }
  goToSigninPage(){
    this.authService.currentUser.subscribe(user=>
      {
        if (user==null){
          this.router.navigate(['/login']);
        }
        else {
          document.getElementById("logBtn").innerHTML="Login";
          this.authService.logout();
        }
      })
  }
}
