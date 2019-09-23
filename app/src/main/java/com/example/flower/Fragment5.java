package com.example.flower;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment5 extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag5, container, false);
        return view;
    }
}

  /*  private View view;
    public SearchView mSearchView;
    private TextView mStatusView;
    private Menu mainMenu = null;
    PlacesListAdapter adapter;
    ListView listView;

    SearchView.OnQueryTextListener

    {
        CharSequence[] _categories = {"Amusement Park",
                "Bird Sanctuary", "Wild Life", "River", "Hill Station", "Temple",
                "Rafting", "Fishing", "Hiking", "Museums"};

        boolean[] _selections = new boolean[_categories.length];

        final String[] places = new String[]{"Mysore", "Bangalore",
                "Mangalore", "Wayanad", "Bandipur National Park", "Chickmaglur",
                "Bandipura", "Coorg", "Kodaikanal", "Hampi", "Ghati Subramanya",
                "Mekedatu", "Muththathhi", "Shivasamudram", "Talakadu",
                "Savana Durga"};


        @Nullable
        @Override


        Log.i("Nomad", "onCreate");

        List<Place> thePlaces = new ArrayList<Place>();
        for (int i = 0; i < places.length; i++) {
            Place pl = new Place("NO_ID", places[i], "NO_DISTANCE",
                    "NO_CATEGORYICON");
            thePlaces.add(pl);
        }

        listView = (ListView) findViewById(R.id.place_list);
        adapter = new PlacesListAdapter(MainActivity.this, R.layout.item_place,
                thePlaces);

        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(true);

        mSearchView = (SearchView) findViewById(R.id.action_search);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View view, int position,
                                    long id) {

                Toast.makeText(MainActivity.this, "Test", Toast.LENGTH_SHORT);
                startActivity(new Intent(MainActivity.this, PlaceActivity.class));
            }
        });

    }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
        Log.i("Nomad", "onCreateOptionsMenu");
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.activity_main, menu);

        mainMenu = menu;

        MenuItem searchItem = menu.findItem(R.id.action_search);

        // Search View
        mSearchView = (SearchView) searchItem.getActionView();
        setupSearchView(searchItem);

        mSearchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // hide action item
                if (mainMenu != null) {
                    mainMenu.findItem(R.id.action_category).setVisible(false);
                    mainMenu.findItem(R.id.action_sort).setVisible(false);
                }

            }
        });
        mSearchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                // re-show the action button
                if (mainMenu != null) {
                    mainMenu.findItem(R.id.action_category).setVisible(true);
                    mainMenu.findItem(R.id.action_sort).setVisible(true);
                }
                return false;

            }
        });

        Log.i("Nomad", "after setupSearchView()");
        return true;
    }

        public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_search:
                Toast.makeText(this, "Searh", Toast.LENGTH_LONG).show();
                Log.i("Nomad", "Click Search");
                break;

            case R.id.action_category:
                showDialog();
                break;
            case R.id.action_sort_alpha_az:
                Toast.makeText(this, "Alpha AZ", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_sort_alpha_za:
                Toast.makeText(this, "Alpha ZA", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_sort_dist_nf:
                Toast.makeText(this, "Dist NF", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_sort_dist_fn:
                Toast.makeText(this, "Dist FN", Toast.LENGTH_LONG).show();
                break;
            default:
                // return super.onOptionsItemSelected(item);
                break;
        }
        return true;
    }

        private void setupSearchView(MenuItem searchItem) {
        mSearchView.setIconifiedByDefault(true);
        mSearchView.setOnQueryTextListener(this);
        mSearchView.setSubmitButtonEnabled(false);

        searchItem.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_ALWAYS);
        // | MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW
    }

        public boolean onQueryTextChange(String newText) {
        Log.i("Nomad", "onQueryTextChange");

        if (TextUtils.isEmpty(newText)) {
            Log.i("Nomad", "onQueryTextChange Empty String");
            listView.clearTextFilter();
        } else {
            Log.i("Nomad", "onQueryTextChange " + newText.toString());
            adapter.getFilter().filter(newText.toString());
        }
        return true;
    }

        public boolean onQueryTextSubmit(String query) {
        Log.i("Nomad", "onQueryTextSubmit");
        return false;
    }

        public boolean onClose() {
        Log.i("Nomad", "onClose");
        return false;
    }

        protected boolean isAlwaysExpanded() {
        return false;
    }


    }*/