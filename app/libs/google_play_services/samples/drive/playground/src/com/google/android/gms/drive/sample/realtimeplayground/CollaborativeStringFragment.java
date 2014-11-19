package com.google.android.gms.drive.sample.realtimeplayground;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.gms.drive.realtime.CollaborativeString;
import com.google.android.gms.drive.realtime.CollaborativeStringBinding;
import com.google.android.gms.drive.realtime.RealtimeDocument;

/**
 * A fragment that displays the sample CollaborativeString.
 */
public class CollaborativeStringFragment extends PlaygroundFragment {
    private EditText mCollabStringEditText;
    private RealtimeDocument mRealtimeDocument;
    private CollaborativeString mCollaborativeString;
    private CollaborativeStringBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        Log.d("TAG", "onCreateView string");
        View view = inflater.inflate(R.layout.fragment_collaborative_string, container, false);
        mCollabStringEditText = (EditText) view.findViewById(R.id.collabStringEditText);
        disableViewUntilLoaded(mCollabStringEditText);
        return view;
    }

    @Override
    public String getTitle() {
        return "Collaborative String";
    }

    @Override
    void onLoaded(RealtimeDocument document) {
        Log.d("TAG", "onLoaded string");
        mRealtimeDocument = document;
        mCollaborativeString =
                (CollaborativeString) mRealtimeDocument.getModel().getRoot().get(
                        PlaygroundDocumentActivity.COLLAB_STRING_NAME);
        mBinding = new CollaborativeStringBinding(mCollaborativeString, mCollabStringEditText);
        mBinding.bind();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mBinding != null) {
            mBinding.unbind();
        }
    }
}
