package j.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import jack.view.LoopViewPager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Integer> mImages = new ArrayList<>();
        mImages.add(R.drawable.a_c_i);
        mImages.add(R.drawable.a_vs_i);
        mImages.add(R.drawable.good_android);
        mImages.add(R.drawable.google_android);
        mImages.add(R.drawable.black_android);

        LoopViewPager lvp = findViewById(R.id.loop_view_pager);
        lvp.setPageMargin(-100);
        DemoAdapter adapter = new DemoAdapter(mImages);
        lvp.setAdapter(adapter);
    }
}
