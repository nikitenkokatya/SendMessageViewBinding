package com.example.sendmessageviewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sendmessageviewbinding.databinding.ActivitySendMessageBinding;
import com.example.sendmessageviewbinding.model.data.AboutActivity;
import com.example.sendmessageviewbinding.model.data.Message;
import com.example.sendmessageviewbinding.model.data.Person;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SendMessageActivity extends AppCompatActivity {
    private ActivitySendMessageBinding binding;
    public static final String TAG = "SendMessageActivity";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //exprecion lambda para inplementar el evento OnClick()
        binding.fab.setOnClickListener(view ->
                {
                    sendMessage();
                }
        );
        Log.d(TAG, "SendMessageActivity -> onCreate()");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        /*if (item.getItemId() == R.id.menu_aboutus) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);*/
        switch (item.getItemId()){
            case R.id.menu_aboutus:{
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
            }
            default:
                return super.onCreateOptionsMenu((Menu) item);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
//region metodos
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMessageActivity -> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SendMessageActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SendMessageActivity -> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SendMessageActivity -> onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG, "SendMessageActivity -> onDestroy()");
    }
    //endregion

    //metodo que construye elm mensaje y lo envia
    private void sendMessage(){
        Intent intent  = new Intent(this, ViewActivity.class);
        Bundle bundle = new Bundle();
        Person persone = new Person("Katya", "Nikitenko", "1");
        Person persond = new Person("Jose", "Jimenez", "2");
        Message message = new Message(1, binding.edMessage.getText().toString(), persone, persond);
        bundle.putSerializable(Message.KEY, message);  //ejemplo serializable
        bundle.putParcelable(Message.KEY, message); //ejemplo parcelable
        intent.putExtras(bundle);
        startActivity(intent);

    }

    class SendMessageOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Toast.makeText(SendMessageActivity.this, "Se ha pulsado sobre el boton enviar", Toast.LENGTH_SHORT).show();
        }
    }
}
