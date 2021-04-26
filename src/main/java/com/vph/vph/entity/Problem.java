package com.vph.vph.entity;

import lombok.Data;

/**
 * @author tcg
 * @date 2021/4/26
 */
@Data
public class Problem {
    private Integer id;
    private String rol;
    private String problem;
    private String answer;
    private String correct;
    private Integer score;
}
