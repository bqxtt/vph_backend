package com.vph.vph.service;

import com.vph.vph.entity.*;
import com.vph.vph.mapper.GetMapper;
import com.vph.vph.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author tcg
 * @date 2021/4/26
 */
@Service
public class GetService {

    @Autowired
    GetMapper getMapper;

    public Result getAllCases() {
        Result result;
        try {
            List<Case> cases = getMapper.getAllCases();
            Map<String, Object> data = new HashMap<>(1);
            Map<String, List<Case>> inner = new HashMap<>(cases.size());
            for (Case ca : cases) {
                if (!inner.containsKey(ca.getCategory())) {
                    inner.put(ca.getCategory(), new ArrayList<>());
                }
                List<Case> list = inner.get(ca.getCategory());
                list.add(ca);
            }
            data.put("data", inner);
            result = Result.retOk(data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    public Result getAllDiseases() {
        Result result;
        try {
            List<Disease> diseases = getMapper.getAllDiseases();
            Map<String, Object> data = new HashMap<>(1);
            Map<String, List<Disease>> inner = new HashMap<>(diseases.size());
            for (Disease disease : diseases) {
                if (!inner.containsKey(disease.getCategory())) {
                    inner.put(disease.getCategory(), new ArrayList<>());
                }
                inner.get(disease.getCategory()).add(disease);
            }
            data.put("data", inner);
            result = Result.retOk(data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    public Result getAllInfos() {
        Result result;
        try {
            List<Info> infos = getMapper.getAllInfos();
            Map<String, Object> data = new HashMap<>(1);
            data.put("data", infos);
            result = Result.retOk(data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    public Result getAllOffices() {
        Result result;
        try {
            List<Office> offices = getMapper.getAllOffices();
            Map<String, Object> data = new HashMap<>(1);
            data.put("data", offices);
            result = Result.retOk(data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    public Result getTest() {
        Result result;
        try {
            List<Problem> problems = getMapper.getAllProblems();
            Collections.shuffle(problems);
            List<Problem> ret = new ArrayList<>();
            for (int i = 0; i < 10 && i < problems.size(); ++i) {
                problems.get(i).setScore(10);
                ret.add(problems.get(i));
            }
            Map<String, Object> data = new HashMap<>(1);
            Test test = new Test();
            test.setScore(100);
            test.setTime(30);
            test.setProblems(ret);
            data.put("data", test);
            result = Result.retOk(data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }
}
