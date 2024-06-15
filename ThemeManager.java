package com.blerdU.rootworkapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;

public class ThemeManager {
    private Context context;
    private String currentCity;

    public ThemeManager(Context context) {
        this.context = context;
    }

    // Set the theme based on the selected city
    public void setTheme(String city) {
        this.currentCity = city;
        customizeLayout();
    }

    // Retrieve the city flag drawable resource
    public Drawable getCityFlag() {
        int flagResId = getFlagResourceByCity(currentCity);
        return ContextCompat.getDrawable(context, flagResId);
    }

    // Customize the layout to reflect the selected city's theme
    private void customizeLayout() {
        // Implement layout customization logic based on the currentCity
        // This may include changing background images, colors, etc.
        int themeResId = getThemeResourceByCity(currentCity);
        context.setTheme(themeResId);
    }

    // Helper method to get the flag resource ID by city
    private int getFlagResourceByCity(String city) {
        switch (city.toLowerCase()) {
            case "chicago":
                return R.drawable.flag_chicago;
            case "new york":
                return R.drawable.flag_new_york;
            case "los angeles":
                return R.drawable.flag_los_angeles;
            default:
                return R.drawable.flag_default;
        }
    }

    // Helper method to get the theme resource ID by city
    private int getThemeResourceByCity(String city) {
        switch (city.toLowerCase()) {
            case "chicago":
                return R.style.Theme_Chicago;
            case "new york":
                return R.style.Theme_NewYork;
            case "los angeles":
                return R.style.Theme_LosAngeles;
            default:
                return R.style.Theme_Default;
        }
    }
}
