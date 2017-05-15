import { Injectable } from '@angular/core';
declare var is:any;
@Injectable()
export class DateUtils {

    getFormateDateStart(date){

        if(date){
            date = date.replace("年","-").replace("月","-").replace("日","-");
            date.substring(0,10)+" 00:00:00";
        }
        return date;
    }

    getFormateDateEnd(date){
        if(date){
            date = date.replace("年","-").replace("月","-").replace("日","-");
            date.substring(0,10)+" 23:59:59";
        }
        return date;
    }

  //转换时间格式为XXXX年XX月XX日 字符串数组
  formatDate (date){
    if(!is.empty(date)){
      let  formatedDate : any;
      formatedDate = date.toLocaleDateString();
      let parts:string[]= formatedDate.split("/");
      formatedDate = parts[0]+"年"+parts[1]+"月"+parts[2]+"日";
      return formatedDate;
    }
  }

    //转换时间格式为XXXX-XX-XX 字符串数组
    transformDates(date){

        if(date){

            var dates = date.split(' - ');
            var startDate = dates[0];
            var endDate = dates[1];
            startDate = startDate.replace("年","-").replace("月","-").replace("日","-");
            endDate = endDate.replace("年","-").replace("月","-").replace("日","-");
            dates[0] = startDate.substr(0,10)+" 00:00:00";
            dates[1] = endDate.substr(0,10)+" 23:59:59";
            return dates;
        }
    }
}
