package com.example.sendmessageviewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sendmessageviewbinding.databinding.ActivitySendMessageBinding;
import com.example.sendmessageviewbinding.databinding.ActivityViewBinding;
import com.example.sendmessageviewbinding.model.data.Message;

public class ViewActivity extends AppCompatActivity {

    private ActivityViewBinding binding;
    public static final String TAG = "ViewActivity";
    private Message message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();

        message = bundle.getParcelable(Message.KEY);

       inicialiceView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ViewActivity -> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ViewActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ViewActivity -> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ViewActivity -> onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG, "ViewActivity -> onDestroy()");
    }

    /**
     * Metodo que inicializa todos las vistas o widgets de la interfaz o del input
     */
    private void inicialiceView()
    {
        //tvMessage.setText(person.getName()+" "+person.getSurname()+" "+ person.getDni());
        String userInfo = "La "+message.getSender().getName() + " " + message.getSender().getSurname() +
                " "+ message.getSender().getDni() + " te ha mandado el siguiente mensaje:";
        binding.tvUserInfo.setText(userInfo);
        binding.tvMessage.setText(message.getContent());
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Se ha iniciado la Activity ViewActivity", Toast.LENGTH_SHORT).show();
    }*/
}