package com.vph.vph.mapper;

import com.vph.vph.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author tcg
 * @date 2021/4/26
 */
@Mapper
@Component
public interface GetMapper {
    /**
     * cases
     *
     * @return cases
     */
    @Select("select * from cases")
    List<Case> getAllCases();

    /**
     * diseases
     *
     * @return diseases
     */
    @Select("select * from diseases")
    List<Disease> getAllDiseases();

    /**
     * infos
     *
     * @return infos
     */
    @Select("select * from infos")
    List<Info> getAllInfos();

    /**
     * offices
     *
     * @return offices
     */
    @Select("select * from offices")
    List<Office> getAllOffices();

    /**
     * problems
     *
     * @return problems
     */
    @Select("select * from problems")
    List<Problem> getAllProblems();
}
