package com.example.administrator.databasesave.mvp;

import rx.Observable;

/**
 * <pre>
 *
 *   author   :   Alex
 *   e_mail   :   18238818283@sina.cn
 *   timr     :   2017/09/05
 *   desc     :
 *   version  :   V 1.0.5
 */
public interface Model_User<T> {

    Observable<T>  getUserList();

}
