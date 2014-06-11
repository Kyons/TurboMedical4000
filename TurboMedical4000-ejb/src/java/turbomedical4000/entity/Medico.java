/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turbomedical4000.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorge, juan
 */
@Entity
@Table(name = "medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m"),
    @NamedQuery(name = "Medico.findByNumColegiado", query = "SELECT m FROM Medico m WHERE m.numColegiado = :numColegiado"),
    @NamedQuery(name = "Medico.findByNombre", query = "SELECT m FROM Medico m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Medico.findByApellidos", query = "SELECT m FROM Medico m WHERE m.apellidos = :apellidos"),
    @NamedQuery(name = "Medico.findByFechaNac", query = "SELECT m FROM Medico m WHERE m.fechaNac = :fechaNac"),
    @NamedQuery(name = "Medico.findByDni", query = "SELECT m FROM Medico m WHERE m.dni = :dni"),
    @NamedQuery(name = "Medico.findByDireccion", query = "SELECT m FROM Medico m WHERE m.direccion = :direccion"),
    @NamedQuery(name = "Medico.findByLocalidad", query = "SELECT m FROM Medico m WHERE m.localidad = :localidad"),
    @NamedQuery(name = "Medico.findByProvincia", query = "SELECT m FROM Medico m WHERE m.provincia = :provincia"),
    @NamedQuery(name = "Medico.findByTelefono", query = "SELECT m FROM Medico m WHERE m.telefono = :telefono"),
    @NamedQuery(name = "Medico.findByContrasena", query = "SELECT m FROM Medico m WHERE m.contrasena = :contrasena")})
public class Medico implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mediconumColegiado")
    private Collection<Tratamiento> tratamientoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mediconumColegiado")
    private Collection<Formulariourgencia> formulariourgenciaCollection;
    @JoinTable(name = "paciente_has_medico", joinColumns = {
        @JoinColumn(name = "Medico_numColegiado", referencedColumnName = "numColegiado")}, inverseJoinColumns = {
        @JoinColumn(name = "Paciente_numSS", referencedColumnName = "numSS")})
    @ManyToMany
    private List<Paciente> pacienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medico")
    private Collection<PacienteHasMedico> pacienteHasMedicoCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numColegiado")
    private Integer numColegiado;
    @Size(max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "Apellidos")
    private String apellidos;
    @Column(name = "FechaNac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Size(max = 45)
    @Column(name = "Dni")
    private String dni;
    @Size(max = 45)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 45)
    @Column(name = "Localidad")
    private String localidad;
    @Size(max = 45)
    @Column(name = "Provincia")
    private String provincia;
    @Size(max = 45)
    @Column(name = "Telefono")
    private String telefono;
    @Size(max = 45)
    @Column(name = "Contrasena")
    private String contrasena;
    @ManyToMany(mappedBy = "medicoCollection")
    private Collection<Paciente> pacienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mediconumColegiado")
    private Collection<Cita> citaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mediconumColegiado")
    private Collection<Lineahistorial> lineahistorialCollection;
    @JoinColumn(name = "Especialidad_idEspecialidad", referencedColumnName = "idEspecialidad")
    @ManyToOne(optional = false)
    private Especialidad especialidadidEspecialidad;

    public Medico() {
    }

    public Medico(Integer numColegiado) {
        this.numColegiado = numColegiado;
    }

    public Integer getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(Integer numColegiado) {
        this.numColegiado = numColegiado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @XmlTransient
    public Collection<Paciente> getPacienteCollection() {
        return pacienteCollection;
    }

    public void setPacienteCollection(Collection<Paciente> pacienteCollection) {
        this.pacienteCollection = pacienteCollection;
    }

    @XmlTransient
    public Collection<Cita> getCitaCollection() {
        return citaCollection;
    }

    public void setCitaCollection(Collection<Cita> citaCollection) {
        this.citaCollection = citaCollection;
    }

    @XmlTransient
    public Collection<Lineahistorial> getLineahistorialCollection() {
        return lineahistorialCollection;
    }

    public void setLineahistorialCollection(Collection<Lineahistorial> lineahistorialCollection) {
        this.lineahistorialCollection = lineahistorialCollection;
    }

    public Especialidad getEspecialidadidEspecialidad() {
        return especialidadidEspecialidad;
    }

    public void setEspecialidadidEspecialidad(Especialidad especialidadidEspecialidad) {
        this.especialidadidEspecialidad = especialidadidEspecialidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numColegiado != null ? numColegiado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.numColegiado == null && other.numColegiado != null) || (this.numColegiado != null && !this.numColegiado.equals(other.numColegiado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbomedical4000.entity.Medico[ numColegiado=" + numColegiado + " ]";
    }

    @XmlTransient
    public Collection<PacienteHasMedico> getPacienteHasMedicoCollection() {
        return pacienteHasMedicoCollection;
    }

    public void setPacienteHasMedicoCollection(Collection<PacienteHasMedico> pacienteHasMedicoCollection) {
        this.pacienteHasMedicoCollection = pacienteHasMedicoCollection;
    }

    @XmlTransient
    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    @XmlTransient
    public Collection<Formulariourgencia> getFormulariourgenciaCollection() {
        return formulariourgenciaCollection;
    }

    public void setFormulariourgenciaCollection(Collection<Formulariourgencia> formulariourgenciaCollection) {
        this.formulariourgenciaCollection = formulariourgenciaCollection;
    }

    @XmlTransient
    public Collection<Tratamiento> getTratamientoCollection() {
        return tratamientoCollection;
    }

    public void setTratamientoCollection(Collection<Tratamiento> tratamientoCollection) {
        this.tratamientoCollection = tratamientoCollection;
    }
    
    
    
}
