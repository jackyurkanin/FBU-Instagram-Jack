package com.codepath.fbu_instagram_jack.activities;

import android.content.Context;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.codepath.fbu_instagram_jack.databinding.ActivityDetailsBinding;
import com.codepath.fbu_instagram_jack.databinding.ActivityMainBinding;
import com.codepath.fbu_instagram_jack.models.Post;

import org.parceler.Parcels;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;
    private TextView tvCaption;
    private TextView tvUsernameDetails;
    private TextView tvTime;
    private ImageView ivPostPic;
    private Button btnReturn;
    private Post post;
    private static final String POST = "post";
    private Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Log.e("DEBUG", "here");
        context = this;

        tvCaption = binding.tvCaption;
        tvTime = binding.tvTime;
        tvUsernameDetails = binding.tvUsernameDetails;
        ivPostPic = binding.ivPostPic;
        btnReturn = binding.btnReturn;

        post = Parcels.unwrap(getIntent().getParcelableExtra(POST));
        Log.e("DEBUG", post.getUser().getUsername());
        tvCaption.setText(post.getDescription());
        Date date = post.getCreatedAt();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
        String dateStr = format.format(date);
        tvTime.setText(dateStr);
        tvUsernameDetails.setText("@" + post.getUser().getUsername());
        Glide.with(context)
                .load(post.getImage().getUrl())
                .centerCrop()
                .override(300,300)
                .transform(new RoundedCorners(30))
                .into(ivPostPic);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
