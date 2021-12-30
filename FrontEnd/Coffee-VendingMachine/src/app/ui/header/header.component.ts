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
  isLogin:boolean=false;
  constructor(private router:Router, private authService:AuthenticationService) { 
  }

  ngOnInit(): void {
    this.authService.currentUser.subscribe(user =>{
        if (user==null)
      { 
        this.isLogin=false;
        //document.getElementById("logBtn").innerHTML="Login";
        this.userInfo = '';
        document.getElementById("adminTag").style.visibility="hidden";
      }
      else
      { 
        this.isLogin=true;
        console.log(this.isLogin);
        this.userInfo = `${user.username}[${user.roles[0]}]`;
        if (`${user.roles[0]}` == 'ADMIN') {
          document.getElementById('adminTag').style.visibility = 'visible';
        }
       // document.getElementById("logBtn").innerHTML="Logout";
       // document.getElementById("adminTag").style.visibility="visible";
      }
    });
    
  }
 /* isLoggin(){

    if(this.authService.currentUser ==null)
    { this.isLogin = false;} else{this.isLogin = true}

  }*/

  goToSigninPage(){
    /*this.authService.currentUser.subscribe(user=>
      {
        if (user==null){ */
          this.router.navigate(['/login']);
        //}
       /* else {
          document.getElementById("logBtn").innerHTML="Login";
          this.authService.logout();
        }
      }) */
  }

  logout(){
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
