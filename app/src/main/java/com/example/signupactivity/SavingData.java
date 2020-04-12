package com.example.signupactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.File;

public  class SavingData extends AppCompatActivity{

    private static final int PICK_IMAGE_REQUEST = 1;

    private EditText address;
    private EditText contactno;
    private EditText hostelname;
    private ImageView hostelimage;
    private ProgressBar progressBar;
    private Button addhostel;
    private Button chooseimg;
    private Uri imageuri;
    FirebaseAuth mFirebaseAuth;
    private StorageReference storageReference;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_data);

        address = findViewById(R.id.editTextAddress);
        contactno = findViewById(R.id.editTextContact);
        hostelname = findViewById(R.id.editTextHostelName);
        hostelimage = findViewById(R.id.imageView2);
        chooseimg = findViewById(R.id.chooseimage);
        addhostel = findViewById(R.id.buttonaddHostel);
        progressBar = findViewById(R.id.progress);

        storageReference = FirebaseStorage.getInstance().getReference("uploads");
        databaseReference = FirebaseDatabase.getInstance().getReference("uploads");

        chooseimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileChooser();
            }
        });

        addhostel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadFile();
            }
        });

        mFirebaseAuth = FirebaseAuth.getInstance();

        if (mFirebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, MainPage.class));
        }


    }

    private void openFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
        && data!= null && data.getData() != null){
            imageuri = data.getData();

            Picasso.get().load(imageuri).into(hostelimage);
        }
    }

    private String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }
    File file = new File(String.valueOf(imageuri));
    private void uploadFile(){
        if(imageuri != null){
            StorageReference fileReference = storageReference.child(System.currentTimeMillis()
            + "." + getFileExtension(imageuri));

            fileReference.child(file.getName()).putFile(imageuri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(0);
                                }
                            }, 500);
                            Toast.makeText(SavingData.this, "Upload successful", Toast.LENGTH_LONG).show();
                            Upload upload = new Upload(hostelname.getText().toString().trim(),
                                    contactno.getText().toString().trim(), address.getText().toString().trim(),
                                    taskSnapshot.getStorage().getDownloadUrl().toString());
                            String uploadId = databaseReference.push().getKey();
                            databaseReference.child(uploadId).setValue(upload);

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(SavingData.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            progressBar.setProgress((int)progress);
                        }
                    });
        }else {
            Toast.makeText(this, "No file selected", Toast.LENGTH_SHORT).show();
        }
    }


}


