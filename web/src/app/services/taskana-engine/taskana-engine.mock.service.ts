import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { environment } from 'environments/environment';
import { UserInfoModel } from 'app/models/user-info';
import { ReplaySubject } from 'rxjs/ReplaySubject';


@Injectable()
export class TaskanaEngineServiceMock {

  currentUserInfo: UserInfoModel;

  constructor(
  ) {
    this.getUserInformation();
  }

  // GET
  getUserInformation(): Promise<any> {
    this.currentUserInfo = new UserInfoModel('userid', [''], ['admin']);
    return Observable.of().toPromise();
  }

  hasRole(roles2Find: Array<string>): boolean {
    if (!this.currentUserInfo || this.currentUserInfo.roles.length < 1) {
      return false;
    }
    if (this.findRole(roles2Find)) {
      return true;
    }
    return false;
  }

  private findRole(roles2Find: Array<string>) {
    return this.currentUserInfo.roles.find(role => {
      return roles2Find.some(roleLookingFor => {
        if (role === roleLookingFor) {
          return true;
        }
      });
    });
  }
}
