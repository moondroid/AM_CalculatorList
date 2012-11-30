package eu.areamobile_android_apps.calculatorlist;

import eu.areamobile_android_apps.calculatorlist.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

public class OperationFragment extends Fragment {

	private View mContent;

	public static final int OPERATION_PLUS = 0;
	public static final int OPERATION_MINUS = 1;
	public static final int OPERATION_MUL = 2;
	public static final int OPERATION_DIV = 3;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		final View v = inflater.inflate(R.layout.operation_layout, container,
				false);
		mContent = v;
		return v;
	}

	public int getOperation() {

		RadioGroup rgOp = (RadioGroup) mContent.findViewById(R.id.rg_operation);
		int radioButtonID = rgOp.getCheckedRadioButtonId();

		switch (radioButtonID) {
		case R.id.radio_plus:
			return OPERATION_PLUS;
		case R.id.radio_minus:
			return OPERATION_MINUS;
		case R.id.radio_mult:
			return OPERATION_MUL;
		case R.id.radio_div:
			return OPERATION_DIV;

		default:
			return OPERATION_PLUS;
		}

	}

}
