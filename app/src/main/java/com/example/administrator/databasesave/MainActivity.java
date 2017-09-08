package com.example.administrator.databasesave;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Single;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    TextView textView ,text_path_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_hello);
      text_path_main = (TextView) findViewById(R.id.text_path_main);
//
//        DBFile dbFile = new DBFile(this);
//        File file = dbFile.createFileDirInFileDir("dbFile");
//        File crashFile = dbFile.creatCacshFileDirInCrashFile("crashFile");
//        textView.setText(file.getPath());
//        text_path_main.setText(crashFile.getPath());
//        File file1 = dbFile.creatCrashFile("https://dn-prnpraln.qbox.me/ea62070e2fd41e221782.mp3");
//        L.e(file1.getAbsolutePath());

        // UserManger userManger = UserManger.getInstance(getApplication());

      final   ArrayList<String> list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");

        testRetorfit();

//        Observable.just(list).flatMap(new Func1<ArrayList<String>, Observable<?>>() {
//            @Override
//            public Observable<?> call(ArrayList<String> stringArrayList) {
//                return Observable.from(stringArrayList);
//            }
//        }).map(new Func1<Object, Integer>() {
//            @Override
//            public Integer call(Object o) {
//                return  o.hashCode();
//            }
//        }).filter(new Func1<Integer, Boolean>() {
//            @Override
//            public Boolean call(Integer integer) {
//                L.e("=====", "s=" + integer);
//                return integer>70;
//            }
//        })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<Integer>() {
//                    @Override
//                    public void call(Integer s) {
//                        L.e("=====", "s=" + s);
//                        textView.setText(s +"");
//                    }
//                });

        //getData();


        Observable.create(new Observable.OnSubscribe<List<String>>() {

            @Override
            public void call(Subscriber<? super List<String>> subscriber) {

                subscriber.onNext(list);

            }
        }).map(new Func1<List<String>, Integer>() {
            @Override
            public Integer call(List<String> strings) {

                return strings.size();
            }
        }).flatMap(new Func1<Integer, Observable<String>>() {

            @Override
            public Observable<String> call(Integer integer) {
                return Observable.just(integer+"");
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {

            }
        });

       Observable.concat(Observable.just(1,2,3,4,5),Observable.just(4,5,6)).distinct().filter(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer>4;
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
              //  L.e("Integer===",integer+"");
            }
        });


        Observable.just(1,2,3,4,5,6,7,8,9).buffer(4,2).subscribe(new Action1<List<Integer>>() {
            @Override
            public void call(List<Integer> integers) {
               // L.e("buffer===","--------------------");
                for (Integer i: integers
                        ) {
                 //   L.e("Integer===",i+"");
                }
            }
        });


        Observable.from(list).skip(2).take(3).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
               // L.e("call===",s);
            }
        });

        Single.just(1000).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
               // L.e("Single==========",integer+"===");
            }
        });

        Observable.just(1,2,3).last().subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
              //  L.e("call===just==",integer+"==");
            }
        });

        Observable.just(1,2,3,4,5).scan(new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {

                return integer+integer2;
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
              //  L.e("call===just==",integer+"==");
            }
        });
        getData();
    }


    public void getData(){
        Observable.zip(observable1, observable2, new Func2() {

            @Override
            public Object call(Object o, Object o2) {
                return o2;
            }
        }).subscribe(new Subscriber() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
  //L.e("onNext===========", (String) o);
            }
        });
    }

    Observable observable1 =   Observable.create(new Observable.OnSubscribe<Integer>() {

        @Override
        public void call(Subscriber<? super Integer> subscriber) {
            subscriber.onNext(1);
            subscriber.onNext(2);
            subscriber.onNext(3);
        }
    });

    Observable observable2 = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("A");
            subscriber.onNext("B");
            subscriber.onNext("C");
        }
    });


    public void testRetorfit(){

        Retrofit retorfit = new Retrofit.Builder().callFactory(new OkHttpClient.Builder().build()).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).baseUrl("http://192.168.31.242:8080/springmvc_users/user/").build();
        UserService us = retorfit.create(UserService.class);
        us.getUser().subscribe(new Subscriber<List<User>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                L.e("=========","==onError"+e.toString());
            }

            @Override
            public void onNext(List<User> users) {
                L.e("=========","=="+users.size());
            }
        });


//       us.getU("1003078").subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                L.e("=========",s);
//            }
//        });
//        us.queryUsers("bbb");
//        us.add(new Ac());





    }










}
