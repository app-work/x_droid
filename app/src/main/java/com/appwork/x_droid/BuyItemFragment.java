package com.appwork.x_droid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BuyItemFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public BuyItemFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static BuyItemFragment newInstance(int sectionNumber) {
        BuyItemFragment fragment = new BuyItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_buyitem, container, false);
        final TextView totalAmount = (TextView) rootView.findViewById(R.id.totalAmount);
        final EditText inputAmount = (EditText) rootView.findViewById(R.id.inputAmount);
        Button addAmount = (Button) rootView.findViewById(R.id.addAmount);
        final long[] total = {0};
        addAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value;
                Boolean isValidate = true;
                if (inputAmount.getText().toString().length() <= 0) {
                    inputAmount.setError("Invalid value!!");
                    isValidate = false;
                }
                if (isValidate == true) {
                    value = Integer.parseInt(inputAmount.getText().toString());
                    total[0] = total[0] + value;
                    totalAmount.setText("Total Amount: "+Long.toString(total[0]));
                }
            }
        });
        return rootView;
    }
}
