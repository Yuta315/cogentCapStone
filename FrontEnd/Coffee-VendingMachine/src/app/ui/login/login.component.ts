import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { JWTTokenService } from 'src/app/services/jwttoken.service';
import { SigninService } from 'src/app/services/signin.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  error:string;
  success:string;
  alert_type:string;
  loading = false;
  submitted = false;

  constructor( private router:Router, private authService:AuthenticationService) { }

  ngOnInit(): void {
  }

  doSignin(signinForm:any){
    this.submitted = true;
    this.loading = true;
    var signinValue = JSON.stringify(signinForm.value);
    //console.log(signinValue);
    this.authService.login(signinValue).pipe(first()).subscribe(data => {
        this.success = "Login Successfully!"
        this.router.navigate(['/drinks']);
      },
        error =>{
          this.error = "Username or password is incorrect. Please try again!";
          this.loading = false;
        }
        );
  }
  hideAlert(){
    document.getElementById("alert_msg").style.visibility="hidden";
  }
}
