
package Anini;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.Interpolator;

public class test extends  JComponent{
  public void setinter(inter inter){
      animation.setInterpolator(new Interpolator() {
          @Override
          public float interpolate(float f) {
              return inter.inter(f);
          }
      });
  }
    private Animator animation;
    private float animate;
    
    public test(){
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
                animate = fraction;
                repaint();
            }
            
        };
        animation = new Animator(2000, target);
        animation.setResolution(0);
        
    }
    public void start(){
        if(!animation.isRunning()){
            animation.start();
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D gg = (Graphics2D) g;
        gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int size = 70;
        double width = getWidth() - size;
        gg.setColor(getBackground());
        gg.fillOval((int)(animate * width), 0, size, size);
        super.paint(g); 
        
    }


    
}
