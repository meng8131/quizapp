package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int score;

    public void checkScore(View view) {
        score = 0;
        if (if_answered_question_1()) {
            score_question_1();
            if (if_answered_question_2()) {
                score_question_2();
                if (if_answered_question_3()) {
                    score_question_3();
                    if (if_answered_question_4()) {
                        score_question_4();
                    } else {
                        Toast.makeText(getApplicationContext(), getString(R.string.toast_question_4_no_answer), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), getString(R.string.toast_question_3_no_answer), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), getString(R.string.toast_question_2_no_answer), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.toast_question_1_no_answer), Toast.LENGTH_SHORT).show();
        }
        TextView setScore = (TextView) findViewById(R.id.displayScore);
        setScore.setText(getString(R.string.final_score) + score);
    }

    public void scoreReview(View view) {
        if (if_answered_info()){
            TextView answer_1 = (TextView) findViewById(R.id.answer_question_1);
            answer_1.setText(getString(R.string.question_1_answer));

            TextView answer_2 = (TextView) findViewById(R.id.answer_question_2);
            answer_2.setText(getString(R.string.question_2_answer));

            TextView answer_3 = (TextView) findViewById(R.id.answer_question_3);
            answer_3.setText(getString(R.string.question_3_answer));
        } else {
            Toast.makeText(getApplicationContext(),getString(R.string.toast_info_no_answer), Toast.LENGTH_SHORT).show();
        }
    }

    private boolean if_answered_question_1() {
        RadioButton option_1 = (RadioButton) findViewById(R.id.question_1_option_1);
        RadioButton option_2 = (RadioButton) findViewById(R.id.question_1_option_2);
        RadioButton option_3 = (RadioButton) findViewById(R.id.question_1_option_3);
        RadioButton option_4 = (RadioButton) findViewById(R.id.question_1_option_4);
        return option_1.isChecked() | option_2.isChecked() | option_3.isChecked() | option_4.isChecked();
    }

    private int score_question_1() {
        RadioButton option_1 = (RadioButton) findViewById(R.id.question_1_option_1);
        if (option_1.isChecked()) {
            score += 25;
        }
        return score;
    }

    private boolean if_answered_question_2() {
        CheckBox option_1 = (CheckBox) findViewById(R.id.question_2_option_1);
        CheckBox option_2 = (CheckBox) findViewById(R.id.question_2_option_2);
        CheckBox option_3 = (CheckBox) findViewById(R.id.question_2_option_3);
        return option_1.isChecked() | option_2.isChecked() | option_3.isChecked();
    }

    private int score_question_2() {
        CheckBox option_1 = (CheckBox) findViewById(R.id.question_2_option_1);
        CheckBox option_2 = (CheckBox) findViewById(R.id.question_2_option_2);
        CheckBox option_3 = (CheckBox) findViewById(R.id.question_2_option_3);
        if (option_1.isChecked() & option_2.isChecked() & option_3.isChecked()) {
            score += 10;
        } else if (option_1.isChecked() & option_2.isChecked()) {
            score += 25;
        } else if (option_1.isChecked() | option_2.isChecked()) {
            score += 10;
        }
        return score;
    }

    private boolean if_answered_question_3() {
        RadioButton option_1 = (RadioButton) findViewById(R.id.question_3_option_1);
        RadioButton option_2 = (RadioButton) findViewById(R.id.question_3_option_2);
        RadioButton option_3 = (RadioButton) findViewById(R.id.question_3_option_3);
        return option_1.isChecked() | option_2.isChecked() | option_3.isChecked();
    }

    private int score_question_3() {
        RadioButton option_3 = (RadioButton) findViewById(R.id.question_3_option_3);
        if (option_3.isChecked()) {
            score += 25;
        }
        return score;
    }

    private boolean if_answered_question_4() {
        EditText edited = (EditText) findViewById(R.id.question_4);
        String ifEdited = edited.getText().toString();
        if (ifEdited.matches("")) {
            return false;
        } else {
            return true;
        }
    }

    private int score_question_4() {
        return score += 25;
    }
/*
 *  check if personal info is answered before review the right answers
 *  please help why this is not working
 */
    private boolean if_answered_info() {
        EditText info_name = (EditText) findViewById(R.id.info_name);
        String nameEdited = info_name.getText().toString();

        EditText info_country = (EditText) findViewById(R.id.info_country);
        String countryEdited = info_country.getText().toString();

        RadioButton role_1 = (RadioButton) findViewById(R.id.info_role_1);
        RadioButton role_2 = (RadioButton) findViewById(R.id.info_role_2);

        boolean info_answered = false;

        if (!TextUtils.isEmpty(nameEdited) && !TextUtils.isEmpty((countryEdited))){
            if (role_1.isChecked() | role_2.isChecked()){
                info_answered = true;
            } else {
                Toast.makeText(getApplicationContext(), getString(R.string.toast_info_no_answer), Toast.LENGTH_SHORT);
            }
        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.toast_info_no_answer), Toast.LENGTH_SHORT);
        }
        return info_answered;
    }
}