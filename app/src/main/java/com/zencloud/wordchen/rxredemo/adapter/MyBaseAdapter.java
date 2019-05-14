package com.zencloud.wordchen.rxredemo.adapter;


import android.content.Context;
import android.widget.BaseAdapter;
import com.zencloud.wordchen.rxredemo.entity.Mike;

import java.util.List;

public abstract class MyBaseAdapter extends BaseAdapter {
		private List<Mike> categorybean;
		private Context context;

		public MyBaseAdapter(List<Mike> categorybean, Context context) {
			this.categorybean = categorybean;
			this.context=context;
		}

		@Override
		public int getCount() {
			return categorybean == null ? 0:categorybean.size();
		}

		@Override
		public Object getItem(int i) {
			return categorybean.get(i);
		}

		@Override
		public long getItemId(int i) {
			return i;
		}

		public List<Mike> getData() {
			return categorybean;
		}
	}

