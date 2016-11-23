package cbpowell.camera.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;

import cbpowell.camera.fragment.CameraFragment;

public class CameraActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null) {
            actionBar.hide();
        }

//        setContentView(R.layout.activity_camera);
        CameraFragment fragment = new CameraFragment();
        fragment.setArguments(getIntent().getExtras());

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, fragment)
                .commit();
    }
}
