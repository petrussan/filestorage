package id.ac.petra.filestorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.etText);

    }

    public void writefile(View view) {
        try {
            FileOutputStream f = openFileOutput("data.txt",MODE_PRIVATE);
            OutputStreamWriter o = new OutputStreamWriter(f);
            o.write(et1.getText().toString());
            o.close();
            Toast.makeText(getBaseContext(),"File saved",Toast.LENGTH_LONG)
                    .show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void readfile(View view) {
        try {
            FileInputStream f = openFileInput("data.txt");
            InputStreamReader i = new InputStreamReader(f);

            char[] inputBuffer = new char[100];
            String s="";
            int charRead;

            while ((charRead=i.read(inputBuffer))>0) {
                String readString = String.copyValueOf(inputBuffer,0,charRead);
                s +=readString;
            }
            i.close();
            et1.setText(s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}