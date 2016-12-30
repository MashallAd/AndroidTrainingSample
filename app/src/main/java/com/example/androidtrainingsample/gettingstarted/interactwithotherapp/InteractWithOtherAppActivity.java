package com.example.androidtrainingsample.gettingstarted.interactwithotherapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.androidtrainingsample.R;
import com.example.androidtrainingsample.databinding.ActivityInteractWithOtherAppBinding;

import java.util.List;

public class InteractWithOtherAppActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 100;

    private ActivityInteractWithOtherAppBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_interact_with_other_app);
        mBinding.setHandlers(this);
    }

    public void startOtherApp(View view) {

        // bilibili://video/7740365
        // iqiyi://mobile/player?aid=593561200&vid=a1fc4617fd29b8d3683f441c00a2bd6c&tvid=593561200&cid=25&offset=0&down=0&ftype=27&subtype=23

        String uriText = mBinding.etInput.getText().toString().trim();
        uriText = "iqiyi://mobile/player?aid=593561200&vid=a1fc4617fd29b8d3683f441c00a2bd6c&tvid=593561200&cid=25&offset=0&down=0&ftype=27&subtype=23";
        Uri uri = Uri.parse(uriText);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;

        if (isIntentSafe) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "has not app to open", Toast.LENGTH_SHORT).show();
        }
    }

    public void startTakePhoto(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mBinding.iv.setImageBitmap(imageBitmap);
        }
    }
}
