package com.crazy.fragmentnavigation.ui.account;

import android.view.View;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.base.BaseFragment;

import androidx.navigation.Navigation;

/**
 * @author Mike
 */

public class MessageFragment extends BaseFragment {
    @Override
    public int getTitleRes() {
        return R.string.title_message;
    }

    @Override
    protected int getColorRes() {
        return R.color.dark_purple_500;
    }

    @Override
    protected int getLayout() {
        return R.layout.fr_base_toolbar;
    }

    @Override
    protected void downButtonClicked(View view) {
        Navigation.findNavController(view).navigate(R.id.next_action);
    }
}
