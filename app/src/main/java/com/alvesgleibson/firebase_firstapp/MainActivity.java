package com.alvesgleibson.firebase_firstapp;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.UUID;


public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button;
    private FirebaseAuth userAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imgPrinciapal);
        button = findViewById(R.id.btUploadImg);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Configurar imagem para ser salva na memoria
                imageView.setDrawingCacheEnabled(true);
                imageView.buildDrawingCache();

                // Recuperar o bitmap da imagem (imagem a ser carregada)
                Bitmap bitmap = imageView.getDrawingCache();

                //comprimir bitmap para formato jpeg/png
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 75, baos);

                //Converte o baos para pixel brutos em uma matriz de bytes
                //(dados da imagem)
                byte[] dadosImagem = baos.toByteArray();

                //Define nós para storage
                StorageReference reference = FirebaseStorage.getInstance().getReference();
                StorageReference imagens = reference.child("ImagesUpload");

                StorageReference referenceImagem = imagens.child("celular.jpg");

                referenceImagem.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Glide.with( MainActivity.this).load( uri ).into( imageView );
                        Toast.makeText(MainActivity.this,"Sucesso ao alterar.", Toast.LENGTH_LONG).show();
                    }
                });


            }
        });

    }



         /*
         //Deletar imagem no firebase

                referenceImagem.delete().addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(MainActivity.this, "Error delete image: " +
                                e.getMessage(), Toast.LENGTH_SHORT).show();


                    }
                }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        Toast.makeText(MainActivity.this, "Success Deleted image ", Toast.LENGTH_SHORT).show();
                    }


                });


            }});}

               */


                /*


                //nome Randon Image
                String fileName = UUID.randomUUID().toString();


                StorageReference referenceImagem = imagens.child(fileName+".jpg");

                //Retorno objeto que ira controlar o upload
                UploadTask uploadTask = referenceImagem.putBytes( dadosImagem );

                uploadTask.addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText( MainActivity.this, "Upload da imagem falhou error: "+e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        referenceImagem.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                            @Override
                            public void onComplete(@NonNull Task<Uri> task) {
                                Uri url = task.getResult();

                                Toast.makeText( MainActivity.this, "Success to upload " + url.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });



                    }
                });



            }
        });



    }


  */


        /* Buscar pelo index unico

        private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userFirebase = reference.child("User");

        DatabaseReference userSearch = userFirebase.child("-MgILJQzUHNCvVELMWMm");
         */

        /*Buscar pelo index name e o valor name Gleibson
          private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
          DatabaseReference userFirebase = reference.child("User");

          Query userSearch = userFirebase.orderByChild("name").equalTo("Gleibson");
        */


        /*Buscar os 3 Primeiros Resultados
         private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
         DatabaseReference userFirebase = reference.child("User");

         Query userSearch = userFirebase.limitToFirst( 3 );
        */

         /*Buscar os 3 ultimos Resultados

         private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
         DatabaseReference userFirebase = reference.child("User");

         Query userSearch = userFirebase.limitToLast( 3 );
        */

        /*Maoir ou iqual (>=)

        private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userFirebase = reference.child("User");

        Query userSearch = userFirebase.orderByChild( "age" ).startAt( 40 );

        */

        /*Menor ou iqual (<=)

        private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userFirebase = reference.child("User");

        Query userSearch = userFirebase.orderByChild( "age" ).endAt( 39 );
        */

        /*Entre dois valores

        private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userFirebase = reference.child("User");

        Query userSearch = userFirebase.orderByChild( "age" ).startAt(18).endAt( 30 );
        */



        /*Filtrar palavras que começa com...

        private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userFirebase = reference.child("User");


        Query userSearch = userFirebase.orderByChild( "lastname" ).startAt( "A" ).endAt( "A" + "\uf8ff" );


        userSearch.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                //User user = snapshot.getValue( User.class );
                //Log.i("ResultFirebase: ","\n\nName: "+ user.getName() + "\nAge: " +user.getAge()+"\nEat: " +user.getEat().getName());
                //Log.i("ResultFirebase: ", snapshot.getValue().toString());
                Log.i("ResultFirebase: ", snapshot.getValue().toString() );


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        */


        /*

        //Instaciar 2 usuarios Patricia e pamela e seta no firebase usando o indentificador único ( push() )
        Eat eat = new Eat();

        eat.setName("Pasta");
        eat.setQuantity("three portion");
        eat.setPrice(15.75);

        User user = new User();
        user.setName("Patricia");
        user.setLastname("Alencar");
        user.setAge(58);
        user.setProfession("Quarry");
        user.setEat( eat );

        userFirebase.push().setValue( user );



        eat.setName("Fermento");
        eat.setQuantity("seven portion");
        eat.setPrice(29.53);

        user.setName("Pamela");
        user.setLastname("Feitosa");
        user.setAge(29);
        user.setProfession("Hodman");
        user.setEat( eat );



        userFirebase.push().setValue( user );





        //Logging user

        private FirebaseAuth userAuth = FirebaseAuth.getInstance();

        userAuth.signInWithEmailAndPassword("alvesgleibson@gmail.com", "88710421")
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Log.i("CreateAuth", "User logged with success!!! ");
                                }else {
                                    Log.i("CreateAuth", "Problems to log in tho user!!! ");
                                }
                            }
                        });



        //SignOut user

        private FirebaseAuth userAuth = FirebaseAuth.getInstance();

        userAuth.signOut();



        //Check if user is logged

        private FirebaseAuth userAuth = FirebaseAuth.getInstance();

        if(userAuth.getCurrentUser() != null){
            Log.i("CreateAuth", "User is Logged!!!");

        }else {
            Log.i("CreateAuth", "User is not Logged!!!");
        }



        // Register to user
        private FirebaseAuth userAuth = FirebaseAuth.getInstance();


        userAuth.createUserWithEmailAndPassword("alvesgleibson@gmail.com", "88710421")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            Log.i("CreateAuth", "User create with success!!!");

                        }else {
                            Log.i("CreateAuth", "Problems for create the user");
                        }
                    }
                });


         #########Values retrieved in database Firebase (First we have to declare the reference);############

        private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();


        DatabaseReference userFirebase = reference.child("User");

        userFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                Log.i("FirebaseTest", snapshot.getValue().toString() );

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });


        ##############Save Values in Firebase (First we have to declare the Reference);#################

        private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        reference.child("Colors").child("Rainbow").setValue("Yellow");

        DatabaseReference rainbow = reference.child("Colors");

        rainbow.child("3 color").child("sea").setValue("White");



        Eat eat = new Eat();
        eat.setName("bread");
        eat.setQuantity("for unity");
        eat.setPrice(3.00);

        User user = new User();
        user.setName("Walner");
        user.setLastname("Silva");
        user.setAge(22);
        user.setProfession("Ceo");
        user.setEat( eat );


        DatabaseReference userFirebase = reference.child("User");
        userFirebase.child("003").setValue( user );


        //Identification unique using Push()

        Eat eat = new Eat();

        eat.setName("Octopus");
        eat.setQuantity("one portion");
        eat.setPrice(25.0);

        User user = new User();

        user.setName("Pedro");
        user.setLastname("Henrique");
        user.setAge(45);
        user.setProfession("Seller");
        user.setEat( eat );


        DatabaseReference userFirebase = reference.child("User");
        userFirebase.push().setValue( user );



        */

            }