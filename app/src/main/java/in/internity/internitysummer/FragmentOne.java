package in.internity.internitysummer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentOne extends Fragment {

    static final String TAG = FragmentOne.class.getSimpleName();

    private View view;

    /*factory method.. */
    public static FragmentOne newInstance(String label) {
        Bundle args = new Bundle();
        args.putString("label", label);
        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_one, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String label = getArguments().getString("label");
        ((TextView) view.findViewById(R.id.tv_label)).setText(label);


    }


    void fragmentTwoBtnPressed() {
        ((TextView) view.findViewById(R.id.tv_label)).setText("Button pressed");
    }
}
