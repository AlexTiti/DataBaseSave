package com.example.administrator.databasesave;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    TextView textView,text_path_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_hello);
        text_path_main = (TextView) findViewById(R.id.text_path_main);

        DBFile dbFile = new DBFile(this);
        File file = dbFile.createFileDirInFileDir("dbFile");
        File crashFile = dbFile.creatCacshFileDirInCrashFile("crashFile");
        textView.setText(file.getPath());
        text_path_main.setText(crashFile.getPath());
        File file1 = dbFile.creatCrashFile("https://dn-prnpraln.qbox.me/ea62070e2fd41e221782.mp3");
        L.e(file1.getAbsolutePath());

    }
}
