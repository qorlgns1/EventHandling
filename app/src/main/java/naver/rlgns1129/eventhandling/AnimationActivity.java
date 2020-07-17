package naver.rlgns1129.eventhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        final ImageView imageView = (ImageView)findViewById(R.id.imageView2);
        final Button button = (Button)findViewById(R.id.animationbtn);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                imageView.startAnimation(rotate);
                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(AnimationActivity.this,"애니메이션 종료", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
    }
}