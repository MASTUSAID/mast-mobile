package com.rmsi.android.mast.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rmsi.android.mast.activity.ListActivity;
import com.rmsi.android.mast.activity.R;
import com.rmsi.android.mast.db.DbController;
import com.rmsi.android.mast.domain.PersonOfInterest;
import com.rmsi.android.mast.domain.RelationshipType;
import com.rmsi.android.mast.domain.ResourcePersonOfInterest;
import com.rmsi.android.mast.util.StringUtility;

import java.util.List;

/**
 * Created by Ambar.Srivastava on 1/13/2018.
 */

public class ResourcePersonOfInterestListAdapter extends BaseAdapter {
    private List<ResourcePersonOfInterest> persons;
    private LayoutInflater lInflator;
    Context context;
    ListActivity activityObj;
    private List<RelationshipType> relTypes;

    public ResourcePersonOfInterestListAdapter(Context context, ListActivity activityObj, List<ResourcePersonOfInterest> persons) {
        this.context = context;
        this.persons = persons;
        this.lInflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.activityObj = activityObj;
        relTypes = DbController.getInstance(context).getRelationshipTypes(true);
    }

    public int getCount() {
        return persons.size();
    }

    public ResourcePersonOfInterest getItem(int position) {
        return persons.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ResourcePersonOfInterest person = getItem(position);

        if (convertView == null) {
            convertView = lInflator.inflate(R.layout.item_list_row, parent, false);
        }

        TextView textViewItem = (TextView) convertView.findViewById(R.id.surveyData);
        ImageButton options = (ImageButton) convertView.findViewById(R.id.optionsButton);

        textViewItem.setText(getPoiName(person));
        options.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityObj.showPopup(v, position);
            }
        });

        return convertView;
    }

    private String getPoiName(ResourcePersonOfInterest person){
        String name = "";
        if(person != null){
            name = StringUtility.empty(person.getName());
            if(person.getRelationshipId() > 0 && relTypes != null){
                for(RelationshipType relType : relTypes){
                    if(relType.getCode() == person.getRelationshipId()){
                        name += " (" + relType.toString() + ")";
                        break;
                    }
                }
            }
        }
        return name;
    }
}
