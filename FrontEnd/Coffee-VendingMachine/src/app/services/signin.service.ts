import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { JWTTokenService } from './jwttoken.service';
import { HttpHeaders } from '@angular/common/http';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class SigninService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'token'
    })
  };

  constructor(private httpc: HttpClient) { }

      baseUrl = "http://localhost:5000";
  requestToken(up: any):Observable<User>{
    const uri = this.baseUrl+"/api/auth/signin";
    return this.httpc.post<User>(uri,up,this.httpOptions);
  }

}


