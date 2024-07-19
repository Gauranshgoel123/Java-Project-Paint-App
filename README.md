# Java-Project-Paint-App

## Paint Applet

## Overview

The Paint Applet is a simple drawing application built using Java Swing. It allows users to draw shapes on a canvas by clicking and dragging the mouse, and it includes buttons to change the drawing color. The applet maintains a list of drawn shapes and displays them on the screen.

## Features

- Draw shapes by clicking and dragging the mouse.
- Change drawing color using buttons.
- Maintains a history of drawn shapes and displays them.

## Installation

1. Ensure you have Java Development Kit (JDK) installed.
2. Clone or download the project files to your local machine.

## Usage

1. Navigate to the project directory.
2. Compile the project using the following command:
   ```bash
   javac PaintApplet.java
   ```
3. Run the project with the command:
   ```bash
   java PaintApplet
   ```

## Code Structure

- `PaintApplet` class extends `JPanel` and serves as the main panel for drawing.
- `Shape` class is a nested class within `PaintApplet`, representing individual shapes drawn on the canvas.

### Components

- **Mouse Listeners**: 
  - `MouseAdapter` for capturing mouse press and release events.
  - `MouseMotionAdapter` for capturing mouse drag events.

- **Color Buttons**: 
  - Three buttons to change the current drawing color to black, red, or blue.

- **Shape Class**:
  - Manages the points and color of a shape.
  - Methods to add points, retrieve point arrays, and get the number of points.

## How It Works

1. When the user presses the mouse button, a new `Shape` object is created, and the first point is added.
2. As the user drags the mouse, points are continuously added to the current shape.
3. When the user releases the mouse button, the shape is finalized and added to the list of shapes.
4. The `paintComponent` method iterates through the list of shapes and draws each one on the canvas.

## Customization

- **Adding More Colors**: 
  - Create new `JButton` instances for each color.
  - Add an `ActionListener` to each button to call `setCurrentColor` with the desired `Color`.

- **Changing Canvas Size**:
  - Modify the `frame.setSize` method in the `main` method to set the desired width and height.

## License

This project is licensed under the MIT License.

## Acknowledgments

This project was developed as a part of a Java coursework during my 2nd year of B.Tech.

---

![image](https://github.com/user-attachments/assets/46c1dfa4-af32-46f3-a2f4-2fd456416680)
