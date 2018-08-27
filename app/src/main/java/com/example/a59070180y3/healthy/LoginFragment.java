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


public class LoginFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login,container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button _loginBtn = (Button) getView().findViewById(R.id.login_login_id);
        _loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText _userID = (EditText) getView().findViewById(R.id.login_user_id);
                EditText _password = (EditText) getView().findViewById(R.id.login_pass_id);
                String _userIdStr = _userID.getText().toString();
                String _passIdStr = _password.getText().toString();
                if (_userIdStr.isEmpty() || _passIdStr.isEmpty()){
                    Toast.makeText(
                            getActivity(),
                            "กรุณาระบุ Username หรือ Password",
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.d("USER", "USER OR PASSWORD IS EMPTY");
                }else if(_userIdStr.equals("admin")&& _passIdStr.equals("admin")){
                    Log.d("USER", "GOTO BMI");
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_view, new MenuFragment())
                            .commit();
                }else{
                    Log.d("USER", "INVALID USER OR PASSWORD");
                }
            }
        });
        Button _regisBtn = (Button) getView().findViewById(R.id.register_button);
        _regisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new RegisterFragment()).commit();
                Log.d("USER", "GOTO REGISTER");
            }
        });
    }
}
