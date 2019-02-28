package com.tylersuehr.chipexample;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.tylersuehr.chips.Chip;

public class MChip extends Chip {
    private Context context;

    private String title = null;
    @Nullable
    @Override
    public Object getId() {
        return null;
    }

    @NonNull
    @Override
    public String getTitle() {
        return title;
    }

    @Nullable
    @Override
    public String getSubtitle() {
        return null;
    }

    @Nullable
    @Override
    public Uri getAvatarUri() {
        return null;
    }

    @Nullable
    @Override
    public Drawable getAvatarDrawable() {
        return null;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
