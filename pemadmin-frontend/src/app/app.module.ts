import { NgModule } from '@angular/core'
import { RouterModule } from '@angular/router';
import { rootRouterConfig } from './app.routes';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { CookieService } from 'angular2-cookie/core';

import {TopNavbarComponent} from "./component/widgets/top-navbar.component";
import {OffsidebarComponent} from "./component/widgets/offsidebar.component";
import {FooterComponent} from "./component/widgets/footer.component";
import {SettingComponent} from "./component/widgets/setting.component";
import {UrlUtils} from "./utils/url.util";
import {DateUtils} from "./utils/date.util";

@NgModule({
  declarations: [
    AppComponent,
    OffsidebarComponent,
    TopNavbarComponent,
    SettingComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    RouterModule.forRoot(rootRouterConfig, { useHash: true })
  ],
  providers: [
    UrlUtils,
    CookieService,
    DateUtils
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule {

}
