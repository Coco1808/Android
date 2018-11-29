package edu.jmi.hello;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.ArrayAdapter;
        import android.widget.AutoCompleteTextView;

public class DropDownActivity extends AppCompatActivity {
    private String[] books = new String[]{"java","JavaScript","PHP","Android"};
    private AutoCompleteTextView actvBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_down);
        actvBooks = (AutoCompleteTextView) findViewById(R.id.actv_books);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,
                android.R.id.text1,books);
        actvBooks.setAdapter(adapter);
    }
}
