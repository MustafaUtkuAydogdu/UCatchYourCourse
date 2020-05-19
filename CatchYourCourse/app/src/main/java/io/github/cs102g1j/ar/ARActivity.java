package io.github.cs102g1j.ar;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.ar.core.Anchor;
import com.google.ar.core.Frame;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.core.Pose;
import com.google.ar.core.Trackable;
import com.google.ar.core.TrackingState;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.FrameTime;
import com.google.ar.sceneform.HitTestResult;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.Scene;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;

import java.util.function.Consumer;
import java.util.function.Function;

import io.github.cs102g1j.R;

public class ARActivity extends AppCompatActivity implements Scene.OnUpdateListener
{
   ArFragment arFragment;
   ModelRenderable andyRenderable;

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
   }

   private Node getModel()
   {
      Node node = new Node();
      node.setRenderable( andyRenderable );
      Context cont = this;
      node.setOnTapListener( new Node.OnTapListener()
      {
         @Override
         public void onTap( HitTestResult v, MotionEvent event
                          )
         {
            Toast.makeText( cont, "Model was touched", Toast.LENGTH_LONG )   // Toast?, toast!
                 .show();
         }
      } );
      return node;
   }

   @Override
   public void onUpdate( FrameTime frameTime )
   {
      Frame frame = arFragment.getArSceneView().getArFrame();
      if ( frame == null )
      {
         return;
      }
      if ( frame.getCamera().getTrackingState() != TrackingState.TRACKING )
      {
         return;
      }
      for ( Plane plane : frame.getUpdatedTrackables( Plane.class ) )
      {
         arFragment.getPlaneDiscoveryController().hide();
         if ( plane.getTrackingState() == TrackingState.TRACKING )
         {
            for ( HitResult hit : frame.hitTest( findViewById( android.R.id.content ).getWidth() /
                                                 2f,
                                                 findViewById( android.R.id.content ).getHeight() /
                                                 2f
                                               ) )
            {
               Trackable trackable = hit.getTrackable();
               if ( trackable instanceof Plane &&
                    ( (Plane) trackable ).isPoseInPolygon( hit.getHitPose() ) )
               {
                  Anchor anchor = hit.createAnchor();
                  AnchorNode anchorNode = new AnchorNode( anchor );
                  anchorNode.setParent( arFragment.getArSceneView().getScene() );
                  Pose pose = hit.getHitPose();
                  Node node = new Node();
                  node.setRenderable( andyRenderable );
                  node.setLocalPosition( new Vector3( pose.tx(),
                                                      pose.compose( Pose.makeTranslation( 0.0f,
                                                                                          0.05f,
                                                                                          0.0f
                                                                                        ) ).ty(),
                                                      pose.tz()
                  ) );
                  node.setParent( anchorNode );
               }
            }
         }
      }
   }
}

