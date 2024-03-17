package com.example.saityalcin.enums;

import lombok.Getter;

@Getter
public enum EnumCommentPoint {
    ONE_STAR(1),
    TWO_STAR(2),
    THREE_STAR(3),
    FOUR_STAR(4),
    FIVE_STAR(5);

    private final int point;
    EnumCommentPoint(int point){
        this.point = point;
    }
}
