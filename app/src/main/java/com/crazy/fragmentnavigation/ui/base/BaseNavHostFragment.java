package com.crazy.fragmentnavigation.ui.base;

import android.support.annotation.NavigationRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import java.util.List;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public class BaseNavHostFragment extends NavHostFragment {

    public static BaseNavHostFragment newInstance(@NavigationRes int graphId) {
        BaseNavHostFragment fragment = new BaseNavHostFragment();
        fragment.setGraph(graphId);
        return fragment;
    }

    @NonNull
    @Override
    public NavController getNavController() {
        List<Fragment> fragmentList = getChildFragmentManager().getFragments();
        for (Fragment fragment : fragmentList) {
            if (fragment instanceof BaseViewPagerFragment) {
                return ((BaseViewPagerFragment) fragment).getNavController();
            }
        }
        return super.getNavController();
    }
}