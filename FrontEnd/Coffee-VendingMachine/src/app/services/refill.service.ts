import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Refill } from '../models/refill';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RefillService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'Bearer '
    })
  };
  baseUrl = environment.apiUrl;
  //baseUrl = "http://ec2-18-221-157-116.us-east-2.compute.amazonaws.com:5000";
  constructor(private httpc:HttpClient, private authService:AuthenticationService) { }

  getRefillList():Observable<Refill[]>{
    const uri= this.baseUrl + "/refills/search/all";
    this.setHttpHeader();
    return this.httpc.get<Refill[]>(uri, this.httpOptions);
  }

  getRefillToday():Observable<Refill[]>{
    const uri= this.baseUrl + "/refills/search/today";
    this.setHttpHeader();
    return this.httpc.get<Refill[]>(uri, this.httpOptions);
  }

  addRefill(rf: any):Observable<Refill>{
    const uri= this.baseUrl + "/refills/add";
    this.setHttpHeader();
    return this.httpc.post<Refill>(uri,rf,this.httpOptions);
  }

  setHttpHeader(){
    //console.log(this.cookie.get('accessToken'));
    this.authService.currentUser.subscribe(user =>
      {this.httpOptions = {
        headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': `Bearer ${user.accessToken}`  
      })};
    })
  }
}
