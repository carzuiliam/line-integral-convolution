package org.carzuiliam.lic;

public class LICUtils {

    public enum FlowFieldType {
        SADDLE,
        CIRCULAR,
        RADIAL,
        SINE
    }

    public static void generateFlowField(int width, int height, float[] vectors, FlowFieldType type) {
        float cx = (width - 1) / 2.0f;
        float cy = (height - 1) / 2.0f;

        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                int index = (j * width + i) * 2;
                float x = i - cx;
                float y = j - cy;

                switch (type) {
                    case SADDLE:
                        vectors[index] = -((j / (float) (height - 1)) - 0.5f);
                        vectors[index + 1] = (i / (float) (width - 1)) - 0.5f;
                        break;

                    case CIRCULAR:
                        vectors[index] = -y;
                        vectors[index + 1] = x;
                        break;

                    case RADIAL:
                        vectors[index] = x;
                        vectors[index + 1] = y;
                        break;

                    case SINE:
                        vectors[index] = (float) Math.sin(y * 0.05f);
                        vectors[index + 1] = (float) Math.cos(x * 0.05f);
                        break;
                }
            }
        }
    }
}
