package cbpowell.camera.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import cbpowell.camera.activity.BaseActivity;

public class BaseFragment extends Fragment {
    private BaseActivity _baseActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            _baseActivity = (BaseActivity) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement " +
                    BaseActivity.class.getSimpleName());
        }
    }

    public BaseActivity getBaseActivity() {
        return _baseActivity;
    }

    protected boolean checkPermission(String permission, int requestCode) {
        return _baseActivity.checkPermission(permission, requestCode);
    }

    protected void toast(final String message) {
        final Activity activity = getActivity();

        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}