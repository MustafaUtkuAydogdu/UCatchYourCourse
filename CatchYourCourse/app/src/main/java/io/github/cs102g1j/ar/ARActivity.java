package io.github.cs102g1j.ar;
// Videoyu tersten çek
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.ar.core.Anchor;
import com.google.ar.core.Frame;
import com.google.ar.core.Pose;
import com.google.ar.core.TrackingState;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.FrameTime;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import java.util.function.Consumer;
import java.util.function.Function;

import io.github.cs102g1j.R;

public class ARActivity extends AppCompatActivity
{
   ArFragment arFragment;
   ModelRenderable andyRenderable;
   boolean placed = false;

   @Override
   @SuppressWarnings( { "AndroidApiChecker", "FutureReturnValueIgnored" } )
   // CompletableFuture requires api level 24
   // FutureReturnValueIgnored is not valid
   protected void onCreate( Bundle savedInstanceState )
   {
      super.onCreate( savedInstanceState );


      setContentView( R.layout.activity_ar );
      arFragment = (ArFragment) getSupportFragmentManager().findFragmentById( R.id.ux_fragment );

      // When you build a Renderable, Sceneform loads its resources in the background while
      // returning
      // a CompletableFuture. Call thenAccept(), handle(), or check isDone() before calling get().
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
                                                         "Unable to load any pokemons",
                                                         Toast.LENGTH_LONG
                                                       );
                           toast.setGravity( Gravity.CENTER, 0, 0 );
                           toast.show();
                           return null;
                        }
                     } );


      arFragment.getArSceneView().getScene().addOnUpdateListener( this::onUpdateFrame );

   }

   private void onUpdateFrame( FrameTime frameTime )
   {
      Frame frame = arFragment.getArSceneView().getArFrame();

      // If there is no frame, just return.
      if ( frame == null )
      {
         return;
      }

      //Making sure ARCore is tracking some feature points, makes the augmentation little stable.
      if ( frame.getCamera().getTrackingState() == TrackingState.TRACKING && !placed )
      {

         Pose pos = frame.getCamera().getPose().compose( Pose.makeTranslation( 0, 0, -0.3f ) );
         Anchor anchor = arFragment.getArSceneView().getSession().createAnchor( pos );
         AnchorNode anchorNode = new AnchorNode( anchor );
         anchorNode.setParent( arFragment.getArSceneView().getScene() );

         // Create the arrow node and add it to the anchor.
         placed = true; //to place the arrow just once.
         // anchor.
         TransformableNode andy = new TransformableNode( arFragment.getTransformationSystem() );
         andy.setParent( anchorNode );
         andy.setRenderable( andyRenderable );
         andy.select();

      }

   }

}

