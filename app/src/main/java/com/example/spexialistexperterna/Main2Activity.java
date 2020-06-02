package com.example.spexialistexperterna;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import java.text.DateFormatSymbols;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {

    Core core;


    ViewGroup parent;

    Context context;

    Profile profile;

    ImageButton img1;
    ImageButton img2;
    ImageButton img3;
    ImageButton img4;
    ImageButton img5;

    ArrayList<Task> tasks;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main2);

        if (getIntent().getExtras() != null) {
            core = getIntent().getParcelableExtra("core");
            profile = getIntent().getParcelableExtra("profile");
        } else {
            System.out.println("Failed to fetch core and profile");
        }

        parent = findViewById(R.id.mainView);

        context = this;

        tasks = new ArrayList<Task>();

        tasks.add(new Task("Ta bort grävlingar under altanen", "1 June", "18:00", "Lorvikagatan", "Hjälp Annika att ta bort grävling \nLovikagartan 1A\n892 12 Leksand\n\nMobil: 0735 - 952 952"));



        parent.removeAllViews();

        parent = findViewById(R.id.mainView);
        View view1 = View.inflate(context, R.layout.app_homepage, null);
        view1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        parent.addView(view1);

        ImageView tore = new ImageView(this);
        tore.setImageResource(R.drawable.torestorpet);




        LoadTasks((ViewGroup)findViewById(R.id.TaskBox));
        SetOncreates();
        img3.setImageResource(R.mipmap.home_button_selected);


    }


    public void SetOncreates() {


        img1 = findViewById(R.id.imgButton1);
        img1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                parent.removeAllViews();

                parent = findViewById(R.id.mainView);
                View view1 = View.inflate(context, R.layout.my_tasks, null);
                view1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


                parent.addView(view1);


                ResetAllImages();
                img1.setImageResource(R.mipmap.my_tasks_selected);

            }
        });




        img2 = findViewById(R.id.imgButton2);
        img2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                parent.removeAllViews();

                parent = findViewById(R.id.mainView);
                View view1 = View.inflate(context, R.layout.create_task, null);
                view1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

                parent.addView(view1);

                ResetAllImages();
                img2.setImageResource(R.mipmap.add_task_selected);

                SkapaUppgift();

            }
        });



        img3 = findViewById(R.id.imgButton3);
        img3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                parent.removeAllViews();

                parent = findViewById(R.id.mainView);
                View view1 = View.inflate(context, R.layout.app_homepage, null);
                view1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

                parent.addView(view1);

                ResetAllImages();
                img3.setImageResource(R.mipmap.home_button_selected);


                LoadTasks((ViewGroup)findViewById(R.id.TaskBox));


            }
        });


        img4 = findViewById(R.id.imgButton4);
        img4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {




                parent.removeAllViews();

                parent = findViewById(R.id.mainView);


                View view1 = View.inflate(context, R.layout.my_page, null);
                view1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                parent.addView(view1);

                TextView name = findViewById(R.id.profileFullName);
                TextView username = findViewById(R.id.profileUsername);
                TextView starcount = findViewById(R.id.profileStarCount);

                String fullname = profile.getFullName();
                String usernamex = "\" " + profile.getUserName() + " \"";
                String stars = profile.getStarCount() + " Stjärnor";

                name.setText(fullname);
                username.setText(usernamex);
                starcount.setText(stars);

                ResetAllImages();
                img4.setImageResource(R.mipmap.my_pages_selected);

                LoadTasks((ViewGroup)findViewById(R.id.ProfileTaskBox));

            }
        });

        img5 = findViewById(R.id.imgButton5);
        img5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                ResetAllImages();
                img5.setImageResource(R.mipmap.settings_selected);


            }
        });
    }

    public void ResetAllImages() {

        img1.setImageResource(R.mipmap.my_tasks);
        img2.setImageResource(R.mipmap.add_task);
        img3.setImageResource(R.mipmap.home_button);
        img4.setImageResource(R.mipmap.my_pages);
        img5.setImageResource(R.mipmap.settings);

    }

    public void LoadTasks(final ViewGroup layout) {

        int i = 0;

        for(Task t : tasks) {

            String title = t.getTitle();
            String startTime = t.getStartTime();
            String endTime = t.getEndTime();



            final View viewx = View.inflate(context, R.layout.task, null);
            viewx.setTag(i);
            layout.addView(viewx);

            TextView text1 = viewx.findViewById(R.id.taskTitle);
            text1.setText(title);

            text1 = viewx.findViewById(R.id.taskStartDate);
            text1.setText(startTime);

            text1 = viewx.findViewById(R.id.taskEndDate);
            text1.setText(endTime);

            viewx.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {

                    int id = Integer.parseInt(v.getTag().toString());


                    layout.removeAllViews();
                    View viewz = View.inflate(context, R.layout.task_fullsize, null);
                    viewz.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


                    TextView textBig = viewz.findViewById(R.id.taskBigTitle);
                    textBig.setText(tasks.get(id).getTitle());

                    textBig = viewz.findViewById(R.id.taskBigTime);
                    textBig.setText(tasks.get(id).getBigMessageTime());

                    textBig = viewz.findViewById(R.id.taskBigMessage);
                    textBig.setText(tasks.get(id).getMessage());

                    layout.addView(viewz);



                }


            });

            i++;

        }
    }

    public void SkapaUppgift() {



        //Edit start time
        final EditText editStartTime = findViewById(R.id.editStartTime);

        editStartTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Calendar mcurrentTime = Calendar.getInstance();
                int year = mcurrentTime.get(Calendar.YEAR);
                int month = mcurrentTime.get(Calendar.MONTH);
                int day = mcurrentTime.get(Calendar.DATE);

                DatePickerDialog mTimePicker;
                mTimePicker = new DatePickerDialog(Main2Activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker timePicker, int selectedYear, int selectedMonth, int selectedDay) {
                        editStartTime.setText(selectedDay + " " + getMonth(selectedMonth));
                    }
                }, year, month, day);
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();


            }
        });

        //Edit start time
        final EditText editEndTime = findViewById(R.id.editEndTime);

        editEndTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(Main2Activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        editEndTime.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });


        ImageView create = findViewById(R.id.CreateTask);
        create.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String title;
                String startTime;
                String endTime;
                String position;
                String message;

                EditText text2 = findViewById(R.id.editTaskName);
                title = text2.getText().toString();

                text2 = findViewById(R.id.editStartTime);
                startTime = text2.getText().toString();

                text2 = findViewById(R.id.editEndTime);
                endTime = text2.getText().toString();

                text2 = findViewById(R.id.editTaskPosition);
                position = text2.getText().toString();

                text2 = findViewById(R.id.editTaskFreeText);
                message = text2.getText().toString();

                tasks.add(new Task(title, startTime, endTime, position, message));

                img3.callOnClick();

            }
        });


    }




    public String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month];
    }






}
