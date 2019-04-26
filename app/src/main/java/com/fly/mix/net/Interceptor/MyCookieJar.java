package com.fly.mix.net.Interceptor;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;


/**
 * @Author admin
 * Created on 2018/12/10 15:07.
 * Desc:WanAndroidMvp
 */
public class MyCookieJar implements CookieJar {
    public ConcurrentHashMap<String, List<Cookie>> cookieStore = new ConcurrentHashMap<>();

    @Override
    public void saveFromResponse(@NonNull HttpUrl url, @NonNull List<Cookie> cookies) {
        if (!cookies.isEmpty()) {
            for (int i = 0; i < cookies.size(); i++) {
//                LogUtil.e("Cookie:========================\n");
//                LogUtil.e("Cookie:" + cookies.get(i));
//                LogUtil.e("domain:", cookies.get(i).domain());
//                LogUtil.e("name:", cookies.get(i).name());
//                LogUtil.e("value:", cookies.get(i).value());
//                LogUtil.e("expiresAt:", cookies.get(i).expiresAt() + "");
//                if ("loginUserName".equals(cookies.get(i).name())) {
//                    SPUtil.saveData(App.getAppContext(), SPConfigKey.COOKIE_LOGIN_USER_NAME, cookies.get(i).value());
//                }
//                if ("token_pass".equals(cookies.get(i).name())) {
//                    SPUtil.saveData(App.getAppContext(), SPConfigKey.COOKIE_TOKEN, cookies.get(i).value());
//                }
//
//                if ("JSESSIONID".equals(cookies.get(i).name())) {
//                    SPUtil.saveData(App.getAppContext(), SPConfigKey.COOKIE_JSESSIONID, cookies.get(i).value());
//                }
            }
            cookieStore.put(url.host(), cookies);
        }
    }

    @Override
    public List<Cookie> loadForRequest(@NonNull HttpUrl url) {
        List<Cookie> cookies = cookieStore.get(url.host());


        return cookies != null ? cookies : new ArrayList<Cookie>();
    }
}
