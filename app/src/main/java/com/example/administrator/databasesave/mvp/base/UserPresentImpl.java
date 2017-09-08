package com.example.administrator.databasesave.mvp.base;

import android.widget.Toast;

import com.example.administrator.databasesave.L;
import com.example.administrator.databasesave.mvp.Model_User;
import com.example.administrator.databasesave.mvp.Modle_UserIpml;
import com.example.administrator.databasesave.mvp.Userbean;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * <pre>
 *
 *   author   :   Alex
 *   e_mail   :   18238818283@sina.cn
 *   timr     :   2017/09/05
 *   desc     :
 *   version  :   V 1.0.5
 */
public class UserPresentImpl extends BasePresent<List<Userbean>> {

    Modle_UserIpml model_user = new Modle_UserIpml(this);
    BaseView<Userbean> baseView ;

    public UserPresentImpl(BaseView<Userbean> baseView) {
        this.baseView = baseView;
    }

    @Override
    public void dealWithData() {

        if (!isAttchView()) {
            L.e("isAttchView", "no=========");
            return;
        }

        model_user.getUserList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArrayList<Userbean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        baseView.onFaild(e.toString());
                        onCompleted();

                    }

                    @Override
                    public void onNext(ArrayList<Userbean> userbeen) {
                        baseView.onSuccess(userbeen);

                    }
                });

    }
}
