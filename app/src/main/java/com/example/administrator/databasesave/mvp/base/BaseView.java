package com.example.administrator.databasesave.mvp.base;

import com.example.administrator.databasesave.mvp.Userbean;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 *   author   :   Alex
 *   e_mail   :   18238818283@sina.cn
 *   timr     :   2017/09/05
 *   desc     :
 *   version  :   V 1.0.5
 */
public interface  BaseView<T> {

     void onSuccess( ArrayList<T> userbeen);
      void onFaild(String e);


}
