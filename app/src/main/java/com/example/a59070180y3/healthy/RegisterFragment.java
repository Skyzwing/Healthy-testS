package com.example.a59070180y3.healthy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by LAB203_54 on 20/8/2561.
 */

public class RegisterFragment extends Fragment {

    private FirebaseAuth fbAuth;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRegiterBtn();
    }

    private void initRegiterBtn(){

        fbAuth = FirebaseAuth.getInstance();
        Button _register =  (Button) getView().findViewById(R.id.new_account);
        _register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText _newEmail = (EditText) getView().findViewById(R.id.register_email);
//                EditText _newNameUser = (EditText) getView().findViewById(R.id.register_name);
//                EditText _newAgeUser = (EditText) getView().findViewById(R.id.register_age);
                EditText _newPasswordUser = (EditText) getView().findViewById(R.id.register_password);
                EditText _newRePasswordUser = (EditText) getView().findViewById(R.id.register_re_password);
                String _newEmailStr = _newEmail.getText().toString();
//                String _newNameUserStr = _newNameUser.getText().toString();
//                String _newAgeUserStr = _newAgeUser.getText().toString();
                String _newPasswordUserStr = _newPasswordUser.getText().toString();
                String _newRePasswordUserStr = _newRePasswordUser.getText().toString();

                if(_newPasswordUserStr.equals(_newRePasswordUserStr)){
                    fbAuth.createUserWithEmailAndPassword(_newEmailStr, _newPasswordUserStr).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                        }

//                if(_newEmailStr.equals("admin")){
//                    Toast.makeText(
//                            getActivity(),
//                            "Email นี้มีอยู่ในระบบแล้ว",
//                            Toast.LENGTH_SHORT
//                    ).show();
//                    Log.d("REGISTER", "USER ALREADY EXIT");
//                }
//                else if (_newUserIdStr.isEmpty() || _newNameUserStr.isEmpty() || _newAgeUserStr.isEmpty() || _newPasswordUserStr.isEmpty()){
//                    Toast.makeText(
//                            getActivity(),
//                            "กรุณาระบุข้อมูลให้ครบถ้วน",
//                            Toast.LENGTH_SHORT
//                    ).show();
//                    Log.d("REGISTER", "USER IS EMPTY");
//                }
                    });
                    Button _regisNewAcc = (Button) getView().findViewById(R.id.new_account);
                    _regisNewAcc.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.d("REGISTER", "GOTO BMI");
                            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.new_account, new BMIFragment());
                        }
                    });
                }
            }
        });
    }
}