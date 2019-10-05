package com.example.moli.campus.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.example.moli.campus.R;
import com.example.moli.campus.fragment.AssociationsFragment;
import com.example.moli.campus.fragment.DiscoverFragment;
import com.example.moli.campus.fragment.InformationFragment;
import com.example.moli.campus.fragment.PersonalFragment;
import com.example.moli.campus.fragment.ZhiliaoFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private BottomNavigationView mBottomNavigationView;

    private int lastIndex;
    List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottomNavigation();
        initData();

    }



    public void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(new DiscoverFragment());
        mFragments.add(new ZhiliaoFragment());
        mFragments.add(new AssociationsFragment());
        mFragments.add(new InformationFragment());
        mFragments.add(new PersonalFragment());
        // 初始化展示MessageFragment
        setFragmentPosition(0);
    }

    public void initBottomNavigation() {
        mBottomNavigationView = findViewById(R.id.bottomNavigationView);
//           解决当item大于三个时，非平均布局问题

//       BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_1:
                        setFragmentPosition(0);
                        break;
                    case R.id.item_2:
                        setFragmentPosition(1);
                        break;
                    case R.id.item_3:
                        setFragmentPosition(2);
                        break;
                    case R.id.item_4:
                        setFragmentPosition(3);
                        break;
                    case R.id.item_5:
                        setFragmentPosition(4);
                        break;
                    default:
                        break;
                }
                // 这里注意返回true,否则点击失效
                return true;
            }
        });
    }


    private void setFragmentPosition(int position) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment currentFragment = mFragments.get(position);
        Fragment lastFragment = mFragments.get(lastIndex);
        lastIndex = position;
        ft.hide(lastFragment);
        if (!currentFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
            ft.add(R.id.rl_content, currentFragment);
        }
        ft.show(currentFragment);
        ft.commitAllowingStateLoss();
    }
}



