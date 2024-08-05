package com.blerdU.rootworkapp;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ShowViewHolder> {

    private List<Show> shows;

    public ShowAdapter(List<Show> shows) {
        this.shows = shows;
    }

    @Override
    public ShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_item, parent, false);
        return new ShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShowViewHolder holder, int position) {
        Show show = shows.get(position);
        holder.title.setText(show.getTitle());
        holder.description.setText(show.getDescription());
        holder.voteButton.setOnClickListener(v -> {
            show.incrementVotes();
            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() {
        return shows.size();
    }

    public static class ShowViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        Button voteButton;

        public ShowViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.show_title);
            description = itemView.findViewById(R.id.show_description);
            voteButton = itemView.findViewById(R.id.vote_button);
        }
    }
}
