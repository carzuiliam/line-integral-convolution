# Line Integral Convolution (LIC) in Java

This project is an implementation of the **Line Integral Convolution (LIC)** algorithm for flow visualization, written entirely in Java. The LIC technique is widely used for visualizing vector fields, generating high-quality textures that represent the flow direction in the field.

## Introduction

**LIC** is a method for visualizing vector fields by convolving a noise texture along streamlines of the field. This creates streak-like patterns that intuitively represent the direction and structure of the flow [1].

The basic workflow of this project includes:

- **Input Texture:** You can provide an input image (JPG, grayscale recommended). If not provided, the system will automatically generate a white noise texture.
- **Vector Field Synthesis:** The current implementation supports different types of vector fields, like *saddle (hyperbolic)*, *circular*, *radial*, and *sine wave patterns*.
- **Line Integral Convolution:** Applies the LIC algorithm to the chosen vector field and texture, generating a smooth streaked texture that visually represents the flow.
- **Output Image:** The resulting image is saved as a JPG file.

## Usage Instructions

### Requirements

- **Java 8** or newer
- No external dependencies required (pure Java, uses standard libraries)

### How to Run

1. Clone this repository.

2. Place any input image (JPG format) in the `src/main/resources` folder if you want to use a custom texture.

3. Example usage in Java:

```java
public class Main {
    public static void main(String[] args) throws IOException {
        LICBuilder builder = new LICBuilder()
                .setSquareFlowFieldSize(500)             // Only used if no input image is provided
                .setDiscreteFilterSize(2048)
                .setLowPassFilterLength(10.0f)
                .setLineSquareClipMax(100000.0f)
                .setVectorComponentMinimum(0.05f)
                .setFlowFieldType(LICUtils.FlowFieldType.CIRCULAR); // <- Selects the vector field type

        // Optional input image (must be located in resources)
        builder.setInputImage("lena.jpg"); // Comment this line to use white noise

        builder.generate("lic_output.jpg");
    }
}
```

4. Output images are saved in the folder: `target/output/`.

### Supported Vector Fields

You can choose the vector field type by setting:

```java
builder.setFlowFieldType(LICUtils.FlowFieldType.TYPE);
```

Available types:

| Type        | Description                          |
|--------------|--------------------------------------|
| **SADDLE**   | Hyperbolic flow (saddle point)       |
| **CIRCULAR** | Circular flow around the center      |
| **RADIAL**   | Radial (expanding from the center)   |
| **SINE**     | Wavy flow with sinusoidal pattern    |

## Project Structure

- `LICBuilder.java` — Main class to configure and run the LIC algorithm.
- `LICUtils.java` — Utility class containing vector field definitions and other helpers.
- `Main.java` — Example execution.

## Notes

- Only **JPG format** is supported for input and output images (for now).
- Input images are expected to be in **grayscale**, but if not, the program will automatically convert them by extracting the red channel as grayscale.

## License

The available source codes here are under the Apache License, version 2.0 (see the attached `LICENSE` file for more details). Any questions can be submitted to my email: carloswdecarvalho@outlook.com.

## References

[1] B. Cabral and L. Leedom, *"Imaging Vector Fields Using Line Integral Convolution"*, Proceedings of SIGGRAPH '93.
