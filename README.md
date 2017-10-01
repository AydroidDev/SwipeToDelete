# SwipeToDelete

![](https://i.imgur.com/Zfzjwt2.gif)

## Quickstart
This project is a implementation of Swipe to Dismiss feature.

### Example
``` java
SwipeToDismiss swipeToDismiss = new SwipeToDismiss(getContext(), ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
swipeToDismiss.setLeftBackgroundColor(R.color.colorAccent);
swipeToDismiss.setRightBackgroundColor(R.color.colorPrimary);
swipeToDismiss.setLeftImg(R.drawable.ic_adb);
swipeToDismiss.setRightImg(R.drawable.ic_adb);
swipeToDismiss.setSwipetoDismissCallBack(getCallback(myAdapter));
```

``` java
RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
final List<SomeClass> list = getList();
MyAdapter myAdapter = new MyAdapter(list, getContext());
myAdapter.setListPlayerAdapterListener(new myAdapter.myAdapterListener() {
    @Override
    public void onClickListener(int pos) {
        SomeClass p = list.get(pos);
        Toast.makeText(getContext(), p.getAttr(), Toast.LENGTH_SHORT).show();
    }
});

recyclerView.setAdapter(myAdapter);
recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
recyclerView.setItemAnimator(new DefaultItemAnimator());
recyclerView.setHasFixedSize(true);
         
//Left and right swipe
SwipeToDismiss swipeToDismiss = new SwipeToDismiss(getContext(), ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
swipeToDismiss.setLeftBackgroundColor(R.color.colorAccent);
swipeToDismiss.setRightBackgroundColor(R.color.colorPrimary);
swipeToDismiss.setLeftImg(R.drawable.ic_adb);
swipeToDismiss.setRightImg(R.drawable.ic_adb);
swipeToDismiss.setSwipetoDismissCallBack(getCallback(myAdapter));

ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeToDismiss);
itemTouchHelper.attachToRecyclerView(recyclerView);
```

```java
private SwipeToDismiss.SwipetoDismissCallBack getCallback(final ListPlayerAdapter adapter){
    return new SwipeToDismiss.SwipetoDismissCallBack() {
         @Override
         public void onSwipedLeft(RecyclerView.ViewHolder viewHolder) {
            adapter.remove(viewHolder.getAdapterPosition());
        }

        @Override
        public void onSwipedRight(RecyclerView.ViewHolder viewHolder) {
            adapter.remove(viewHolder.getAdapterPosition());
        }
    };
}
```

### Callback
```java
public interface SwipetoDismissCallBack {
        void onSwipedLeft(RecyclerView.ViewHolder viewHolder);
        void onSwipedRight(RecyclerView.ViewHolder viewHolder);
}
```
