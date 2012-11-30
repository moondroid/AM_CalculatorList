package eu.areamobile_android_apps.calculatorlist;

import java.util.List;

import eu.areamobile_android_apps.calculatorlist.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

public class CalcAdapter extends BaseAdapter {

	private final List<String> mCalcs;
	private final Context mContext;
	private final LayoutInflater mInflater;

	public CalcAdapter(Context c, List<String> calcs) {

		mCalcs = calcs;
		mInflater = LayoutInflater.from(c);
		mContext = c;
	}

	@Override
	public int getCount() {

		return mCalcs.size();
	}

	@Override
	public String getItem(int position) {

		return mCalcs.get(position);

	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;

		if (convertView == null) {
			convertView = (FrameLayout) mInflater.inflate(R.layout.row_layout,
					parent, false);
			holder = new ViewHolder();
			holder.textView = (TextView) convertView
					.findViewById(R.id.row_text);
			convertView.setTag(holder);
			
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.textView.setText(getItem(position));

		return convertView;
	}

	private class ViewHolder {

		public TextView textView;
	}
}
