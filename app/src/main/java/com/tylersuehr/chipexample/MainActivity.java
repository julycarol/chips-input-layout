package com.tylersuehr.chipexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.tylersuehr.chips.Chip;
import com.tylersuehr.chips.ChipDataSource;
import com.tylersuehr.chips.ChipsInputLayout;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright © 2017 Tyler Suehr
 *
 * @author Tyler Suehr
 * @version 1.0
 */
public class MainActivity extends ContactLoadingActivity
        implements ContactOnChipAdapter.OnContactClickListener {
    private ChipsInputLayout mChipsInput;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setup chips input
        mChipsInput = (ChipsInputLayout) findViewById(R.id.chips_input);
        mChipsInput.setImageRenderer(new GlideRenderer());
        mChipsInput.setChipValidator(new ChipsInputLayout.ChipValidator() {
            @Override
            public boolean validate(Chip chip) {
                return validateEmail(chip.getTitle());
            }
        });

        mChipsInput.addSelectionObserver(new ChipDataSource.SelectionObserver() {
            @Override
            public void onChipSelected(Chip addedChip) {
                mChipsInput.validateChip(addedChip);

            }

            @Override
            public void onChipDeselected(Chip removedChip) {

            }
        });

        mChipsInput.getChipsInputEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                addChip();
            }
        });


        // Load the current user's contact information
        loadContactsWithRuntimePermission();

    }

    private Boolean validateEmail(String email){
        if (email.isEmpty()) return false;

        String regExp = ("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$");

        Pattern pattern = Pattern.compile(regExp, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void addChip() {
        if (mChipsInput.getChipsInputEditText().getText() != null && mChipsInput.getChipsInputEditText().getText().length() > 0) {
            Log.e("Print Current OnFocus", mChipsInput.getChipsInputEditText().getText().toString());
        }
    }

    /**
     * When we have contact chips available, let's make them filterable in our ChipsInputView!
     */
    @Override
    protected void onContactsAvailable(List<ContactChip> chips) {
        System.out.println("Number of contacts: " + chips.size());
        mChipsInput.setFilterableChipList(chips);
    }

    @Override
    protected void onContactsReset() {
    }

    @Override
    public void onContactClicked(ContactChip chip) {
    }
}