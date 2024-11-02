package com.prueba.tecnica.devintech.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.prueba.tecnica.devintech.dto.PermisosXRol;
import com.prueba.tecnica.devintech.entity.login;

@Repository
@Transactional
public interface AutenticationRepository extends JpaRepository<login, Long> {
	
	Page<login> findAll(Pageable pageable);

	UserDetails findByUsername(String username);
	
	@Query("SELECT new com.prueba.tecnica.devintech.dto.PermisosXRol(p.id AS permission_id,p.screen_name,p.url) " +
	           "FROM users u JOIN rol r ON u.rol = r.id \r\n"
	           + "JOIN rol_permissions rp ON r.id = rp.rol_id \r\n"
	           + "JOIN permissions p ON rp.permissions_id = p.id \r\n"
	           + "WHERE u.email =:email")
	    List<PermisosXRol> permissionxrol(@Param("email") String email);

}
