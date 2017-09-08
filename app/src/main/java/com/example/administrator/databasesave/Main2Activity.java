package com.example.administrator.databasesave;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.databasesave.mvp.Userbean;
import com.example.administrator.databasesave.mvp.base.BaseView;
import com.example.administrator.databasesave.mvp.base.UserPresentImpl;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity implements BaseView<Userbean> {


    @Bind(R.id.button)
    Button button;
    @Bind(R.id.button_send_main)
    Button button_send_main;
    public static String FOLDERNAME = "三爸育儿";

    public static String IMAGE_FILE_SAVE_PATH = Environment.getExternalStorageDirectory() + File.separator + FOLDERNAME + File.separator+"宝宝图片"+File.separator+"baby_20170731145513.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        UserPresentImpl present = new UserPresentImpl(this);
        present.attchView(this);
        present.dealWithData();
        L.e("======",IMAGE_FILE_SAVE_PATH);

    }

    @Override
    public void onSuccess(ArrayList<Userbean> userbeen) {
        L.e("onSuccess===", userbeen.size() + "====");
        for (Userbean bean : userbeen) {
            // textView.setText(textView.getText().toString() + bean.getName() + bean.getAge());
        }
    }

    @Override
    public void onFaild(String e) {
        L.e("onFaild===", e);
    }

    /**
     * Share Send Text Content
     *
     * @param view
     */

    @OnClick({R.id.button, R.id.button_send_main,R.id.button3})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.button:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "This is my send test");
                intent.setType("text/plain");
                startActivity(intent);
                break;
            case R.id.button_send_main:

                File file = new File(IMAGE_FILE_SAVE_PATH);
                Uri uri = Uri.fromFile(file);
                Intent intentone = new Intent(Intent.ACTION_SEND);
                intentone.putExtra(Intent.EXTRA_STREAM, uri);
                intentone.setType("image/png");
                startActivity(Intent.createChooser(intentone,"Music"));
                break;
            case R.id.button3:

                File file3 = new File(IMAGE_FILE_SAVE_PATH);
                Uri uri3 = Uri.fromFile(file3);
                ArrayList<Uri> list = new ArrayList<>();
                list.add(uri3);
                list.add(uri3);

                Intent intentone3 = new Intent(Intent.ACTION_SEND_MULTIPLE);
                intentone3.putParcelableArrayListExtra(Intent.EXTRA_STREAM, list);
                intentone3.setType("image/*");
                startActivity(Intent.createChooser(intentone3,"Music"));
                break;



        }



    }

}
