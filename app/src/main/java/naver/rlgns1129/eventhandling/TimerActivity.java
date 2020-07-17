package naver.rlgns1129.eventhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {
    //클래스 안의 여러 메소드에서 사용하기 위해서 인스턴스 변수를 생성
    //안드로이드에서는 위에 목적이 아닌경우에 변수를 여기에 선언하는 경우가 있는데
    //이벤트 처리를 할 때 anonymous 나 람다를 이용하면
    //지역변수를 사용할 수 없기 때문에 인스턴스 변수로 선언하기도 합니다.
    Button btn;
    TextView disp;

    //Activity가 화면에 출력되기 전에 호출되는 메소드

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //레이아웃이나 뷰를 이용해서 Activity의 전체 화면을 설정
        setContentView(R.layout.activity_timer);

        //레이아웃 파일에 디자인 한 뷰 파일 찾아오기
        btn = (Button)findViewById(R.id.btn);
        disp = (TextView)findViewById(R.id.disp);

        //버튼을 클릭했을 때 동작을 정의
        btn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
            /*    try{
                    for(int i = 0 ; i < 10 ; i = i+1 ){
                        Thread.sleep(1000);
                        String msg = String.format("i: %d", i);
                        //로그 출력
                        Log.e("작업", msg);
                        disp.setText(msg);
                    }
                }catch(Exception e){}
                */
                CountDownTimer timer = new CountDownTimer(10000, 1000) {
                    int value = 0;
                    @Override
                    public void onTick(long l) {
                        String msg = String.format("value: %d" , value++);
                        disp.setText(msg);

                    }

                    @Override
                    public void onFinish() {

                    }
                };
                timer.start();

                final ImageView imageView = (ImageView)findViewById(R.id.imageView);


                //이미지 뷰에 출력할 리소스 배
                final int [] images = {R.drawable.image1 , R.drawable.image2};

                CountDownTimer t1 = new CountDownTimer(100000, 2000) {
                    int idx = 0;
                    @Override
                    public void onTick(long l) {
                        idx = idx + 1;
                        imageView.setImageResource(images[idx %2]);

                    }

                    @Override
                    public void onFinish() {

                    }
                };
                t1.start();
            }
        });

    }
}