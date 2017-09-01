package com.example.administrator.databasesave;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * <pre>
 *
 *   author   :   Alex
 *   e_mail   :   18238818283@sina.cn
 *   timr     :   2017/08/31
 *   desc     :
 *   version  :   V 1.0.5
 */
public interface UserService {

    @GET("users")
    Observable<List<User>> getUser();

    @GET("book/{userName}")
    Observable<String> getU(@Path("userName") String userName);

    @GET("users")
    Observable<List<String>> queryUsers(@Query("classNum") String classNum);

    @POST("add")
    Observable<List<String>> add(Ac ac);

    @POST("login")
    @FormUrlEncoded
    Observable<String> login(@Field("userName") String userName ,@Field("passward") String passward);

    @Multipart
    @POST("regist")
    Observable<String> regist(@Part("userName") String userName, @Part("passward") String passward, @Part MultipartBody multipartBody);


    @Multipart
    @POST("regists")
    Observable<String> regists(@Part("userName") String userName, @PartMap Map<String, RequestBody> map);
}
