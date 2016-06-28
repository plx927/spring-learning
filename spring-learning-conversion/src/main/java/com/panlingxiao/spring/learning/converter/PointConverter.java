package com.panlingxiao.spring.learning.converter;

import com.panlingxiao.spring.learning.domain.Point;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by panlingxiao on 2016/6/28.
 */
public class PointConverter implements Converter<String,Point> {
    @Override
    public Point convert(String source) {
        String[] splits = source.split(";");
        int x = Integer.parseInt(splits[0]);
        int y = Integer.parseInt(splits[1]);
        Point point = new Point();
        point.setX(x);
        point.setY(y);
        return point;
    }
}
