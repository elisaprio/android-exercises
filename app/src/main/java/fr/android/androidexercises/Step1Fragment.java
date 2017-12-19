package fr.android.androidexercises;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

public class Step1Fragment extends Fragment {

    // TODO Override onCreateViewMethod
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container){
        return inflater.inflate(R.layout.fragment_step1, container, false);
    }

}
