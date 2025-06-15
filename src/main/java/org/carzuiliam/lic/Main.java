package org.carzuiliam.lic;

import org.carzuiliam.lic.builder.LICBuilder;
import org.carzuiliam.lic.utils.FlowField;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LICBuilder builder = new LICBuilder()
                //.setInputImage("lena.jpg")
                .setFlowFieldType(FlowField.Type.SADDLE)
                .setSquareFlowFieldSize(400)
                .setDiscreteFilterSize(2048)
                .setLowPassFilterLength(10.0f)
                .setLineSquareClipMax(100000.0f)
                .setVectorComponentMinimum(0.05f);

        builder.generate("lic.jpg");
    }
}
