package com.example.footballmanager2d;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.*;

public class MainActivity extends Activity {

    int week = 1;
    int points = 0;
    int wins = 0;
    int budget = 12000000;

    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(20, 20, 20, 20);
        root.setBackgroundColor(Color.rgb(18, 32, 42));

        TextView title = new TextView(this);
        title.setText("⚽ FOOTBALL MANAGER 2D");
        title.setTextColor(Color.WHITE);
        title.setTextSize(24);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 10, 0, 20);

        root.addView(title);

        info = new TextView(this);
        info.setTextColor(Color.WHITE);
        info.setTextSize(17);
        info.setPadding(0, 10, 0, 20);

        root.addView(info);

        addButton(root, "🏟 МАТЧ", v -> playMatch());
        addButton(root, "🏃 ТРЕНИРОВКА", v -> training());
        addButton(root, "💰 ТРАНСФЕРЫ", v -> transfer());
        addButton(root, "📋 СОСТАВ", v -> squad());
        addButton(root, "🏆 ТАБЛИЦА", v -> table());

        updateInfo();

        setContentView(root);
    }

    void addButton(
            LinearLayout root,
            String text,
            android.view.View.OnClickListener listener) {

        Button button = new Button(this);

        button.setText(text);
        button.setTextSize(17);
        button.setOnClickListener(listener);

        root.addView(
                button,
                new LinearLayout.LayoutParams(
                        -1,
                        60
                )
        );
    }

    void playMatch() {

        boolean win = Math.random() > 0.45;

        if (win) {
            wins++;
            points += 3;

            Toast.makeText(
                    this,
                    "Победа! ⚽",
                    Toast.LENGTH_SHORT
            ).show();

        } else {

            if (Math.random() > 0.5) {
                points++;
                Toast.makeText(
                        this,
                        "Ничья!",
                        Toast.LENGTH_SHORT
                ).show();
            } else {
                Toast.makeText(
                        this,
                        "Поражение",
                        Toast.LENGTH_SHORT
                ).show();
            }
        }

        week++;

        updateInfo();
    }

    void training() {

        budget -= 50000;

        Toast.makeText(
                this,
                "Команда потренировалась!",
                Toast.LENGTH_SHORT
        ).show();

        updateInfo();
    }

    void transfer() {

        if (budget >= 3000000) {

            budget -= 3000000;

            Toast.makeText(
                    this,
                    "Новый игрок подписан!",
                    Toast.LENGTH_SHORT
            ).show();

        } else {

            Toast.makeText(
                    this,
                    "Недостаточно денег!",
                    Toast.LENGTH_SHORT
            ).show();
        }

        updateInfo();
    }

    void squad() {

        Toast.makeText(
                this,
                "Состав: 18 игроков\nСредний OVR: 74",
                Toast.LENGTH_LONG
        ).show();
    }

    void table() {

        Toast.makeText(
                this,
                "FC Aurora\nОчки: " + points +
                "\nПобеды: " + wins,
                Toast.LENGTH_LONG
        ).show();
    }

    void updateInfo() {

        info.setText(
                "FC Aurora\n\n" +
                "Сезон: 1\n" +
                "Неделя: " + week + "\n\n" +
                "💰 Бюджет: €" +
                String.format("%,d", budget) +
                "\n" +
                "🏆 Очки: " + points +
                "\n" +
                "⚽ Победы: " + wins +
                "\n\n" +
                "Тактика: 4-3-3\n" +
                "Игроков: 18"
        );
    }
    }
