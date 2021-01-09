package com.example.epidemic.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.epidemic.fragment.MessageFragment;

public class MessageAdapter extends BaseFragmentPagerAdapter<Integer> {

    public MessageAdapter(Context context, FragmentManager fm) {
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
        return MessageFragment.newInstance();
    }
}
