package com.search.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.search.fragment.FragmentPopularSearch;
import com.search.fragment.FragmentSearchHistoryList;
import com.search.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SearchEventActivity extends AppCompatActivity{
    @Bind(R.id.seach_edit_text) EditText searchEditText;

    private final static int POPULAR_SEARCH = 0x001;
    private final static int SEARCH_CONTENT = 0x002;

    FragmentPopularSearch popularSearchFragment = new FragmentPopularSearch();
    FragmentSearchHistoryList historyListFragment = new FragmentSearchHistoryList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_event);
        ButterKnife.bind(this);
        searchEditText.clearFocus();
        getFragmentManager().beginTransaction().replace(R.id.fragment_layout,popularSearchFragment).commit();
        setLayout();
    }

    private void setLayout(){

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        searchEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b){
                    switchFragment(SEARCH_CONTENT);
                }
            }
        });

        searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
                    searchAction();
                    return true;
                }
                return false;
            }
        });
    }

    private void searchAction(){

    }

    public void switchFragment(int state){
        switch (state){
            case POPULAR_SEARCH:
                getFragmentManager().beginTransaction().replace(R.id.fragment_layout,popularSearchFragment).commit();
                break;
            case SEARCH_CONTENT:
                getFragmentManager().beginTransaction().replace(R.id.fragment_layout,historyListFragment).commit();
                break;
            default:
                break;
        }
    }
}
