package com.siifo.siifo.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "tipoIdentificacion", nullable = true, columnDefinition = "VARCHAR(45)")
    private String tipoIdentificacion;

    @Column(name = "numeroIdentificacion", nullable = true, columnDefinition = "VARCHAR(10)")
    private String numeroIdentificacion;

    @Column(name = "nombreUsario", nullable = true, columnDefinition = "VARCHAR(45)")
    private String nombreUsuario;
    
    @Column(name = "apellidoUsuario", nullable = true, columnDefinition = "VARCHAR(45)")
    private String apellidoUsuario;

    @Column(name = "numeroUsuario", nullable = true, columnDefinition = "VARCHAR(15)")
    private String numeroUsuario;

    //-----------------------Campos de login------------------------------------------------- 

    @Column(name = "correoUsuario", nullable = true, columnDefinition = "VARCHAR(200)")
    private String username;

    @Column(name = "contrasenaUsuario", nullable = true, columnDefinition = "VARCHAR(45)")
    private String password;
    //enabled es para cuando la sesion este abierta o cerrada, es decir true o false
    @Column
	private boolean enabled;

    //----------------------------Union con las tablas: rol y authorities-----------------------------------------------------------
    // la tabla authority es lo mismo que la tabla de rol, solo que authority es la tabla que encuentra por defecto spring security

    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "authorities_users", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
	private Set<Authority> Authority;

	//
    ////@ManyToOne
    ///@JoinColumn(name = "rol_idRol")
    ///private Rol rol;

    // public boolean isEnabled() {
	// 	return enabled;
	// }

	// public void setEnabled(boolean enabled) {
	// 	this.enabled = enabled;
	// }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", correoUsuario=" + username + ", contrasenaUsuario=" + password + "]";
	}

	
}
