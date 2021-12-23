import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs'; 
import { JWTTokenService } from './jwttoken.service';
import { LocalStorageService } from './local-storage.service';
import { SigninService } from './signin.service';

@Injectable({
  providedIn: 'root'
})
export class AuthorizeGuard implements CanActivate {
  constructor(private signinService: SigninService,
              private authStorageService: LocalStorageService,
              private jwtService: JWTTokenService,
              private router: Router) {
  }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable | Promise | boolean {
      if (this.jwtService.getUser()) {
          if (this.jwtService.isTokenExpired()) {
            this.router.navigate(['/signin']);
          } else {
            return true;
          }
      } else {
        return new Promise((resolve) => {
          this.signinService.signIncallBack().then((e) => {
             resolve(true);
          }).catch((e) => {
            this.router.navigate(['/signin']);
          });
        });
      }
  }
}