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
import com.crazy.fragmentnavigation.ui.base.NavHostViewPagerFragment;

import java.util.List;

import androidx.navigation.fragment.NavHostFragment;

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
                case R.id.games:
                    switchFragment(NavHostViewPagerFragment.newInstance(R.navigation.games_navigation), GAMES_TAG);
                    return true;
                case R.id.accounts:
                    switchFragment(NavHostFragment.create(R.navigation.account_navigation), ACCOUNT_TAG);
                    return true;
                case R.id.my_bets:
                    switchFragment(NavHostFragment.create(R.navigation.bets_navigation), MY_BETS_TAG);
                    return true;
                case R.id.favorite:
                    switchFragment(NavHostFragment.create(R.navigation.fav_navigation), FAV_TAG);
                    return true;
                case R.id.betslip:
                    switchFragment(NavHostFragment.create(R.navigation.bet_slip_navigation), BET_SLIP_TAG);
                    return true;
            }
            return false;
        }
    };

    private void switchFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment currentFragment = fragmentManager.findFragmentById(R.id.main_host_fragment);
        if (currentFragment != null) {
            fragmentTransaction.detach(currentFragment);
        }

        Fragment addedFragment = fragmentManager.findFragmentByTag(tag);
        if (addedFragment != null) {
            fragmentTransaction.attach(addedFragment);
        } else {
            fragmentTransaction.add(R.id.main_host_fragment, fragment, tag);
        }

        fragmentTransaction.commit();

        List<Fragment> fragments = fragmentManager.getFragments();
        Log.d("Fragments", "Fragment entries: " + (fragments == null ? 0 : fragments.size()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        if (savedInstanceState == null) {
            switchFragment(NavHostViewPagerFragment.newInstance(R.navigation.games_navigation), GAMES_TAG);
        }

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.main_host_fragment);
        if (!NavHostFragment.findNavController(fragment).navigateUp()) {
            super.onBackPressed();
        }
    }

}
