package sdkdemo.kx.come.mvpdemo;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;

import com.corelibs.api.ApiFactory;
import com.corelibs.common.Configuration;
import com.corelibs.utils.GalleryFinalConfigurator;
import com.corelibs.utils.PreferencesHelper;
import com.corelibs.utils.ToastMgr;

import sdkdemo.kx.come.mvpdemo.constant.Urls;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        ToastMgr.init(getApplicationContext());
        Configuration.enableLoggingNetworkParams();
        ApiFactory.getFactory().add(Urls.ROOT); //初始化Retrofit接口工厂
        PreferencesHelper.init(getApplicationContext());
        GalleryFinalConfigurator.config(getApplicationContext());

        //galleryfinal 7.0
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.detectFileUriExposure();
        }

    }
}
