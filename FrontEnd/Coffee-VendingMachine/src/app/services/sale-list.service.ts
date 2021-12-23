import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { SaleList } from '../models/sale-list';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { AuthenticationService } from './authentication.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SaleListService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'Bearer token'
    })
  };
  baseUrl = environment.apiUrl;
  //baseUrl = "http://ec2-18-221-157-116.us-east-2.compute.amazonaws.com:5000";
  
  constructor(private httpc:HttpClient, private authService:AuthenticationService) { }

  addSaleList(sl: any):Observable<SaleList>{
    const uri= this.baseUrl + "/saleLists/add";
    return this.httpc.post<SaleList>(uri,sl,this.httpOptions);
  }

  getDrinkSaleList(id: number, isToday: boolean):Observable<SaleList[]>{
    let uri = this.baseUrl+"/saleLists/search/"+id;
    if (isToday) 
      uri = this.baseUrl+"/saleLists/search/today/"+id;
      this.setHttpHeader();
    return this.httpc.get<SaleList[]>(uri, this.httpOptions);
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
