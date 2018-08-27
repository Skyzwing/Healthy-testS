package com.example.a59070180y3.healthy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.KeyEventCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by LAB203_54 on 20/8/2561.
 */

public class BMIFragment extends Fragment, KeyEventCompat{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bmi, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button _calculate = (Button) getView().findViewById(R.id.calculate);
        _calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText _height = (EditText) getView().findViewById(R.id.bmi_height);
                EditText _weight = (EditText) getView().findViewById(R.id.bmi_weight);
                TextView _bmiText = (TextView) getView().findViewById(R.id.bmiResult);
                String _heightStr = _height.getText().toString();
                String _weightStr = _weight.getText().toString();
                if(_heightStr.isEmpty() && _weightStr.isEmpty()){
                    Toast.makeText(
                            getActivity(),
                            "กรุณาระบุข้อมูลให้ครบถ้วน",
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.d("BMI", "FIELD NAME IS EMPTY");
                }else{
                    Double _heightInt = Double.parseDouble(_heightStr)/100;
                    Double _weightInt = Double.parseDouble(_weightStr);
                    Double _bmiCalculate = _weightInt/(_heightInt*_heightInt);
                    _bmiText.setText(String.format("%.2f", _bmiCalculate));

                }
            }
        });
        Button _backBtn = (Button) getView().findViewById(R.id.previous);
        _backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new MenuFragment()).commit();
            }
        });
    }
}
