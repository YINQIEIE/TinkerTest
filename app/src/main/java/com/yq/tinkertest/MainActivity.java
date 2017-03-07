package com.yq.tinkertest;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "修改前", Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.tv_fix).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String patchPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk";

                File file = new File(patchPath);

                if (file.exists()) {

                    TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), patchPath);

                } else {

                    Toast.makeText(getApplicationContext(), "补丁文件不存在", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}
