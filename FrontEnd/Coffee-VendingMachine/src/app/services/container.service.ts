import { HttpClient } from '@angular/common/http';
import { Container } from '../models/container';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ContainerService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'Bearer token' 
    })
  };

  baseUrl = environment.apiUrl;
  //baseUrl = "http://ec2-18-221-157-116.us-east-2.compute.amazonaws.com:5000";
  
  constructor(private httpc:HttpClient, private authService:AuthenticationService) {
   }

  getAvailableContainerValue():Observable<Container>{
    const uri= this.baseUrl + "/containers/1";
    return this.httpc.get<Container>(uri, this.httpOptions);
  }
  getMaxContainerValue():Observable<Container>{
    const uri= this.baseUrl + "/containers/2";
    return this.httpc.get<Container>(uri, this.httpOptions);
  }
  updateCurrentContainer(ctn: any):Observable<string>{
    const uri= this.baseUrl + "/containers/1";
    this.setHttpHeader();
    return this.httpc.put<string>(uri,ctn,this.httpOptions);
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
