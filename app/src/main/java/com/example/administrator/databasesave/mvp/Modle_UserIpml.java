package com.example.administrator.databasesave.mvp;
import com.example.administrator.databasesave.L;
import com.example.administrator.databasesave.mvp.base.BasePresent;
import java.util.ArrayList;
import rx.Observable;
import rx.Subscriber;

/**
 * <pre>
 *
 *   author   :   Alex
 *   e_mail   :   18238818283@sina.cn
 *   timr     :   2017/09/05
 *   desc     :
 *   version  :   V 1.0.5
 */
public class Modle_UserIpml implements Model_User<ArrayList<Userbean>> {

    private BasePresent present;

    public Modle_UserIpml(BasePresent present) {
        this.present = present;
    }

    @Override
    public Observable<ArrayList<Userbean>> getUserList() {

        return Observable.create(new Observable.OnSubscribe<ArrayList<Userbean>>() {
            @Override
            public void call(Subscriber<? super ArrayList<Userbean>> subscriber) {
                ArrayList<Userbean> userbeanList = new ArrayList<Userbean>();
                for (int i=0; i<5;i++){
                    Userbean userbean = new Userbean("AA"+i,i+"0");
                    userbeanList.add(userbean);
                }
              L.e("listsize===",userbeanList.size()+"===");
                subscriber.onNext(userbeanList);
            }
        });
    }
}
