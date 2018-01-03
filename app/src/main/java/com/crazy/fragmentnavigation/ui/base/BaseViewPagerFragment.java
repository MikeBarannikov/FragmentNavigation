package com.crazy.fragmentnavigation.ui.base;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crazy.fragmentnavigation.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author Mike
 */

public abstract class BaseViewPagerFragment extends BackStackFragment {

    private ViewPager mViewPager;
    private MyPagerAdapter mMyPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View view = inflater.inflate(getLayout(), container, false);

        List<Fragment> fragments = getChildFragmentManager().getFragments();
        if (fragments == null || fragments.isEmpty()) {
            fragments = new ArrayList<>();
            fragments.addAll(getFragmentList());
        }

        mViewPager = view.findViewById(R.id.view_pager);
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setAdapter(mMyPagerAdapter = new MyPagerAdapter(getContext(), getChildFragmentManager(), fragments));

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewPager);

        return view;
    }

    protected abstract List<Fragment> getFragmentList();

    @LayoutRes
    protected int getLayout() {
        return R.layout.fr_base_view_pager;
    }
}
