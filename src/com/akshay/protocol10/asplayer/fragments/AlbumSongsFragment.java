package com.akshay.protocol10.asplayer.fragments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.akshay.protocol10.asplayer.R;
import com.akshay.protocol10.asplayer.adapters.TrackAdapters;
import com.akshay.protocol10.asplayer.callbacks.onItemSelected;
import com.akshay.protocol10.asplayer.database.MediaManager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class AlbumSongsFragment extends Fragment implements OnItemClickListener {

	List<HashMap<String, Object>> albums_media;
	MediaManager manager;
	TrackAdapters adapters;
	View view;
	ListView albums_media_view;

	onItemSelected mcallback;

	public AlbumSongsFragment() {
		// TODO Auto-generated constructor stub
		albums_media = new ArrayList<HashMap<String, Object>>();
		manager = new MediaManager();
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Bundle args = getArguments();
		if (args != null) {
			String name = args.getString("name");
			Toast.makeText(getActivity(), name + "a", Toast.LENGTH_LONG).show();
			albums_media = manager.retriveContent(getActivity(), name);
			Toast.makeText(getActivity(),
					name + " size " + albums_media.size(), Toast.LENGTH_SHORT)
					.show();
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_tracks, container, false);
		albums_media_view = (ListView) view.findViewById(R.id.tracks_view);
		adapters = new TrackAdapters(getActivity(), R.layout.fragment_tracks,
				R.id.title_text_view, albums_media);
		albums_media_view.setAdapter(adapters);
		albums_media_view.setOnItemClickListener(this);
		return view;
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		mcallback = (onItemSelected) getActivity();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub

	}

}
