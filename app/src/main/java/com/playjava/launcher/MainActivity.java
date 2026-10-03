package com.playjava.launcher;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private LinearLayout content;
    private final int dark = Color.rgb(18, 38, 58);
    private final int blue = Color.rgb(74, 144, 226);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showHome();
    }

    private void setup(String title) {
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(Color.rgb(245, 250, 255));

        TextView header = text(title, 28, true);
        header.setTextColor(dark);
        header.setGravity(Gravity.CENTER_VERTICAL);
        header.setPadding(24, 30, 24, 20);
        root.addView(header, new LinearLayout.LayoutParams(-1, 90));

        ScrollView scroll = new ScrollView(this);
        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(20, 10, 20, 20);
        scroll.addView(content);
        root.addView(scroll, new LinearLayout.LayoutParams(-1, 0, 1));

        LinearLayout nav = new LinearLayout(this);
        nav.setOrientation(LinearLayout.HORIZONTAL);
        nav.setGravity(Gravity.CENTER);
        nav.setBackgroundColor(Color.WHITE);
        nav.addView(navButton("Home", this::showHome));
        nav.addView(navButton("Profiles", this::showProfiles));
        nav.addView(navButton("Mods", this::showMods));
        nav.addView(navButton("Settings", this::showSettings));
        root.addView(nav, new LinearLayout.LayoutParams(-1, 70));

        setContentView(root);
    }

    private TextView text(String value, float size, boolean bold) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(dark);
        if (bold) t.setTypeface(null, Typeface.BOLD);
        t.setPadding(8, 10, 8, 10);
        return t;
    }

    private Button navButton(String value, Runnable action) {
        Button b = new Button(this);
        b.setText(value);
        b.setOnClickListener(v -> action.run());
        b.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1));
        return b;
    }

    private void card(String title, String subtitle) {
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        box.setBackgroundColor(Color.WHITE);
        box.setPadding(20, 15, 20, 15);
        box.addView(text(title, 19, true));
        box.addView(text(subtitle, 14, false));
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(-1, -2);
        p.setMargins(0, 8, 0, 8);
        content.addView(box, p);
    }

    private Button actionButton(String value, Runnable action) {
        Button b = new Button(this);
        b.setText(value);
        b.setOnClickListener(v -> action.run());
        return b;
    }

    private void showHome() {
        setup("PLAYJAVA");
        content.addView(text("Java Edition. Anywhere.", 16, false));
        content.addView(text("Ready for takeoff", 25, true));
        card("Survival", "Minecraft 1.20.1 • Vanilla");

        Button play = actionButton("▶  PLAY JAVA", () -> Toast.makeText(
                this,
                "PlayJava UI is ready. Minecraft runtime integration is the next milestone.",
                Toast.LENGTH_LONG
        ).show());
        play.setTextColor(Color.WHITE);
        play.setBackgroundColor(blue);
        content.addView(play);

        card("Touch Controls", "Default mobile controls");
        card("Performance", "Balanced mode");
        card("Java Runtime", "Ready for future runtime integration");
    }

    private void showProfiles() {
        setup("Profiles");
        content.addView(text("Minecraft Java configurations", 16, false));
        content.addView(actionButton("＋  Create Profile", () -> Toast.makeText(
                this, "Profile creation coming soon.", Toast.LENGTH_SHORT).show()));
        card("Survival", "1.20.1 • Vanilla");
        card("Creative Lab", "1.21.1 • Vanilla");
    }

    private void showMods() {
        setup("Mods & Packs");
        content.addView(text("Manage Minecraft Java content", 16, false));
        card("Mods", "0 installed");
        card("Resource Packs", "0 installed");
        card("Shaders", "0 installed");
        card("Safety", "PlayJava does not bundle Minecraft game files or bypass authentication.");
    }

    private void showSettings() {
        setup("Settings");
        content.addView(text("PlayJava preferences", 16, false));
        card("Touch Controls", "Configure mobile controls");
        card("Performance", "Balanced / Performance modes");
        card("Diagnostics", "Launcher diagnostics");
        card("Backups", "World and profile backups");
        content.addView(text("PlayJava v0.1.0", 14, false));
    }
}
