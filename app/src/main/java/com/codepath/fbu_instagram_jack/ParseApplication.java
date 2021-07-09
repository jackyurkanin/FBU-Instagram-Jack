package com.codepath.fbu_instagram_jack;

import android.app.Application;

import com.codepath.fbu_instagram_jack.models.Post;
import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("GgZkQh9UTPhUF7zyy7ujMfD9NhFcqWIZbOtqbTEz")
                .clientKey("6wXexbslFyqT4SWxwXDKNrWj5ZMhZP6fmeDm09QH")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
