package GmailClone;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.hfad.builderpattern.ContentActivity;
import com.hfad.builderpattern.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private static final String DEBUG_TAG = "tag";
    private Toast toast;
    GMC_RecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    //
    Spinner spinner;
    TextView name;


    ArrayList<GmailCloneModel> gmailCloneModels = new ArrayList<>();

    int[] gmailCloneImages = {R.drawable.vector_1, R.drawable.vector_2,
            R.drawable.vector_3, R.drawable.vector_4, R.drawable.vector_5,
            R.drawable.vector_6, R.drawable.vector_7, R.drawable.vector_8,
            R.drawable.vector_9, R.drawable.vector_10};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //navigation
        setNavigationDrawer();
        recyclerView = findViewById(R.id.recycler_view);
        setUpGmailCloneModels();
        adapter = new GMC_RecyclerViewAdapter(this, gmailCloneModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        //add ItemDecoration
        recyclerView.addItemDecoration(new DividerItemDecoration(this, R.drawable.divider));
        //ItemTouchHelper
        initItemTouchHelper();
        //fab
        setFab();
        //spinner
        setSpinner();
    }

    public void setNavigationDrawer(){
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        //instantiate navigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.all_inbox:
                        toast = Toast.makeText(MainActivity.this, "All inboxes clicked", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.primary:
                        toast = Toast.makeText(MainActivity.this, "Primary clicked", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.social:
                        toast = Toast.makeText(MainActivity.this, "Social Clicked", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.promotions:
                        toast = Toast.makeText(MainActivity.this, "Promotions Clicked Clicked", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.starred:
                        toast = Toast.makeText(MainActivity.this, "Starred Clicked", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.important:
                        toast = Toast.makeText(MainActivity.this, "Important Clicked", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.sent:
                        toast = Toast.makeText(MainActivity.this, "Sent Clicked", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.outbox:
                        toast = Toast.makeText(MainActivity.this, "Outbox Clicked", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.drafts:
                        toast = Toast.makeText(MainActivity.this, "Drafts Clicked", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.all_mail:
                        toast = Toast.makeText(MainActivity.this, "All mail Clicked", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.spam:
                        toast = Toast.makeText(MainActivity.this, "Spam Clicked", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.trash:
                        toast = Toast.makeText(MainActivity.this, "Trash Clicked", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.calendar:
                        toast = Toast.makeText(MainActivity.this, "Calendar Clicked", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.contacts:
                        toast = Toast.makeText(MainActivity.this, "Contacts Clicked", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.settings:
                        toast = Toast.makeText(MainActivity.this, "Settings Clicked", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.help_feedback:
                        toast = Toast.makeText(MainActivity.this, "Help & Feedback Clicked", Toast.LENGTH_SHORT);
                        toast.show();
                        break;

                }
                return true;

            }
        });
    }

    private void setUpGmailCloneModels() {
        //Get Arrays from the resources and initialise the array with those vallues
        String[] messageTitles = getResources().getStringArray(R.array.message_title);
        String[] messageText = getResources().getStringArray(R.array.message_text);
        String[] dates = getResources().getStringArray(R.array.dates);

        //loop through the array and add each individual value in the arraylist of GmailCLoneModel objects
        for (int i = 0; i < messageTitles.length; i++) {
            gmailCloneModels.add(new GmailCloneModel(messageTitles[i],
                    messageText[i],
                    dates[i],
                    gmailCloneImages[i]));

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Handle item selection
        switch (item.getItemId()) {
            case R.id.search_icon:
                toast = Toast.makeText(this, "Search Button Clicked", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void initItemTouchHelper() {
        //Create callback
        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                adapter.removeItem(position);
                //if
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }


    public void setFab() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ContentActivity.class);
                startActivity(intent);

            }
        });
    }

    public void setSpinner() {

        spinner = (Spinner) findViewById(R.id.spinner);
        //Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.emails, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        //specify the interface implementation
        spinner.setOnItemSelectedListener(MainActivity.this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        name = (TextView) findViewById(R.id.user_name);
        String spinnerItems[] = getResources().getStringArray(R.array.message_title);
        String value = spinnerItems[position];
        name.setText(value);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //Do nothing
    }
}
