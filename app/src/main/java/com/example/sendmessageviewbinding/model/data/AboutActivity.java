package com.example.sendmessageviewbinding.model.data;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import androidx.activity.result.IntentSenderRequest;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

import com.danielstone.materialaboutlibrary.MaterialAboutActivity;
import com.danielstone.materialaboutlibrary.items.MaterialAboutActionItem;
import com.danielstone.materialaboutlibrary.items.MaterialAboutItemOnClickAction;
import com.danielstone.materialaboutlibrary.items.MaterialAboutTitleItem;
import com.danielstone.materialaboutlibrary.model.MaterialAboutCard;
import com.danielstone.materialaboutlibrary.model.MaterialAboutList;


import com.example.sendmessageviewbinding.R;

public class AboutActivity extends MaterialAboutActivity {
 @NonNull
 @Override
 protected MaterialAboutList getMaterialAboutList(@NonNull Context context) {

  MaterialAboutCard.Builder card = new MaterialAboutCard.Builder();
  card.addItem(new MaterialAboutTitleItem.Builder()
          .text(R.string.menu_napp)
          .icon(R.mipmap.ic_launcher)
          .build());

  MaterialAboutCard.Builder cardautor = new MaterialAboutCard.Builder();
  cardautor.title(R.string.menu_nautor);
  cardautor.addItem(new MaterialAboutActionItem.Builder()
          .text(R.string.menu_nombre)
          .subText(R.string.menu_nmodulo)
          .icon(R.drawable.ic_autor)
          .build());

  cardautor.addItem(new MaterialAboutActionItem.Builder()
          .text(R.string.menu_gh)
          .subText(R.string.menu_ghnombre)
          .icon(R.drawable.ic_github)
          .setOnClickAction(new MaterialAboutItemOnClickAction() {
           @Override
           public void onClick() {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/nikitenkokatya"));
            startActivity(intent);
           }
          })
          .build());

     MaterialAboutCard.Builder cardversion = new MaterialAboutCard.Builder();
     cardversion.addItem(new MaterialAboutActionItem.Builder()
             .text(R.string.menu_version)
             .subText("1.0.0")
             .icon(R.drawable.ic_version)
             .build());


  return new MaterialAboutList.Builder()
          .addCard(card.build())
          .addCard(cardautor.build())
          .addCard(cardversion.build())
          .build();
 }


 @Override
 protected CharSequence getActivityTitle() {
  return getString(R.string.menu_about);
 }

}
