package sdkdemo.kx.come.mvpdemo.views.fragment;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.corelibs.base.BaseFragment;
import com.corelibs.base.BasePresenter;

import sdkdemo.kx.come.mvpdemo.R;


public class MenuListFragment extends BaseFragment{

    private ImageView ivMenuUserProfilePhoto;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_menu;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivMenuUserProfilePhoto = (ImageView) view.findViewById(R.id.ivMenuUserProfilePhoto);
        NavigationView vNavigation = (NavigationView) view.findViewById(R.id.vNavigation);
        vNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                return false;
            }
        }) ;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
