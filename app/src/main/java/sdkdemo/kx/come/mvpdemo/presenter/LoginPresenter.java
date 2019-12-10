package sdkdemo.kx.come.mvpdemo.presenter;

import android.text.TextUtils;
import android.util.Log;


import com.corelibs.api.ApiFactory;
import com.corelibs.api.ResponseTransformer;
import com.corelibs.base.BasePresenter;
import com.corelibs.subscriber.ResponseSubscriber;

import sdkdemo.kx.come.mvpdemo.model.LoginApi;
import sdkdemo.kx.come.mvpdemo.model.bean.BaseData;
import sdkdemo.kx.come.mvpdemo.model.bean.req.RequestBean;
import sdkdemo.kx.come.mvpdemo.views.LoginView;

/**
 * Created by issuser on 2018/4/9.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    LoginApi api;

    @Override
    protected void onViewAttach() {
        super.onViewAttach();
        api = ApiFactory.getFactory().create(LoginApi.class);
    }

    @Override
    public void onStart() {

    }





    public void getServerVersion() {
//        api.getServerVersion()
//                .compose(new ResponseTransformer<>(this.<BaseData<String>>bindToLifeCycle()))
//                .subscribe(new ResponseSubscriber<BaseData<RequestBean>>() {
//
//                    @Override
//                    public void success(BaseData<RequestBean> data) {
//                        RequestBean bean=data.data;
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                    }
//                });
    }


}
