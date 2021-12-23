import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Drink } from '../models/drink';
import { HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class DrinkService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'Bearer token'
    })
  };
  baseUrl = environment.apiUrl;
  //baseUrl = "http://ec2-18-221-157-116.us-east-2.compute.amazonaws.com:5000";
  
  constructor(private httpc:HttpClient, private authService:AuthenticationService) { }

  getDrink(uri: string):Observable<Drink>{
    return this.httpc.get<Drink>(uri, this.httpOptions);
  }
  getDrinkList():Observable<Drink[]>{
    const uri = this.baseUrl + "/drinks";
    return this.httpc.get<Drink[]>(uri, this.httpOptions);
  }
}