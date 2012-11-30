package eu.areamobile_android_apps.calculatorlist;

import eu.areamobile_android_apps.calculatorlist.R;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;


public class CalculateFragment extends Fragment implements OnClickListener {

	public static interface OnCalculateListener {
		public void onCalculate();
	}

	private OnCalculateListener mListener;

	@Override
	public void onAttach(Activity activity) {
		
		super.onAttach(activity);

		try {
			mListener = (OnCalculateListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(
					"containing activity must implement OnClearListener");
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		final View v = inflater
				.inflate(R.layout.calculate_layout, container, false);
		v.findViewById(R.id.btn_result).setOnClickListener(this);

		return v;

	}

	@Override
	public void onClick(View v) {

		if (mListener != null) {
			mListener.onCalculate();
		}
	}

}
