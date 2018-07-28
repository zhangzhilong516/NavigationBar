package zhang.zhilong;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import zhang.zhilong.navigationbar.DefaultNavigationBar;
import zhang.zhilong.navigationbar.R;

public class MainActivity extends AppCompatActivity {
    private ViewGroup mRootView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootView = (ViewGroup) findViewById(R.id.root_view);

        new DefaultNavigationBar.Builder(this, mRootView).create();
    }
}
