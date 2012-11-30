package eu.areamobile_android_apps.calculatorlist;


import java.util.ArrayList;

import eu.areamobile_android_apps.calculatorlist.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends FragmentActivity implements OnItemClickListener {

	private int firstOp, secondOp, operation;
	
	private ListView mCalcList;
	private ArrayList<String> mCalcItems;
	private CalcAdapter mCalcAdapter;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        
        CalcApplication app = (CalcApplication)getApplication();
        mCalcItems = app.getItems();
        
        
        Intent i = getIntent();
        firstOp = i.getIntExtra(MainActivity.EXTRA_FIRST_OP, 0);
        secondOp = i.getIntExtra(MainActivity.EXTRA_SECOND_OP, 0);
        operation = i.getIntExtra(MainActivity.EXTRA_OPERATION, OperationFragment.OPERATION_PLUS);
        
        TextView tvResult = (TextView) findViewById(R.id.tv_result);
        mCalcList = (ListView) findViewById(R.id.lv_result);       
        
        
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(firstOp));
        
        switch (operation){
        
        case OperationFragment.OPERATION_PLUS:
        	sb.append(" + ");
        	sb.append(String.valueOf(secondOp)+" = ");
        	sb.append(String.valueOf(firstOp + secondOp));
        
        	break;
         
        case OperationFragment.OPERATION_MINUS:
        	sb.append(" - ");
        	sb.append(String.valueOf(secondOp)+" = ");
        	sb.append(String.valueOf(firstOp - secondOp));
        	
        	break;
            
        case OperationFragment.OPERATION_MUL:
        	sb.append(" x ");
        	sb.append(String.valueOf(secondOp)+" = ");
        	sb.append(String.valueOf(firstOp * secondOp));
        	
        	break;
            
        case OperationFragment.OPERATION_DIV:
        	sb.append(" : ");
        	sb.append(String.valueOf(secondOp)+" = ");
        	
        	float div;
        	try{
        		div = ((float)firstOp)/((float)secondOp);
        		sb.append(Float.toString(div));
        	}catch(Exception e){
        		sb.append("error");
        	}
        	
        	break;
        
        }
    	
        tvResult.setText(sb.toString());
        
        mCalcItems.add(sb.toString());
        mCalcAdapter = new CalcAdapter(this, mCalcItems);
        mCalcList.setAdapter(mCalcAdapter);
        
        mCalcList.setOnItemClickListener(this);
    }

	@Override
	public void onItemClick(AdapterView<?> listView, View row, int position, long id) {
		
		String text = mCalcItems.get(position);
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
		
	}
	
}
