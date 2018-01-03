package com.crazy.fragmentnavigation.ui.games;

import android.support.v4.app.Fragment;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.base.BaseViewPagerFragment;
import com.crazy.fragmentnavigation.ui.base.NavigatorFragment;

import java.util.Arrays;
import java.util.List;

/**
 * @author Mike
 */

public class GamesFragment extends BaseViewPagerFragment {
    @Override
    protected List<Fragment> getFragmentList() {
        return Arrays.asList(
                NavigatorFragment.newInstance(new LiveFragment()),
                NavigatorFragment.newInstance(new PrematchFragment()),
                NavigatorFragment.newInstance(new SearchFragment()));
    }

    @Override
    protected int getLayout() {
        return R.layout.fr_base_view_pager_toolbar;
    }
}
