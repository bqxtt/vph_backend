package com.vph.vph.entity;

import lombok.Data;

import java.util.List;

/**
 * @author tcg
 * @date 2021/4/26
 */
@Data
public class CaseWrapper {
    private String category;
    private List<Case> cases;
}
