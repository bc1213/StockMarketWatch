package com.barclays.stockmarketwatch.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.barclays.stockmarketwatch.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SettingsFragment extends Fragment {

    @BindView(R.id.filled_exposed_dropdown)
    AutoCompleteTextView currencyView;

    @BindView(R.id.filled_exposed_dropdown_market)
    AutoCompleteTextView marketView;

    String[] currency_type = new String[]{"Default", "INR", "EUR", "USD", "YME"};
    String[] market = new String[]{"Default", "NSE", "BSE", "NYSE", "NMS"};

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);
        ArrayAdapter<String> c_adapter =
                new ArrayAdapter<>(
                        getContext(),
                        R.layout.dropdown_menu_popup_item,
                        currency_type);
        currencyView.setAdapter(c_adapter);

        ArrayAdapter<String> m_adapter =
                new ArrayAdapter<>(
                        getContext(),
                        R.layout.dropdown_menu_popup_item,
                        market);
        marketView.setAdapter(m_adapter);

    }
}