package com.mkdev.weatherlady.repository;

import com.mkdev.weatherlady.model.CurrentCondition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CurrentConditionRepository extends CrudRepository {

    List<CurrentCondition> findCurrentConditionByCity(String city);

    List<CurrentCondition> findCurrentConditionByTemperatureGreaterThan(Float temperature);

    @Query(value = "SELECT c FROM current_condition c WHERE c.windDirection >= :lowerDegree AND c.windDirection <= :higherDegree")
    List<CurrentCondition> selectAllConditionsWithDegreesBetween(
            @Param("lowerDegree") Integer lowerDegree,
            @Param("higherDegree") Integer higherDegree
    );
}
