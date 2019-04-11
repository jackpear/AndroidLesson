package com.example.jackp.lesson07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private ImageView roomView;
    private Button upButton;
    private Button downButton;
    private Button leftButton;
    private Button rightButton;
    private Button eventButton;
    private TextView textView;

    private int position;
    private boolean key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        position = 1;
        roomView = (ImageView) (findViewById(R.id.roomView));
        roomView.setImageResource(R.drawable.corridor);
        upButton = (Button) (findViewById(R.id.buttonUp));
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveUp();
            }
        });
        downButton = (Button) (findViewById(R.id.buttonDown));
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveDown();
            }
        });
        leftButton = (Button) (findViewById(R.id.buttonLeft));
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveLeft();
            }
        });
        rightButton = (Button) (findViewById(R.id.buttonRight));
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveRight();
            }
        });
        eventButton = (Button) (findViewById(R.id.actionButton));
        eventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action();
            }
        });
        textView = (TextView) (findViewById(R.id.textView));

        key = false;

    }
    private int getPosition() {
        return position;
    }
    private void setPosition(int pos) {
        position = pos;
    }
    private boolean getKey() {
        return key;
    }
    private void setKey(boolean val) {
        key = val;
    }
    private void moveUp() {
        switch (position) {
            case 1:
                roomView.setImageResource(R.drawable.dragonroom);
                setPosition(2);
                break;
            case 4:
                roomView.setImageResource(R.drawable.tcorridor);
                setPosition(5);
                break;
            case 5:
                roomView.setImageResource(R.drawable.keyroom);
                setPosition(7);
                break;
            default:
                textView.setText("You cannot move up");
        }
        event(getPosition());
    }
    private void moveDown() {
        switch (position) {
            case 2:
                roomView.setImageResource(R.drawable.corridor);
                setPosition(1);
                break;
            case 5:
                roomView.setImageResource(R.drawable.lcorridor);
                setPosition(4);
                break;
            case 7:
                roomView.setImageResource(R.drawable.tcorridor);
                setPosition(5);
                break;
            default:
                textView.setText("You cannot move down");
        }
        event(getPosition());
    }
    private void moveLeft() {
        switch (position) {
            case 1:
                roomView.setImageResource(R.drawable.lcorridor);
                setPosition(4);
                break;
            case 3:
                roomView.setImageResource(R.drawable.corridor);
                setPosition(1);
                break;
            case 5:
                roomView.setImageResource(R.drawable.ogreroom);
                setPosition(6);
                break;
            default:
                textView.setText("You cannot move left");
        }
        event(getPosition());
    }
    private void moveRight() {
        switch (position) {
            case 1:
                roomView.setImageResource(R.drawable.doorroom);
                setPosition(3);
                break;
            case 4:
                roomView.setImageResource(R.drawable.corridor);
                setPosition(1);
                break;
            case 6:
                roomView.setImageResource(R.drawable.tcorridor);
                setPosition(5);
                break;
            default:
                textView.setText("You cannot move right");
        }
        event(getPosition());
    }
    private void action() {
        switch (position) {
            case 3:
                if (getKey()) {
                    win();
                } else {
                    textView.setText("You need a key to open this door");
                }
                break;
            case 7:
                setKey(true);
                textView.setText("You took the key");
                break;
            default:
                textView.setText("There is no action to perform here");
        }
    }
    private void event(int pos) {
        switch (pos) {
            case 3:
                if (getKey()) {
                    textView.setText("Press ACTION to unlock the door");
                } else {
                    textView.setText("This door ");
                }
                break;
            case 6:
                if (getKey()) {
                    textView.setText("The ogre stole your key! You can get it back where you found it");
                    setKey(false);
                } else {
                    textView.setText("There is a greedy ogre here, fortunately he is not interested in you");
                }
                break;
            case 7:
                textView.setText("Press ACTION to pick up the key");
                break;
            case 10:
                //TODO: reset after win
                break;
            default:
                textView.setText(" ");
        }
    }
    private void win() {
        textView.setText("You found your way out of the dungeon!");
        roomView.setImageResource(R.drawable.youwin);
        setPosition(10);
    }




}
