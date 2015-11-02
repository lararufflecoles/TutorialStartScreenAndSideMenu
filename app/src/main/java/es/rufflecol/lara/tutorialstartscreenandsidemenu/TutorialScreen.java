package es.rufflecol.lara.tutorialstartscreenandsidemenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class TutorialScreen extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_screen);

        ImageView imageView = (ImageView) findViewById(R.id.bm);
        imageView.setImageResource(R.drawable.bm);

        button = (Button) findViewById(R.id.doneButton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TutorialScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}