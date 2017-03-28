# Search-in-Recyclerview in Android
Search functionality with recyclerview in android. Here is simple demo to make your recyclerview searchable. By following this demo you can implement search functionality to your RecyclerView in android. Here I got country list and display in Recyclerview.

Follow these steps to implement search functionality with RecyclerView : 
1. Create new project with Android studio.
2. Create xml file for MainActivity with RecyclerView and EditText to search.
3. Create list to add in RecyclerView.
4. Do ready RecyclerView.
5. Add "addTextChangedListener" to EditText.
6. Override "onTextChanged" with adapter.filter(s);
7. Add filter(CharSequence sequence) to your adapter class.
8. Now your ready to use your search with RecyclerView.

# xml file

    <EditText
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:inputType="text"
        android:ems="10"
        android:id="@+id/etSearch"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        android:gravity="center"
        android:hint="@string/search"/>

    <android.support.v7.widget.RecyclerView
        app:layout_constraintBottom_toTopOf="@+id/etSearch"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:id="@+id/rvItems"/>
        
        
# filter method in Adapter

`public void filter(CharSequence sequence) {
        ArrayList<String> temp = new ArrayList<>();
        if (!TextUtils.isEmpty(sequence)) {
            for (String s : countries) {
                if (s.toLowerCase().contains(sequence)) {
                    temp.add(s);
                }
            }
        } else {
            temp.addAll(countriesCopy);
        }
        countries.clear();
        countries.addAll(temp);
        notifyDataSetChanged();
        temp.clear();
    }`

