package com.example.flower;

/*public class PlacesListAdapter extends ArrayAdapter<Place> implements
        Filterable {
    public Context context;
    private List<Place> places, orig, itemDetailsrrayList;
    private PlaceFilter filter;

    public PlacesListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public PlacesListAdapter(Context context, int resource, List<Place> places) {
        super(context, resource, places);
        this.context = context;
        this.places = places;

        itemDetailsrrayList = places;
        orig = itemDetailsrrayList;

        filter = new PlaceFilter();
        // imageLoader = new ImageLoader(context.getApplicationContext());

    }

    public int getCount() {
        return itemDetailsrrayList.size();
    }

    public Place getItem(int position) {
        return itemDetailsrrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        // View view = convertView;
        // Place p = places.get(position);

        if (convertView == null) {
            LayoutInflater viewInflater;
            viewInflater = LayoutInflater.from(getContext());
            convertView = viewInflater.inflate(R.layout.item_place, null);

            holder = new ViewHolder();
            holder.placeTitle = (TextView) convertView
                    .findViewById(R.id.place_title);
            holder.placeDistance = (TextView) convertView
                    .findViewById(R.id.place_distance);
            holder.placeCategoryIcon = (ImageView) convertView
                    .findViewById(R.id.place_category_icon);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.placeTitle.setText(itemDetailsrrayList.get(position)
                .getPlaceTitle());
        holder.placeDistance.setText("200");
        holder.placeCategoryIcon.setImageResource(R.drawable.icon_category);

        return convertView;
    }

    static class ViewHolder {
        TextView placeId;
        TextView placeTitle;
        TextView placeDistance;
        ImageView placeCategoryIcon;
    }

    @Override
    public Filter getFilter() {
        // TODO Auto-generated method stub
        return filter;
    }

    private class PlaceFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults oReturn = new FilterResults();
            ArrayList<Place> results = new ArrayList<Place>();
            if (orig == null)
                orig = itemDetailsrrayList;
            if (constraint != null) {
                if (orig != null && orig.size() > 0) {
                    for (Place g : orig) {
                        if (g.getPlaceTitle().toLowerCase()
                                .contains(constraint.toString().toLowerCase()))
                            results.add(g);
                    }
                }
                oReturn.values = results;
            }
            return oReturn;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            itemDetailsrrayList = (ArrayList<Place>) results.values;
            notifyDataSetChanged();
        }

    }
}*/