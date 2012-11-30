package eu.areamobile_android_apps.calculatorlist;

import eu.areamobile_android_apps.calculatorlist.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class InputFragment extends Fragment {

	private View mContent;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		final View v = inflater
				.inflate(R.layout.input_layout, container, false);
		mContent = v;
		return v;
	}

	public int getOperand() {

		EditText etFirstOp = (EditText) mContent
				.findViewById(R.id.et_operand);
		String sFirstOp = etFirstOp.getText().toString();

		if (!TextUtils.isEmpty(sFirstOp)) {
			return Integer.valueOf(sFirstOp);
		} else {
			return 0;
		}

	}


}
