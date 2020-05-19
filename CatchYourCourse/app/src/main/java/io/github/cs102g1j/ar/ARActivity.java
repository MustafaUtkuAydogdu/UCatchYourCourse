package io.github.cs102g1j.ar;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.FrameTime;
import com.google.ar.sceneform.Scene;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import java.util.function.Consumer;
import java.util.function.Function;

import io.github.cs102g1j.R;

public class ARActivity extends AppCompatActivity
{
   ArFragment arFragment;
   ModelRenderable andyRenderable;
   private boolean placed;

   @Override
   @SuppressWarnings( { "AndroidApiChecker", "FutureReturnValueIgnored" } )

   protected void onCreate( Bundle savedInstanceState )
   {
      super.onCreate( savedInstanceState );

      setContentView( R.layout.activity_ar );
      arFragment = (ArFragment) getSupportFragmentManager().findFragmentById( R.id.ux_fragment );

      ModelRenderable.builder()
                     .setSource( this, R.raw.andy )
                     .build()
                     .thenAccept( new Consumer<ModelRenderable>()
                     {
                        @Override
                        public void accept( ModelRenderable renderable )
                        {
                           andyRenderable = renderable;
                        }
                     } )
                     .exceptionally( new Function<Throwable, Void>()
                     {
                        @Override
                        public Void apply( Throwable throwable )
                        {
                           Toast toast = Toast.makeText( ARActivity.this,
                                                         "Unable to load pokemons",
                                                         Toast.LENGTH_LONG
                                                       );
                           toast.setGravity( Gravity.CENTER, 0, 0 );
                           toast.show();
                           return null;
                        }
                     } );

      arFragment.getArSceneView().getScene().addOnUpdateListener( new Scene.OnUpdateListener()
      {
         @Override
         public void onUpdate( FrameTime frameTime )
         {
            arFragment.onUpdate( frameTime );
            if ( !placed )
            {// Create the Anchor.
               placed = true;
               Anchor anchor = hitResult.createAnchor();
               AnchorNode anchorNode = new AnchorNode( anchor );
               anchorNode.setParent( arFragment.getArSceneView().getScene() );

               // Create the transformable andy and add it to the
               // anchor.
               TransformableNode
                  andy
                  = new TransformableNode( arFragment.getTransformationSystem() );
               andy.setParent( anchorNode );
               andy.setRenderable( andyRenderable );
               andy.select();
            }

         }
      } );


      arFragment.setOnTapArPlaneListener( new BaseArFragment.OnTapArPlaneListener()
      {
         @Override
         public void onTapPlane( HitResult hitResult, Plane plane, MotionEvent motionEvent
                               )
         {
            if ( andyRenderable == null )
            {
               return;
            }

            // Create the Anchor.
            Anchor anchor = hitResult.createAnchor();
            AnchorNode anchorNode = new AnchorNode( anchor );
            anchorNode.setParent( arFragment.getArSceneView().getScene() );

            // Create the transformable andy and add it to the
            // anchor.
            TransformableNode andy = new TransformableNode( arFragment.getTransformationSystem() );
            andy.setParent( anchorNode );
            andy.setRenderable( andyRenderable );
            andy.select();
         }
      } );
   }

}

