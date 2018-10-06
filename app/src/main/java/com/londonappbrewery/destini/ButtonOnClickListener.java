package com.londonappbrewery.destini;

import android.view.View;

public class ButtonOnClickListener implements View.OnClickListener {
    private final MainActivity mainActivity;
    private int storyState;

    public ButtonOnClickListener(final MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.storyState = 1;
    }

    @Override
    public void onClick(View view) {
        final int viewID = view.getId();
        switch (storyState) {
            case 1:
                if (viewID == R.id.buttonTop) {
                    storyState = 3;
                } else if (viewID == R.id.buttonBottom) {
                    storyState = 2;
                }
                break;

            case 2:
                if (viewID == R.id.buttonTop) {
                    storyState = 3;
                } else if (viewID == R.id.buttonBottom) {
                    storyState = 4;
                }
                break;

            case 3:
                if (viewID == R.id.buttonTop) {
                    storyState = 6;
                } else if (viewID == R.id.buttonBottom) {
                    storyState = 5;
                }
                break;

            case 4:
                if (viewID == R.id.buttonRestart) {
                    storyState = 1;
                }
                break;

            case 5:
                if (viewID == R.id.buttonRestart) {
                    storyState = 1;
                }
                break;

            case 6:
                if (viewID == R.id.buttonRestart) {
                    storyState = 1;
                }
                break;
        }

        mainActivity.setViews(storyState);
    }

    public int getStoryState() {
        return storyState;
    }

    public void setStoryState(final int storyState) {
        this.storyState = storyState;
    }
}
