package com.panlingxiao.spring.learning.propertyeditor;

import com.panlingxiao.spring.learning.domain.Point;

import java.beans.PropertyEditorSupport;

/**
 * Created by panlingxiao on 2016/6/28.
 */
public class PointEditor extends PropertyEditorSupport{
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] splits = text.split(";");
        int x = Integer.parseInt(splits[0]);
        int y = Integer.parseInt(splits[1]);
        Point point = new Point();
        point.setX(x);
        point.setY(y);
        setValue(point);
    }
}
