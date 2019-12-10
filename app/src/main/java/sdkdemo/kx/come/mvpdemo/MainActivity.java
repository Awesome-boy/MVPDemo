package sdkdemo.kx.come.mvpdemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.corelibs.base.BaseActivity;
import com.corelibs.base.BasePresenter;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

import sdkdemo.kx.come.mvpdemo.service.USSDService;
import sdkdemo.kx.come.mvpdemo.utils.CacheUtils;
import sdkdemo.kx.come.mvpdemo.views.fragment.MenuListFragment;


public class MainActivity extends BaseActivity {


    private FlowingDrawer mDrawer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;


    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setStatusBarColor(R.color.colorPrimary);

        mDrawer = (FlowingDrawer) findViewById(R.id.drawerlayout);
        mDrawer.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);
//        mDrawer.setOnDrawerStateChangeListener(new ElasticDrawer.OnDrawerStateChangeListener() {
//            @Override
//            public void onDrawerStateChange(int oldState, int newState) {
//                if (newState == ElasticDrawer.STATE_CLOSED) {
//                    Log.i("MainActivity", "Drawer STATE_CLOSED");
//                }
//            }
//
//            @Override
//            public void onDrawerSlide(float openRatio, int offsetPixels) {
//                Log.i("MainActivity", "openRatio=" + openRatio + " ,offsetPixels=" + offsetPixels);
//            }
//        });
        setToolbar();
        setupMenu();
        CacheUtils cacheUtils = new CacheUtils();

        ImageView iv = (ImageView) findViewById(R.id.iv_logo);
        cacheUtils.diaplay(iv, "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1575612326&di=3467dc7577fe40c48f91a9c97707bf36&src=http://pic1.win4000.com/wallpaper/9/59ba2e902ca86.jpg");
        Button button = (Button) findViewById(R.id.btn_call);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               call();

            }
        });

    }



    public boolean checkReadPermission(String string_permission,int request_code) {
        boolean flag = false;
        if (ContextCompat.checkSelfPermission(this, string_permission) == PackageManager.PERMISSION_GRANTED) {//已有权限
            flag = true;
        } else {//申请权限
            ActivityCompat.requestPermissions(this, new String[]{string_permission}, request_code);
        }
        return flag;

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    // 申请成功
                    call();
                } else {
                    // 申请失败
                }
            }
        }
    }

    private void call() {
        if(checkReadPermission(Manifest.permission.CALL_PHONE,1)){
//            Intent intent = new Intent(Intent.ACTION_CALL);
//            Uri data = Uri.parse("tel:" + "*#06#");
//            intent.setData(data);
//            startActivityForResult(intent,1);
            startService(new Intent(this, USSDService.class));
            dailNumber("*#06#");
        }

    }
    private void dailNumber(String code) {
        String ussdCode = "*" + code + Uri.encode("#");
        startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + ussdCode)));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                Log.d("zt-----",data.toString());
                break;
        }
    }

    private void setupMenu() {
        FragmentManager fm=getSupportFragmentManager();
        MenuListFragment mMenuFragment = (MenuListFragment) fm.findFragmentById(R.id.id_container_menu);
        if (mMenuFragment == null) {
            mMenuFragment = new MenuListFragment();
            fm.beginTransaction().add(R.id.id_container_menu, mMenuFragment).commit();
        }
    }

    private void setToolbar() {
      Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);
      toolbar.setNavigationIcon(R.mipmap.ic_menu_white);
      getSupportActionBar().setTitle("商城");
      toolbar.setNavigationOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              mDrawer.toggleMenu();
          }
      });


    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
