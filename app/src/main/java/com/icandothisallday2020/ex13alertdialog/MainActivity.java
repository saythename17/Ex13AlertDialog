package com.icandothisallday2020.ex13alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickBtn(View view) {
        //1. AlertDialog 를 만들어주는 객체 (Builder)생성
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        //2. Set AlertDialog's Title & Buttons that you want create /to Builder
        builder.setTitle("AlertDialog");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        //3.Set message on Dialog
//        builder.setMessage("Do you wanna build a snowman?");






        //*8. Custom View on Dialog
        //xml 에 View 설계 & 이를 객체로 생성하여 다이알로그에 설정
        //res/layout/dialog.xml ->자바의 View 객체로 만들어주는 객체(LayoutInflater)소환
        //->xml 문서를 주면 객체로 만들어줌
        LayoutInflater inflater=this.getLayoutInflater();
        View v=inflater.inflate(R.layout.dialog,null);
        //                                             └ViewGroup 소속 X
        //만들어진 v를 통해 v(LinearLayout)에있는 et,tv를 찾기
        et=v.findViewById(R.id.et);//※v.※id를 이용해 뷰를 찾아 참조변수에 대입
        tv=v.findViewById(R.id.tv);//※※※※※
        builder.setView(v);







        //4.Set buttons on Dialog
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //이 버튼이 눌러졌을 때 자동으로 실행되는 메소드
                Toast t= Toast.makeText(MainActivity.this,"Let's play together!",Toast.LENGTH_SHORT);
                t.show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast t=Toast.makeText(MainActivity.this,"Go away Anna!",Toast.LENGTH_SHORT);
                t.show();
            }
        });
        //5.Builder 에게 요구사항을 모두 말했으니 이 요구 사항대로 AlertDialog 생성을 요청
        AlertDialog dialog=builder.create();
        //6.Dialog 의 outside click 시 Dialog 꺼짐(Cancel) 설정[default:true]
        dialog.setCanceledOnTouchOutside(false);//outside 를 클릭해도 사라지지 않음
        dialog.setCancelable(false);//outside & 뒤로가기를 눌러도 꺼지지않도록
        //7.만들어진 다이얼로그 화면 보이기
        dialog.show();
    }//clickBtn method..







    //*9.다이얼로그 안 커스텀뷰의 버튼클릭시 실행되는 메소드
    public void clickDB(View v){
        //*10.EditText 에 있는 글씨를 가져와 TextView 에 출력
        String s=et.getText().toString();
        tv.setText(s);
    }









}//MainActivity
