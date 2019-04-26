package com.fly.mix;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 返回结果为Json字符串的请求
 */
public interface BaseApiService {
    @GET
    Observable<String> get(@Url String url);

    @GET
    Observable<String> get(@Url String url, @QueryMap Map<String, Object> params);


    @GET
    @Streaming
    Observable<ResponseBody> download(@Url String url, @QueryMap Map<String, Object> params);


    @POST
    @FormUrlEncoded
    Observable<String> post(@Url String url, @FieldMap Map<String, Object> params);

    @POST
    Observable<String> posrRow(@Url String url, @Body RequestBody requestBody);
}
