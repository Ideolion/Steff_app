//package com.example.ashram_app.ui.home;

//public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeViewHolder> {
//    ArrayList<DataSetList> arrayList;
//    Context context;
//    String URL;
//
//
//    public YoutubeAdapter(ArrayList<DataSetList> arrayList, Context context) {
//        this.arrayList = arrayList;
//        this.context = context;
//
//
//    }
//
//    @NonNull
//    @Override
//    public YoutubeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.video_item_home,parent,false);
//        return new YoutubeViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull YoutubeViewHolder holder, int position) {
//        final DataSetList current = arrayList.get(position);
//
//
//        YoutubeViewHolder.webView.loadUrl(current.getLink());
//
//        YoutubeViewHolder.webView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                URL = current.getLink();
//
//                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                String userid = user.getUid();
//                if (userid.equals(admin1UID)) {
//                    Toast.makeText(context.getApplicationContext(), "длинный ютуб", Toast.LENGTH_SHORT).show();
//                    showDeleteDialog(URL);
//
//                }
//
//
//                return false;
//            }
//        });
//
// }
//
//
//
////        YoutubeViewHolder.button.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////
////                Intent i = new Intent(context,Youtube_fullscreen.class);
////                i.putExtra("link",current.getLink());
////                context.startActivity(i);
////
////
////            }
////        });
//
//
//
//
//    @Override
//    public int getItemCount() {
//        return arrayList.size();
//    }
//
//
//    private void showDeleteDialog(String url) {
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(get);
//
//        builder.setTitle("Удалить видео Youtube");
//        builder.setMessage("Вы уверены что хотите удалить это видео Youtube");
//
//        AlertDialog alertDialog = builder.create();
//        builder.show();
//
//
//    }
//
//}
//

