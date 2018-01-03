package com.crazy.fragmentnavigation.ui.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * @author Mike
 */

public class BackStackFragment extends LogFragment {

    public static boolean canBack(FragmentManager fm) {
        return handleBackPressed(fm, true);
    }

    public static boolean handleBackPressed(FragmentManager fm) {
        return handleBackPressed(fm, false);
    }

    protected static boolean handleBackPressed(FragmentManager fm, boolean isCheck) {
        if (fm.getFragments() != null) {
            for (Fragment frag : fm.getFragments()) {
                if (frag != null && frag.isVisible() && frag instanceof BackStackFragment) {
                    if (((BackStackFragment) frag).onBackPressed(isCheck)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    protected boolean onBackPressed(boolean isCheck) {
        FragmentManager fm = getChildFragmentManager();
        if (handleBackPressed(fm, isCheck)) {
            return true;
        } else if (getUserVisibleHint() && fm.getBackStackEntryCount() > 0) {
            if (!isCheck) {
                fm.popBackStack();
            }
            return true;
        }
        return false;
    }
}
