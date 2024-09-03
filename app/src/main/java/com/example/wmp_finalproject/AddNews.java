package com.example.wmp_finalproject;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Map;

public class AddNews extends AppCompatActivity {

    private EditText newsTitleEdt, newsArticleEdt;
    private Button submitNewsBtn;
    private String newsTitle, newsArticle;
    private StorageReference storageReference;
    private FirebaseFirestore db;
    private ActivityResultLauncher<String> pickMediaLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_add);

        db = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference().child("images");

        newsTitleEdt = findViewById(R.id.idEdtNewsTitle);
        newsArticleEdt = findViewById(R.id.idEdtNewsArticle);
        submitNewsBtn = findViewById(R.id.idBtnSubmitNews);

        pickMediaLauncher = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                uri -> {
                    if (uri != null) {
                        Log.d("PhotoPicker", "Selected URI: " + uri);
                        UploadImage(uri);
                    } else {
                        Log.d("PhotoPicker", "No media selected");
                    }
                }
        );

        submitNewsBtn.setOnClickListener(v -> {
            newsTitle = newsTitleEdt.getText().toString();
            newsArticle = newsArticleEdt.getText().toString();

            if (TextUtils.isEmpty(newsTitle)) {
                newsTitleEdt.setError("Please enter News Title");
            } else if (TextUtils.isEmpty(newsArticle)) {
                newsArticleEdt.setError("Please enter News Article");
            } else {
                // Launch the photo picker and let the user choose images.
                pickMediaLauncher.launch(String.valueOf(Uri.parse("image/*")));
            }
        });
    }

    public void UploadImage(Uri imageUri) {
        StorageReference imageRef = storageReference.child("image.jpg");

        UploadTask uploadTask = imageRef.putFile(imageUri);

        uploadTask.addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                imageRef.getDownloadUrl().addOnSuccessListener(downloadUri -> {
                    String imageUrl = downloadUri.toString();
                    saveNewsToFirestore(imageUrl);
                });
            } else {
                Exception exception = task.getException();
                Toast.makeText(AddNews.this, "Failed to upload image: " + exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveNewsToFirestore(String imageUrl) {
        CollectionReference newsCollection = db.collection("NewsInformation");

        Map<String, Object> newsData = new HashMap<>();
        newsData.put("title", newsTitle);
        newsData.put("article", newsArticle);
        newsData.put("imageUrl", imageUrl);

        newsCollection.add(newsData)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(AddNews.this, "News added successfully", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(AddNews.this, "Failed to add news: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }
}
