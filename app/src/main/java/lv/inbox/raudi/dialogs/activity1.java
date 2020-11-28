package lv.inbox.raudi.dialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String> selectedItems = new ArrayList<>();
        final String [] groupMembers = getResources().getStringArray(R.array.groupMembers);

        Button dialogs = (Button) findViewById(R.id.btnToDialog);
        dialogs.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        AlertDialog.Builder alerBuilder = new AlertDialog.Builder(activity1.this);
                        alerBuilder.setTitle(getString(R.string.dialogName))
                                .setMultiChoiceItems(groupMembers, null, new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        if (isChecked){
                                            selectedItems.add(groupMembers[which]);
                                            Toast.makeText (activity1.this, String.format(getString(R.string.toastAppear), getFirstName(groupMembers[which])),Toast.LENGTH_SHORT).show();
                                        } else {
                                            selectedItems.remove(groupMembers[which]);
                                            Toast.makeText (activity1.this, String.format(getString(R.string.toastDisapear),getFirstName(groupMembers[which])),Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                })
                                .setPositiveButton(getString(R.string.dialogBtnOK), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText (activity1.this, String.format(getString(R.string.button),getString(R.string.dialogBtnOK) ),Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .setNegativeButton(getString(R.string.dialogBtnClose), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText (activity1.this, String.format(getString(R.string.button),getString(R.string.dialogBtnClose) ),Toast.LENGTH_SHORT).show();
                                    }
                                });
                        alerBuilder.show();
                    }
        }
        );

        Button aktivitate2 = (Button) findViewById(R.id.btnToA2);
        aktivitate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a2Starter = new Intent(activity1.this, activity2.class);
                startActivity(a2Starter);
            }
        });
    }

    public String getFirstName (String fullName) {
        String name = (fullName.split(" "))[0];
        return name;
    }
}
