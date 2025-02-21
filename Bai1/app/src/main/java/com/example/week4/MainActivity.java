package com.example.week4;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout bgLayout;
    private ArrayList<Integer> backgroundList;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1️⃣ Lấy ConstraintLayout
        ConstraintLayout bgLayout = findViewById(R.id.main);


        // 2️⃣ Thêm danh sách background
        backgroundList = new ArrayList<>();
        backgroundList.add(R.drawable.bg1);
        backgroundList.add(R.drawable.bg2);
        backgroundList.add(R.drawable.bg3);
        backgroundList.add(R.drawable.bg4);

        // 3️⃣ Khởi tạo Random và chọn background ngẫu nhiên
        random = new Random();
        int vitri = random.nextInt(backgroundList.size());

        // 4️⃣ Đặt hình nền ngay khi mở app
        bgLayout.setBackgroundResource(backgroundList.get(vitri));
        ImageButton img2 = findViewById(R.id.imageButton1);
        ImageView img1 = findViewById(R.id.imageView1); // Đảm bảo bạn có ImageView với id này

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1.setImageResource(R.drawable.dart); // Đổi ảnh cho ImageView
                img1.getLayoutParams().width = 550;  // Đặt chiều rộng mới
                img1.getLayoutParams().height = 550; // Đặt chiều cao mới
                img1.requestLayout(); // Cập nhật lại layout
            }
        });
        Switch sw = (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){ //isChecked = true
                    Toast.makeText(MainActivity.this,"Wifi đang bật",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Wifi đang tắt",Toast.LENGTH_LONG).show();
                }
            }
        });
        CheckBox ck1 = (CheckBox) findViewById(R.id.checkBox);
        ck1.setOnCheckedChangeListener(new
                                               CompoundButton.OnCheckedChangeListener() {
                                                   @Override
                                                   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
                                                   {
                                                       if(isChecked){
                                                           bgLayout.setBackgroundResource(R.drawable.bg3);
                                                       }else{
                                                           bgLayout.setBackgroundResource(R.drawable.bg4);
                                                       }
                                                   }
                                               });
        RadioGroup radioGroup = (RadioGroup)
                findViewById(R.id.radioGroup1);
    }
}