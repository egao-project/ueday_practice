package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import com.example.demo.model.Weapon;

public class WeaponRepositoryCustomImpl implements WeaponRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Weapon> searchWeapons(String keyword, String matchType, List<String> fields) {
		// TODO 自動生成されたメソッド・スタブ
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Weapon> query = cb.createQuery(Weapon.class);
		Root<Weapon> weapon = query.from(Weapon.class);

		List<Predicate> predicates = new ArrayList<>();

		if (fields != null && !fields.isEmpty() && keyword != null && !keyword.isBlank()) {
			for (String field : fields) {
				Path<String> path = weapon.get(field);

				if ("exact".equals(matchType)) {
					predicates.add(cb.equal(path, keyword));
				} else {
					predicates.add(cb.like(path, "%" + keyword + "%"));
				}
			}
			// OR 条件をまとめる
			query.where(cb.or(predicates.toArray(new Predicate[0])));
		}

		return em.createQuery(query).getResultList();
	}

}
