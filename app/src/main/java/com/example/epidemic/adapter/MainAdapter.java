package com.example.epidemic.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.epidemic.fragment.DiscoveryFragment;
import com.example.epidemic.fragment.FirstFrgament;
import com.example.epidemic.fragment.HealthFrgament;
import com.example.epidemic.fragment.MeFragment;

/**
 * 主界面ViewPager的Adapter
 *
 */
public class MainAdapter extends BaseFragmentPagerAdapter<Integer> {

    public MainAdapter(Context context, FragmentManager fm) {
        super(context, fm);
    }

    /**
     * 返回Fragment
     *
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return FirstFrgament.newInstance();
        } else if (position == 1) {
            return DiscoveryFragment.newInstance();
        } else if (position==2){
            return HealthFrgament.newInstance();
        } else {
            return MeFragment.newInstance();
        }
    }


}