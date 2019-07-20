package com.example.saibaba.glabbrcodechallange;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment
{
    View contactFragmentView;
    ListView lstContact;


    String[] Name = {"A Tambat","B Tambat","C Tambat"};
    int[] imgs = {R.drawable.defalt};

    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        contactFragmentView =  inflater.inflate(R.layout.fragment_contact, container, false);

        lstContact = contactFragmentView.findViewById(R.id.lstContact);

        MyClass MC = new MyClass();
        lstContact.setAdapter(MC);

        lstContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                //finish();
                //Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),New_Chat.class);
                intent.putExtra("Name",Name[i]);
                startActivity(intent);
            }
        });

        return contactFragmentView;
    }
    class MyClass extends BaseAdapter
    {

        @Override
        public int getCount() {
            return Name.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.contact_list,null);

            ImageView img = view.findViewById(R.id.imgContact);
            TextView txtName= view.findViewById(R.id.txtName);

            img.setImageResource(imgs[0]);
            txtName.setText(Name[i]);

            return view;
        }
    }
}
