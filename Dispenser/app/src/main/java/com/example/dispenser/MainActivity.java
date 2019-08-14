package com.example.dispenser;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView status,imformation,problem,regarding;
    Button done;
    Dialog opendialog;
    TextView titleTv,messageTv,messageTv1;
    ImageView dialogclose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        status=(CardView)findViewById(R.id.status);
        imformation=(CardView)findViewById(R.id.information);
        problem=(CardView)findViewById(R.id.problem);
        regarding=(CardView)findViewById(R.id.regarding);

        status.setOnClickListener(this);
        imformation.setOnClickListener(this);
        problem.setOnClickListener(this);
        regarding.setOnClickListener(this);

        //dialog
        opendialog=new Dialog(this);
    }


    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.status:i=new Intent(this,Status.class);startActivity(i);break;
            case R.id.information:i=new Intent(this,Imformation.class);startActivity(i);break;
            case R.id.problem:i=new Intent(this,Problem.class);startActivity(i);break;
            case R.id.regarding:ShowPositivePopup();break;
            default:

        }

    }
    public void ShowPositivePopup(){
        opendialog.setContentView(R.layout.activity_regarding);
        dialogclose=(ImageView)opendialog.findViewById(R.id.close);
        done=(Button)opendialog.findViewById(R.id.done);
        titleTv=(TextView)opendialog.findViewById(R.id.titleTv);
        messageTv=(TextView)opendialog.findViewById(R.id.messageTv);
        messageTv1=(TextView)opendialog.findViewById(R.id.messageTv1);
        //done and close dialog
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendialog.dismiss();
            }
        });
        dialogclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendialog.dismiss();
            }
        });
        opendialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        opendialog.show();
    }
}
