package com.example.booklisting;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText EditText;
    private String search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText = findViewById(R.id.searchbook);
        Button button = findViewById(R.id.searchbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search = EditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, SearchBook.class);
                intent.putExtra("Search", search);
                Log.e(TAG, "search" + search);
                startActivity(intent);
            }

        });
    }
    public void setupUI(View view) {
        // Set up touch listener for non-text box views to hide keyboard
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    // Hide keypad
                    v.performClick();
                    hideSoftKeyboard(MainActivity.this);
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion
        if (view instanceof ViewGroup) {
            // Current view is a {@Link ViewGroup}
            // Traverse the {@link ViewGroup}, over each child
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                // Get the current child view
                View innerView = ((ViewGroup) view).getChildAt(i);
                // Set up touch listeners on non-text box views
                setupUI(innerView);
            }
        }
    }

    /**
     * This method hides the soft keypad that pops up when there are views that solicit user input
     */
    public static void hideSoftKeyboard(Activity activity) {
        // Get the activity's input method service
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);

        // Hide the soft keypad
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }
}