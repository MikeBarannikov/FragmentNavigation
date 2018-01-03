package com.crazy.fragmentnavigation.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crazy.fragmentnavigation.R;

import timber.log.Timber;

/**
 * @author Mike
 */

public class LogFragment extends Fragment {

    @Override
    public void onAttach(Context activity) {
        Timber.d(getLogString(".onAttach"));
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Timber.d(getLogString(".onCreate"));
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Timber.d(getLogString(".onCreateView"));
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Timber.d(getLogString(".onViewCreated"));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Timber.d(getLogString(".onActivityCreated"));
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Timber.d(getLogString(".onStart"));
        super.onStart();
    }

    @Override
    public void onResume() {
        Timber.d(getLogString(".onResume"));
        super.onResume();
    }

    @Override
    public void onPause() {
        Timber.d(getLogString(".onPause"));
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Timber.d(getLogString(".onSaveInstanceState"));
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStop() {
        Timber.d(getLogString(".onStop"));
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Timber.d(getLogString(".onDestroyView"));
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Timber.d(getLogString(".onDestroy"));
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Timber.d(getLogString(".onDetach"));
        super.onDetach();
    }

    private String getLogString(String methodName) {
        return getString(R.string.log_string, getClass().getSimpleName(), getTag(), methodName);
    }
}
