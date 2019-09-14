package id.owndigitaldev.qrgeneratorscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GeneratorActivity extends AppCompatActivity {

    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);

        final Context context =this;
        text= findViewById(R.id.txtGen);
        Button generate = findViewById(R.id.btnGenerate);
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtQr = text.getText().toString();
                MultiFormatWriter formatWriter = new MultiFormatWriter();
                try {
                    BitMatrix matrix = formatWriter.encode(txtQr, BarcodeFormat.QR_CODE, 200, 200);
                    BarcodeEncoder encoder = new BarcodeEncoder();
                    Bitmap bitmap = encoder.createBitmap(matrix);
                    Intent intent = new Intent(context, TampilQrActivity.class);
                    intent.putExtra("pic", bitmap);
                    context.startActivity(intent);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
