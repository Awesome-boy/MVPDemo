package sdkdemo.kx.come.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.corelibs.base.BaseActivity;
import com.corelibs.base.BasePresenter;
import com.corelibs.utils.PreferencesHelper;

import java.util.prefs.Preferences;

public class MainActivity extends BaseActivity {



    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;

    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
