package com.gudhaking.social;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private LinearLayout root;
    private int ink = Color.rgb(30, 35, 45);
    private int muted = Color.rgb(110, 118, 130);
    private int accent = Color.rgb(92, 76, 220);

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showHome();
    }

    private TextView text(String value, int size, int color, boolean bold) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        if (bold) t.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        return t;
    }

    private void showHome() {
        ScrollView scroll = new ScrollView(this);
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(22, 28, 22, 24);
        root.setBackgroundColor(Color.rgb(248, 249, 253));
        scroll.addView(root);

        TextView brand = text("gudha_king", 30, accent, true);
        root.addView(brand);
        TextView tagline = text("Connect • Share • Discover", 14, muted, false);
        root.addView(tagline);

        Button login = button("Login / Sign up");
        root.addView(login);
        login.setOnClickListener(v -> Toast.makeText(this,
            "Login and signup will be connected in the next version.", Toast.LENGTH_LONG).show());

        root.addView(section("Your feed"));
        root.addView(post("Welcome to gudha_king", "Your social space starts here. Create a profile and share updates with your community."));
        root.addView(post("Photo and video posts", "Photo/video upload will be enabled after Firebase setup."));
        root.addView(post("Follow your interests", "Following, likes, comments and messaging are planned for the next build."));

        Button profile = button("My Profile");
        root.addView(profile);
        profile.setOnClickListener(v -> Toast.makeText(this,
            "Profile feature is coming in the next version.", Toast.LENGTH_SHORT).show());

        TextView note = text("Demo build • No account or posts are sent to a server yet.", 12, muted, false);
        note.setPadding(0, 24, 0, 0);
        root.addView(note);
        setContentView(scroll);
    }

    private TextView section(String title) {
        TextView t = text(title, 21, ink, true);
        t.setPadding(0, 28, 0, 12);
        return t;
    }

    private View post(String title, String body) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(18, 16, 18, 16);
        card.setBackgroundColor(Color.WHITE);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.bottomMargin = 14;
        card.setLayoutParams(lp);
        card.addView(text(title, 17, ink, true));
        TextView desc = text(body, 14, muted, false);
        desc.setPadding(0, 8, 0, 0);
        card.addView(desc);
        return card;
    }

    private Button button(String label) {
        Button b = new Button(this);
        b.setText(label);
        b.setAllCaps(false);
        b.setTextColor(Color.WHITE);
        b.setBackgroundTintList(android.content.res.ColorStateList.valueOf(accent));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.topMargin = 20;
        b.setLayoutParams(lp);
        return b;
    }
}
