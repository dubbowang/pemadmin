import {Injectable} from '@angular/core';

@Injectable()
export class UrlUtils {

  public rootUrl: string = "/pemadmin/";

  getContextRoot() {
    return this.rootUrl;
  }

  getBackendApiUrl(api: string) {
    return this.rootUrl + api;
  }

  addQueryString(url: string, param: string, val: any) {
    if (url.indexOf('?') >= 0) {
      url += "&" + param + "=" + val;
    } else {
      url += "?" + param + "=" + val;
    }
    return url;
  }

}
