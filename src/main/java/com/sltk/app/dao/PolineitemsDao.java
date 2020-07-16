package com.sltk.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sltk.app.model.Polineitems;

@Repository
public interface PolineitemsDao extends JpaRepository<Polineitems, Long>{

	@Query(value="SELECT a FROM Polineitems a WHERE a.ponumber.ponumber = ?1 AND a.poLineId = ?2")
	public Polineitems getPoLineItems (Long ponumber, int poLineId);
}
