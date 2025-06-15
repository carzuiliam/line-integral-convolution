
# Line Integral Convolution (LIC) in Java

This project is an implementation of the **Line Integral Convolution (LIC)** algorithm for flow visualization, written entirely in Java. The LIC technique is widely used for visualizing vector fields, generating high-quality textures that represent the flow direction in the field.

## Introduction

**LIC** is a method for visualizing vector fields by convolving a noise texture along streamlines of the field. This creates streak-like patterns that intuitively represent the direction and structure of the flow [1].

The basic workflow of this project includes:

- **Input Texture:** You can provide an input image (JPG, grayscale recommended). If not provided, the system will automatically generate a white noise texture.
- **Vector Field Synthesis:** The implementation supports multiple vector field types:
    - **SADDLE** (hyperbolic flow)
    - **CENTER** (circular flow)
    - **SOURCE** (radial outward flow)
    - **SINK** (radial inward flow)
    - **SPIRAL_SOURCE** (spiral outward flow)
    - **SPIRAL_SINK** (spiral inward flow)
- **Line Integral Convolution:** Applies the LIC algorithm to the chosen vector field and input texture, generating a smooth streaked texture that visually represents the flow.
- **Output Image:** The resulting image is saved as a JPG file.

## Usage Instructions

### Requirements

- **Java 8** or newer;
- No external dependencies (pure Java, uses standard libraries).

### How to Run

1. Clone this repository.

2. Place any input image (JPG format) in the `src/main/resources` folder if you want to use a custom texture.

3. Example usage in Java:

```java
public class Main {
    public static void main(String[] args) throws IOException {
        LICBuilder builder = new LICBuilder()
                .setFlowFieldType(FlowField.Type.SADDLE) // Select vector field type
                .setSquareFlowFieldSize(400)             // Used if no input image is provided
                .setDiscreteFilterSize(2048)
                .setLowPassFilterLength(10.0f)
                .setLineSquareClipMax(100000.0f)
                .setVectorComponentMinimum(0.05f);                

        // Optional input image (must be located in resources)
        // builder.setInputImage("lena.jpg"); // Uncomment to use a custom input image

        builder.generate("lic_output.jpg");
    }
}
```

4. Output images are saved in the folder: `target/output/`.

### Supported Vector Fields

You can select the vector field type with:

```java
builder.setFlowFieldType(FlowField.Type.TYPE);
```

Available types:

| Type           | Description                          |
|----------------|------------------------------------|
| **SADDLE**     | Hyperbolic flow (saddle point)     |
| **CENTER**     | Circular flow around the center    |
| **SOURCE**     | Radial outward flow                 |
| **SINK**       | Radial inward flow                  |
| **SPIRAL_SOURCE** | Spiral outward flow              |
| **SPIRAL_SINK**   | Spiral inward flow               |

## Project Structure

- `LICBuilder.java` — Main class to configure and run the LIC algorithm.
- `FlowField.java` — Defines vector field types and generation methods.
- `Vector2D.java` — Simple 2D vector class with normalization.
- `Main.java` — Example entry point.

## Notes

- Only **JPG format** is supported for input and output images.
- Input images are expected to be in **grayscale**; if not, the program converts them by extracting the red channel.

## License

The available source codes here are under the Apache License, version 2.0 (see the attached `LICENSE` file for more details). Any questions can be submitted to my email: carloswilldecarvalho@outlook.com.

## References

[1] B. Cabral and L. Leedom, *"Imaging Vector Fields Using Line Integral Convolution"*, Proceedings of SIGGRAPH '93.

