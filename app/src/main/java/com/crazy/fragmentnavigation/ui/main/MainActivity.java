package com.crazy.fragmentnavigation.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.account.AccountFragment;
import com.crazy.fragmentnavigation.ui.base.BackStackFragment;
import com.crazy.fragmentnavigation.ui.base.NavigatorFragment;
import com.crazy.fragmentnavigation.ui.bets.MyBetsFragment;
import com.crazy.fragmentnavigation.ui.games.GamesFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String GAMES_TAG = "Games";
    public static final String FAV_TAG = "Fav";
    public static final String BET_SLIP_TAG = "BetSlip";
    public static final String MY_BETS_TAG = "MyBets";
    public static final String ACCOUNT_TAG = "Account";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    switchFragment(NavigatorFragment.newInstance(new GamesFragment()), GAMES_TAG);
                    return true;
                case R.id.navigation_dashboard:
                    switchFragment(NavigatorFragment.newInstance(new FavFragment()), FAV_TAG);
                    return true;
                case R.id.navigation_notifications:
                    switchFragment(NavigatorFragment.newInstance(new BetSlipFragment()), BET_SLIP_TAG);
                    return true;
                case R.id.navigation_cart:
                    switchFragment(NavigatorFragment.newInstance(new MyBetsFragment()), MY_BETS_TAG);
                    return true;
                case R.id.navigation_money:
                    switchFragment(NavigatorFragment.newInstance(new AccountFragment()), ACCOUNT_TAG);
                    return true;
            }
            return false;
        }
    };

    private void switchFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment currentFragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
        if (currentFragment != null) {
            fragmentTransaction.detach(currentFragment);
        }

        Fragment addedFragment = fragmentManager.findFragmentByTag(tag);
        if (addedFragment != null) {
            fragmentTransaction.attach(addedFragment);
        } else {
            fragmentTransaction.add(R.id.fragmentContainer, fragment, tag);
        }

        fragmentTransaction.commit();

        List<Fragment> fragments = fragmentManager.getFragments();
        Log.d("Fragments", "Fragment entries: " + (fragments == null ? 0 : fragments.size()));
    }

    @Override
    public void onBackPressed() {
        if (!BackStackFragment.handleBackPressed(getSupportFragmentManager())) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        if (savedInstanceState == null) {
            switchFragment(NavigatorFragment.newInstance(new GamesFragment()), GAMES_TAG);
        }

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
