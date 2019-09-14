package id.owndigitaldev.qrgeneratorscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class TampilQrActivity extends AppCompatActivity {

    ImageView viewQr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_qr);

        viewQr = findViewById(R.id.viewQr);
        Bitmap bitmap = getIntent().getParcelableExtra("pic");
        viewQr.setImageBitmap(bitmap);
    }
}
