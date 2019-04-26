package com.fly.mix.base;

import com.fly.mix.BuildConfig;
import com.fly.mix.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 *
 */
public class ApiClient {
    private static final long TIME_OUT = 5;
    private static Retrofit mRetrofit;

    public static Retrofit getRetrofit() {
        if (mRetrofit == null) {
            OkHttpClient.Builder okhttpBuilder = new OkHttpClient.Builder();
            //设置连接超时
            okhttpBuilder.connectTimeout(TIME_OUT,TimeUnit.SECONDS);
            //设置读超时
            okhttpBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
            //设置写超时
            okhttpBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
            //设置网络连接失败时 自动重连
            okhttpBuilder.retryOnConnectionFailure(true);
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                okhttpBuilder.addInterceptor(loggingInterceptor);
            }
            OkHttpClient okHttpClient = okhttpBuilder.build();

            Retrofit.Builder mRetrofitBuilder = new Retrofit.Builder();
            mRetrofit = mRetrofitBuilder.baseUrl(Constants.BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .client(okHttpClient)
                    .build()
            ;
        }
        return mRetrofit;
    }

//    /**
//     * 创建APIService
//     */
//    public static <T> T createApiService(Class<T> clazz) {
//        return getRetrofit().create(clazz);
//    }
}
