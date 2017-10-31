package com.rap.rhythmandpoetry;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class FourthFragment extends Fragment{

    View myView;
    RoundImage roundedImage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fourth_layout, container, false);
        Button Button = (Button) myView.findViewById(R.id.secretary_button);
        ImageView perah = (ImageView) myView.findViewById(R.id.perah_pic);
        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.perah);
        roundedImage = new RoundImage(bm);
        perah.setImageDrawable(roundedImage);

        Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mail = new Intent(Intent.ACTION_SEND);
                mail.putExtra(Intent.EXTRA_EMAIL, new String[]{"rutledgep20@hanover.edu"});
                mail.setType("message/rfc822");
                startActivity(Intent.createChooser(mail, "Email Malik Using:"));
            }
        });
        perah.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.facebook.com/perah.rutledge"));
                startActivity(intent);
            }
        })
        ;
        return myView;
    }
}

