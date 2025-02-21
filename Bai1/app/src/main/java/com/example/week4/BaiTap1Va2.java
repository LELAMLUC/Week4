package com.example.week4;

import android.os.Bundle;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Random;

public class BaiTap1Va2 extends AppCompatActivity {
    private ConstraintLayout bgLayout;
    private ArrayList<Integer> backgroundList;
    private Random random;
    private Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_tap1_va2);

        // 1️⃣ Ánh xạ ConstraintLayout & Switch
        bgLayout = findViewById(R.id.main);
        switch1 = findViewById(R.id.switch1); // Đúng ID

        // 2️⃣ Thêm danh sách background
        backgroundList = new ArrayList<>();
        backgroundList.add(R.drawable.bg1);
        backgroundList.add(R.drawable.bg2);
        backgroundList.add(R.drawable.bg3);
        backgroundList.add(R.drawable.bg4);

        // 3️⃣ Xử lý sự kiện khi bật/tắt Switch
        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                changeBackground(); // Nếu bật switch → đổi hình nền
            } else {
                bgLayout.setBackgroundResource(R.drawable.bg1); // Nếu tắt → về nền mặc định
            }
        });
    }

    // 4️⃣ Hàm chọn hình nền ngẫu nhiên
    private void changeBackground() {
        random = new Random();
        int randomIndex = random.nextInt(backgroundList.size()); // Chọn vị trí ngẫu nhiên
        bgLayout.setBackgroundResource(backgroundList.get(randomIndex)); // Đặt hình nền
    }
}
