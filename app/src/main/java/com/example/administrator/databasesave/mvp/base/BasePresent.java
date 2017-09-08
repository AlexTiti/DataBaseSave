package com.example.administrator.databasesave.mvp.base;

import android.app.Activity;
import android.view.View;

import com.example.administrator.databasesave.mvp.Userbean;

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
public abstract class BasePresent<T> {



    Activity view;
  public   void attchView (Activity view){
        this.view = view;
    }

  public   void destroyView (){
        view = null;
    }

    public Activity getView(){
        return view;
    }

    public boolean isAttchView(){

        return view == null ? false : true;
    }

    public abstract void  dealWithData();

}
