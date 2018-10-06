package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    public Button buttonTop;
    public Button buttonBottom;
    public Button buttonRestart;
    public TextView storyTextView;
    public ButtonOnClickListener buttonOnClickListener;

    public static final String TAG = "StoryState";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyTextView = findViewById(R.id.storyTextView);
        buttonTop = findViewById(R.id.buttonTop);
        buttonBottom = findViewById(R.id.buttonBottom);
        buttonRestart = findViewById(R.id.buttonRestart);
        buttonOnClickListener = new ButtonOnClickListener(this);

        int storyState = 1;
        if (savedInstanceState != null) {
            storyState = savedInstanceState.getInt(TAG);
        }
        setViews(storyState);
        buttonOnClickListener.setStoryState(storyState);

        buttonTop.setOnClickListener(buttonOnClickListener);
        buttonBottom.setOnClickListener(buttonOnClickListener);
        buttonRestart.setOnClickListener(buttonOnClickListener);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(TAG, buttonOnClickListener.getStoryState());
        super.onSaveInstanceState(savedInstanceState);
    }

    public void setViews(final int storyState) {
        switch (storyState) {
            case 1:
                storyTextView.setText(R.string.T1_Story);
                buttonTop.setText(R.string.T1_Ans1);
                buttonBottom.setText(R.string.T1_Ans2);
                break;

            case 2:
                storyTextView.setText(R.string.T2_Story);
                buttonTop.setText(R.string.T2_Ans1);
                buttonBottom.setText(R.string.T2_Ans2);
                break;

            case 3:
                storyTextView.setText(R.string.T3_Story);
                buttonTop.setText(R.string.T3_Ans1);
                buttonBottom.setText(R.string.T3_Ans2);
                break;

            case 4:
                storyTextView.setText(R.string.T4_End);
                break;

            case 5:
                storyTextView.setText(R.string.T5_End);
                break;

            case 6:
                storyTextView.setText(R.string.T6_End);
                break;
        }

        if (storyState < 4) {
            buttonTop.setVisibility(View.VISIBLE);
            buttonBottom.setVisibility(View.VISIBLE);
            buttonRestart.setVisibility(View.GONE);
        } else {
            buttonTop.setVisibility(View.GONE);
            buttonBottom.setVisibility(View.GONE);
            buttonRestart.setVisibility(View.VISIBLE);
        }
    }
}
