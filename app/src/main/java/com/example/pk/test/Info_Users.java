package com.example.pk.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Info_Users extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<FriendsModel> result;
    private FriendsAdapter adapter;

    ImageView imageView;

    ListView listView;

    private FirebaseDatabase database,database2;
    private DatabaseReference reference,reference2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_users_main);
        Intent intent = getIntent();
        database = FirebaseDatabase.getInstance();
        int pos = intent.getIntExtra("position", 0);
        reference = database.getReference("/" + pos + "/friends");

        listView = (ListView)findViewById(R.id.tagsList);
        reference2 = FirebaseDatabase.getInstance().getReference("/"+pos+"/tags");
        FirebaseListAdapter<String> firebaseListAdapter = new FirebaseListAdapter<String>(
                this,String.class,android.R.layout.simple_list_item_1,
                reference2
        ) {
            @Override
            protected void populateView(View v, String model, int position) {

               TextView textView = (TextView) v.findViewById(android.R.id.text1);
                textView.setText(model);

            }
        };

         listView.setAdapter(firebaseListAdapter);


        result = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.friendsList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(llm);
        adapter = new FriendsAdapter(result);
        recyclerView.setAdapter(adapter);

        TextView textName = (TextView) findViewById(R.id.name);
        TextView textAbout = (TextView) findViewById(R.id.about);
        TextView textGender = (TextView) findViewById(R.id.gender);
        TextView textCompany = (TextView) findViewById(R.id.company);
        TextView textAddress = (TextView) findViewById(R.id.addres);
        TextView textEmail = (TextView) findViewById(R.id.email);
        TextView textEyeColor = (TextView) findViewById(R.id.eyeColor);
        TextView textPhone = (TextView) findViewById(R.id.phone);
        TextView textRegistered = (TextView) findViewById(R.id.registered);
        TextView textFavoriteFruit = (TextView) findViewById(R.id.favorite_fruit);
        TextView textBalance = (TextView) findViewById(R.id.balance);
        TextView textAge = (TextView) findViewById(R.id.age);
        TextView textIsActive = (TextView) findViewById(R.id.isActive);

        String name = intent.getStringExtra("name");
        String about = intent.getStringExtra("about");
        String gender = intent.getStringExtra("gender");
        String company = intent.getStringExtra("company");
        String address = intent.getStringExtra("address");
        String eyeColor = intent.getStringExtra("eyeColor");
        String phone = intent.getStringExtra("phone");
        String registered = intent.getStringExtra("registered");
        String favoriteFruit = intent.getStringExtra("favoriteFruit");
        String email = intent.getStringExtra("email");
        String balance = intent.getStringExtra("balance");
        String age = intent.getStringExtra("age");
        boolean isActive = intent.getBooleanExtra("isActive", false);
        String picture = intent.getStringExtra("picture");

        imageView = (ImageView) findViewById(R.id.imageView);
        Picasso.with(getApplicationContext()).load(picture).into(imageView);

        textName.setText("Name : " + name);
        textAbout.setText("About : " + about);
        textFavoriteFruit.setText("FavoriteFruit : " + favoriteFruit);
        textGender.setText("Gender : " + gender);
        textCompany.setText("Company : " + company);
        textAddress.setText("Address : " + address);
        textEyeColor.setText("Eye Color : " + eyeColor);
        textPhone.setText("Phone : " + phone);
        textEmail.setText("Email : " + email);
        textRegistered.setText("Registered : " + registered);
        textBalance.setText("Balance : " + balance);
        textAge.setText("Age : " + age);
        if (isActive == true) {
            textIsActive.setText("Is Active : true");
        } else textIsActive.setText("Is Active : false");

        updateList();

    }

    private void updateList() {
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                result.add(dataSnapshot.getValue(FriendsModel.class));
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
    private int getItemIndex(FriendsModel user) {
        int index = -1;
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).key.equals(user.key))
                index = i;
            break;
        }
        return index;
    }
}
