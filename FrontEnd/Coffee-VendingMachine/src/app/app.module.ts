import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RefillingFormComponent } from './ui/refilling-form/refilling-form.component';
import { ChooseDrinkComponent } from './ui/choose-drink/choose-drink.component';
import { RouterModule } from '@angular/router';
import { ContainerStatusComponent } from './ui/container-status/container-status.component';
import { ReportOptionComponent } from './ui/report-option/report-option.component';
import { ReactiveFormsModule, FormsModule} from '@angular/forms';
import { SaleListDetailComponent } from './ui/sale-list-detail/sale-list-detail.component';
import { RefillingDetailComponent } from './ui/refilling-detail/refilling-detail.component';
import { LoginComponent } from './ui/login/login.component';
import { SignupComponent } from './ui/signup/signup.component';
import { HeaderComponent } from './ui/header/header.component';


@NgModule({
  declarations: [
    AppComponent,
    RefillingFormComponent,
    ChooseDrinkComponent,
    ContainerStatusComponent,
    ReportOptionComponent,
    SaleListDetailComponent,
    RefillingDetailComponent,
    LoginComponent,
    SignupComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [
    AppComponent,
    HeaderComponent
  ]
})
export class AppModule { }
