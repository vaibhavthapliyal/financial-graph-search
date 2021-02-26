package com.financegraph.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

import com.financegraph.application.entity.Edge;

@RestController
public interface EdgeRepository extends CrudRepository<Edge, Integer> {

}
