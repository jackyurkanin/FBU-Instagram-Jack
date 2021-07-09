package com.codepath.fbu_instagram_jack.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.codepath.fbu_instagram_jack.databinding.ActivityPostBinding;
import com.codepath.fbu_instagram_jack.models.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.List;

public class PostActivity extends AppCompatActivity {

    private static final String TAG = "PostActivity";
    private Button btnPost;
    private EditText etDescription;
    private ImageView ivPostImage;
    private Button btnCapture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPostBinding binding = ActivityPostBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        btnPost = binding.btnPost;
        etDescription = binding.etDescription;
        ivPostImage = binding.ivPostImage;
        btnCapture = binding.btnCapture;
        
        QueryPosts();

    }

    private void QueryPosts() {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with getting posts", e);
                    return;
                }
                for (Post post: posts) {
                    Log.i(TAG, "Post: " + post.getDescription() + ", username: " + post.getUser().getUsername());
                }
            }
        });
    }
}
