package com.mcltechnologies.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


class ElementAdapter extends ArrayAdapter<Element> {
    ElementAdapter(Context context, List<Element> elements) {
        super(context, 0, elements);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.profile_line, parent, false);
        }
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.description = (TextView) convertView.findViewById(R.id.description);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            convertView.setTag(viewHolder);
        }
        final Element element = getItem(position);
        if (element != null) {
            viewHolder.name.setText(element.getName());
            viewHolder.description.setText(element.getDescription());
//            viewHolder.avatar.setImageDrawable(element.getAvatar());
            viewHolder.avatar.setColorFilter(element.getColor());

            final CustomListItem listItem = (CustomListItem) convertView;
            listItem.setChecked(element.isSelected());
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    element.setSelected(!element.isSelected());
                    listItem.setChecked(element.isSelected());
                }
            });
        }
        return convertView;
    }

    private class ViewHolder {
        private TextView name;
        private TextView description;
        private ImageView avatar;
    }
}
