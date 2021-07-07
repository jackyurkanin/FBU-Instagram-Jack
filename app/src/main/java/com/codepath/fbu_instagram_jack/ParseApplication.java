package com.codepath.fbu_instagram_jack;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("GgZkQh9UTPhUF7zyy7ujMfD9NhFcqWIZbOtqbTEz")
                .clientKey("6wXexbslFyqT4SWxwXDKNrWj5ZMhZP6fmeDm09QH")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
