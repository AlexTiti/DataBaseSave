package com.example.administrator.databasesave;

import android.graphics.Bitmap;
import android.text.Html;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observers.Observers;
import rx.schedulers.Schedulers;

/**
 * <pre>
 *
 *   author   :   Alex
 *   e_mail   :   18238818283@sina.cn
 *   timr     :   2017/08/15
 *   desc     :
 *   version  :   V 1.0.5
 */
public class Ac {
    public void action(){


        Observable.just("BBBBBBBBBBBBBB").map(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {

                return s.hashCode();
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {


            }
        });


        ArrayList<String > list = new ArrayList() ;
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("DDDDD");

        Observable.just(list).flatMap(new Func1<ArrayList<String>, Observable<?>>() {
            @Override
            public Observable<?> call(ArrayList<String> stringArrayList) {
                return null;
            }
        });



    }

}
