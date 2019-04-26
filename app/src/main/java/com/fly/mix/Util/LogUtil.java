package com.fly.mix.Util;

import android.util.Log;

/**
 */
public class LogUtil {

    public static boolean isDebug = true;

    private void LogUtil() {
    }

    public static void e(String tag,Object msg) {
        log(tag,"",msg);
    }


    public static void log(String tag, String logType, Object msg) {
        if (isDebug) {
            if (msg.toString().length() > 4000) {
                for (int i = 0; i < msg.toString().length(); i += 4000) {
                    if (i + 4000 < msg.toString().length())
                        Log.e(tag + i, msg.toString().substring(i, i + 4000));
                    else
                        Log.e(tag + i, msg.toString().substring(i));
                }
            } else {
                Log.e(tag, msg.toString());
            }
        }
    }


}
