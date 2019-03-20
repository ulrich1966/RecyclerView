package de.auli.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    public static List<Person> personArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Objekte anlegen
        personArrayList = new ArrayList<>();
        personArrayList.addAll(Arrays.asList(
               new Person("Frank", "Berlin"),
               new Person("Annette", "Hameln"),
               new Person("Bernd", "Berlin"),
               new Person("Emil", "Hamburg"),
               new Person("Hein Mück", "Bremen"),
               new Person("Resi", "München")));

        recyclerView = findViewById(R.id.id_recyclerview);
        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerViewAdapter = new MyRecyclerViewAdapter();
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

        dividerItemDecoration= new DividerItemDecoration(recyclerView.getContext(), 1);
        recyclerView.addItemDecoration(dividerItemDecoration);

    }
}
