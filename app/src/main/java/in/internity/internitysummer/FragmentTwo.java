package in.internity.internitysummer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class FragmentTwo extends Fragment {

    interface FragmentTwoListener {
        void onBtnPressed();
    }

    private View view;
    private FragmentTwoListener mFragmentTwoListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mFragmentTwoListener = (FragmentTwoListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_two, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        view.findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "clicked", Toast.LENGTH_SHORT).show();
//                ((MainActivity) getActivity()).mSampleText.setText("Btn CLicked");

                mFragmentTwoListener.onBtnPressed();
            }
        });

    }

}
