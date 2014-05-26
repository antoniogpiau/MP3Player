package com.example.mp3player;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

public class ShowDetailDialogFragment extends DialogFragment {
 private String text;

 public static DialogFragment getInstance(String text) {
  ShowDetailDialogFragment frag = new ShowDetailDialogFragment();
  frag.setText(text);
  return frag;
 }

 @Override
 public Dialog onCreateDialog(Bundle savedInstanceState) {

  AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
  builder.setMessage(this.getText());
  // Create the AlertDialog object and return it
  return builder.create();
 }

 public String getText() {
  return text;
 }

 public void setText(String text) {
  this.text = text;
 }

}