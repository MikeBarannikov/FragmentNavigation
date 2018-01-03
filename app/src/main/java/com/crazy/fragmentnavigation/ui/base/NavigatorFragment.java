package com.crazy.fragmentnavigation.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crazy.fragmentnavigation.R;

/**
 * @author Mike
 */

public class NavigatorFragment extends BackStackFragment {

    private Fragment mRootFragment;

    @Nullable
    public static NavigatorFragment findNavigator(@Nullable Fragment fragment) {
        if (fragment == null) {
            return null;
        }

        final Fragment parentFragment = fragment.getParentFragment();
        if (parentFragment != null && parentFragment instanceof NavigatorFragment) {
            return (NavigatorFragment) parentFragment;
        } else {
            return findNavigator(parentFragment);
        }
    }

    public static Fragment newInstance(Fragment rootFragment) {
        final NavigatorFragment fragment = new NavigatorFragment();
        fragment.setRootFragment(rootFragment);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fr_navigator, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFragment();
    }

    private void initFragment() {
        final FragmentManager fm = getChildFragmentManager();
        final Fragment fragment = fm.findFragmentById(R.id.navigatorFragmentContainer);
        if (fragment == null && mRootFragment != null) {
            replaceFragment(mRootFragment, false);
        }
    }

    public void replaceFragment(Fragment fragment, boolean addToBackstack) {
        if (addToBackstack) {
            getChildFragmentManager().beginTransaction().replace(R.id.navigatorFragmentContainer, fragment).addToBackStack(null).commit();
        } else {
            getChildFragmentManager().beginTransaction().replace(R.id.navigatorFragmentContainer, fragment).commit();
        }
    }

    public void setRootFragment(Fragment rootFragment) {
        mRootFragment = rootFragment;
    }
}
