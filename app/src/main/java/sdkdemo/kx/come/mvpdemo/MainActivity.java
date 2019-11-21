package sdkdemo.kx.come.mvpdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.corelibs.base.BaseActivity;
import com.corelibs.base.BasePresenter;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

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
