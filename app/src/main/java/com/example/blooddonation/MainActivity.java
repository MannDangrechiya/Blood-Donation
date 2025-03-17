package com.example.blooddonation;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.blooddonation.activity_profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private donorAdapter adapter;
    private List<Donor> donorList;
    private ImageView profileicon;
    private ImageView context_menu_icon;
    private ImageView menuicon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initial donor list
        donorList = new ArrayList<>();
        donorList.add(new Donor("Hitesh", "A+", "123-456-7890"));
        donorList.add(new Donor("Jayesh", "B-", "987-654-3210"));
        donorList.add(new Donor("Suresh", "AB+", "555-123-4567"));
        donorList.add(new Donor("Hemant", "O+", "111-222-3333"));
        donorList.add(new Donor("Mithil", "A-", "444-555-6666"));
        donorList.add(new Donor("David Wilson", "B+", "777-888-9999"));
        donorList.add(new Donor("Grace Lee", "AB-", "101-202-3030"));
        donorList.add(new Donor("Michael Davis", "O-", "404-505-6060"));
        // Add more donors...

        adapter = new donorAdapter(donorList);
        recyclerView.setAdapter(adapter);

        // Initialize context menu button
        context_menu_icon = findViewById(R.id.context_menu_icon);

        // Register for context menu
        registerForContextMenu(context_menu_icon);

        // Optional: Open context menu on single click instead of long press
        context_menu_icon.setOnClickListener(v -> openContextMenu(context_menu_icon));

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
    }

    private void filterList(String text) {
        List<Donor> filteredList = donorList.stream()
                .filter(donor -> donor.getName().toLowerCase().contains(text.toLowerCase()))
                .collect(Collectors.toList());
        adapter.updateList(filteredList);
    }

    // Create the context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu_icon, menu);
    }

    // Handle menu item clicks
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.option_profile) {
            Toast.makeText(this, "Profile Selected", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, activity_profile.class));
            return true;
        } else if (id == R.id.option_logout) {
            Toast.makeText(this, "Logout Selected", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }
}