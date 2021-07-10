package com.codepath.fbu_instagram_jack.activities;

import android.content.Context;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.codepath.fbu_instagram_jack.databinding.ActivityDetailsBinding;
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
    private static int ROUNDED_CORNERS = 30;
    private static int WIDTH = 600;
    private Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        context = this;

        tvCaption = binding.tvCaption;
        tvTime = binding.tvTime;
        tvUsernameDetails = binding.tvUsernameDetails;
        ivPostPic = binding.ivPostPic;
        btnReturn = binding.btnReturn;

        post = Parcels.unwrap(getIntent().getParcelableExtra(POST));
        tvCaption.setText(post.getDescription());
        Date date = post.getCreatedAt();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
        String dateStr = format.format(date);
        tvTime.setText(dateStr);
        tvUsernameDetails.setText("@" + post.getUser().getUsername());
        Glide.with(context)
                .load(post.getImage().getUrl())
                .centerCrop()
                .override(WIDTH)
                .transform(new RoundedCorners(ROUNDED_CORNERS))
                .into(ivPostPic);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
