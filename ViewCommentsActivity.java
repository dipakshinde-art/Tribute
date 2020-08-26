package org.codeextended.uploadimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewCommentsActivity extends AppCompatActivity {

    TextView comments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_comments);
        comments=findViewById(R.id.viewComments);

        String comment=getIntent().getExtras().getString("Comments");
        comments.setText(comment);


    }
}
