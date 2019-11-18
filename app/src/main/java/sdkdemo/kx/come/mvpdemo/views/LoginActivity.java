package sdkdemo.kx.come.mvpdemo.views;

import android.os.Bundle;
import android.util.Log;

import com.corelibs.base.BaseActivity;
import com.corelibs.utils.PreferencesHelper;

import sdkdemo.kx.come.mvpdemo.R;
import sdkdemo.kx.come.mvpdemo.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginView,LoginPresenter> implements LoginView {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;

    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setStatusBarColor(R.color.colorPrimary);

    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void loginSuccess(String data) {

    }


}
