package com.vph.vph.entity;

import lombok.Data;

import java.util.List;

/**
 * @author tcg
 * @date 2021/4/26
 */
@Data
public class Test {
    private String title;
    private Integer time;
    private Integer score;
    private List<Problem> problems;

    public Integer getScore() {
        Integer total = 0;
        if (problems == null || problems.size() == 0) {
            return 0;
        }
        for (Problem problem : problems) {
            if (problem.getScore() != null) {
                total += problem.getScore();
            }
        }
        return total;
    }
}
