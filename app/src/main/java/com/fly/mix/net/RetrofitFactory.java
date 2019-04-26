package com.fly.mix.net;

import com.fly.mix.Constants;
import com.fly.mix.net.Interceptor.HttpLoger;
import com.fly.mix.net.Interceptor.MyCookieJar;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


/**
 *
 */
public class RetrofitFactory {
    private static String BASE_URL = Constants.BASE_URL;

    public static final class OkHttpHolder {
        private static final int TIME_OUT = 60;
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addNetworkInterceptor(new HttpLoggingInterceptor(new HttpLoger()).setLevel(HttpLoggingInterceptor.Level.BODY))
                .cookieJar(new MyCookieJar())
                .build();
    }
    //静态内部类  实现线程安全的单例模式
    private static final class RetrofitHolder {

        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(RetrofitFactory.OkHttpHolder.OK_HTTP_CLIENT)
                .build();
    }

//    private static final class RestServiceHolder {
//        private static final RestService REST_REST_SERVICE = RetrofitFactory.RetrofitHolder
//                .RETROFIT_CLIENT.create(RestService.class);
//    }

//    public static RestService getRestService() {
//        return RetrofitFactory.RestServiceHolder.REST_REST_SERVICE;
//    }

    /**
     * 创建API
     */
    public static <T> T getApiService(Class<T> clazz) {
        return RetrofitFactory.RetrofitHolder.RETROFIT_CLIENT.create(clazz);
    }
}
