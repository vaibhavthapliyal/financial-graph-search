package com.financegraph.application.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.financegraph.application.entity.Node;


@Repository
public interface NodeRepository extends CrudRepository<Node, Integer> {

	Optional<Node> findByNodeId(String nodeId);
}
