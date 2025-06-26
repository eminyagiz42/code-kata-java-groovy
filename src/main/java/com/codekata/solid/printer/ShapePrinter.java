package com.codekata.solid.printer;

import com.codekata.solid.shape.Shape;

import java.util.List;

public class ShapePrinter {

    public  <T extends Shape> String toJson(List<T> shapes, List<Integer> areas) {
        StringBuilder builder = new StringBuilder();
        builder.append("{ ");
        for (int i = 0; i < shapes.size(); i++) {
            String shapeType = shapes.get(i).getClass().getSimpleName().replace("Shape", "");
            builder.append("\"")
                    .append(shapeType)
                    .append("\": ")
                    .append(areas.get(i));

            if (i < shapes.size() - 1) {
                builder.append(", ");
            }
        }
        return builder.append("}").toString();
    }
}
