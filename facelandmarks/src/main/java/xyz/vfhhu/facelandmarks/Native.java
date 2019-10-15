package xyz.vfhhu.facelandmarks;

import android.graphics.Rect;

public class Native {

    static {
        System.loadLibrary("native-facelandmarks");
    }
    public static void init(){};
    public static native String hellow();

    /** analise the raw captured frame from camera to find the face landmarks */
    public static long[] analiseFrame(byte[] yuv, int rotation, int width, int height, Rect region) {
//        Log.d("Native", "Rotation: " + rotation);

        return detectLandmarks(
                yuv, rotation, width, height,
                region.left, region.top, region.right, region.bottom
        );
    }

    /** load the specified landmark model (for dlib) */
    public static native void loadModel(final String path);
    public static native void setImageFormat(final int format);
    private static native long[] detectLandmarks(final byte[] yuv, int rotation, int width, int height, int left, int top, int right, int bottom);
}
