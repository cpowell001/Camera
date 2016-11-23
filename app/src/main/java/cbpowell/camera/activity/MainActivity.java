package cbpowell.camera.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import cbpowell.camera.R;

public class MainActivity extends BaseActivity {
    private static final int PERMISSION_REQUEST_WRITE_EXTERNAL_STORAGE = 1001;
    private boolean _storagePermission = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _storagePermission = checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                PERMISSION_REQUEST_WRITE_EXTERNAL_STORAGE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_WRITE_EXTERNAL_STORAGE: {
                _storagePermission = grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED;

                if(!_storagePermission) {
                    toast(getString(R.string.error_permission_required_write_storage));
                    finish();
                }

                return;
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void onClickStart(View view) {
        startCameraActivity();
    }

    private void startCameraActivity() {

        if(_storagePermission) {
            startActivity(new Intent(this, CameraActivity.class));
        }
        else {
            toast(getString(R.string.error_permission_required_write_storage));
        }
    }


}
