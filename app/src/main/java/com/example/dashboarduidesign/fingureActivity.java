package com.example.dashboarduidesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class fingureActivity extends AppCompatActivity {

    Button btnLoginFingurePrint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fingure);

        btnLoginFingurePrint = findViewById(R.id.btnLoginFingurePrint);
        BiometricManager biometricManager = BiometricManager.from(this);
        switch (biometricManager.canAuthenticate()) {
            case BiometricManager.BIOMETRIC_SUCCESS:
                Toast.makeText(this, "You Can Use Your Fingreprint to login", Toast.LENGTH_SHORT).show();
                break;
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Toast.makeText(this, "No Fingreprint Sensor", Toast.LENGTH_SHORT).show();
                btnLoginFingurePrint.setVisibility(View.GONE);
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Toast.makeText(this, "Biometric Sensor is not available ", Toast.LENGTH_SHORT).show();
                btnLoginFingurePrint.setVisibility(View.GONE);
                break;
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                Toast.makeText(this, "Your device don't have any fingreprint , check your sensor setting ", Toast.LENGTH_SHORT).show();
                btnLoginFingurePrint.setVisibility(View.GONE);
                break;
        }
        Executor executor = ContextCompat.getMainExecutor(this);
        final BiometricPrompt biometricPrompt = new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });

        final BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Login")
                .setDescription("User fingerprint to Loogin")
                .setNegativeButtonText("Cancel")
                .build();
        btnLoginFingurePrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biometricPrompt.authenticate(promptInfo);
            }
        });


    }
}