package com.example.exfotos_cod_barras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnTiraFoto;
    ImageView imagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retiraFoto();
    }
    private void retiraFoto()
    {
        imagem = (ImageView)findViewById(R.id.imagem);
        Button btnTiraFoto = (Button)findViewById(R.id.btnTiraFoto);
        btnTiraFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        Bundle bundle = data.getExtras();
             //vaii
        if(data != null)
        {
            Bitmap bitmap = (Bitmap)bundle.get("data");
            imagem.setImageBitmap(bitmap);
        }
    }
}
