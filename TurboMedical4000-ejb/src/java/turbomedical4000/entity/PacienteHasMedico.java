/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sihame
 */
@Entity
@Table(name = "paciente_has_medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PacienteHasMedico.findAll", query = "SELECT p FROM PacienteHasMedico p"),
   
    @NamedQuery(name = "PacienteHasMedico.findByPacientenumSS", query = "SELECT p FROM PacienteHasMedico p WHERE p.pacienteHasMedicoPK.pacientenumSS = :pacientenumSS"),
    @NamedQuery(name = "PacienteHasMedico.findByMediconumColegiado", query = "SELECT p FROM PacienteHasMedico p WHERE p.pacienteHasMedicoPK.mediconumColegiado = :mediconumColegiado")})
public class PacienteHasMedico implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PacienteHasMedicoPK pacienteHasMedicoPK;
    @JoinColumn(name = "Paciente_numSS", referencedColumnName = "numSS", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paciente paciente;
    @JoinColumn(name = "Medico_numColegiado", referencedColumnName = "numColegiado", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medico medico;

    public PacienteHasMedico() {
    }

    public PacienteHasMedico(PacienteHasMedicoPK pacienteHasMedicoPK) {
        this.pacienteHasMedicoPK = pacienteHasMedicoPK;
    }

    public PacienteHasMedico(int pacientenumSS, int mediconumColegiado) {
        this.pacienteHasMedicoPK = new PacienteHasMedicoPK(pacientenumSS, mediconumColegiado);
    }

    public PacienteHasMedicoPK getPacienteHasMedicoPK() {
        return pacienteHasMedicoPK;
    }

    public void setPacienteHasMedicoPK(PacienteHasMedicoPK pacienteHasMedicoPK) {
        this.pacienteHasMedicoPK = pacienteHasMedicoPK;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacienteHasMedicoPK != null ? pacienteHasMedicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PacienteHasMedico)) {
            return false;
        }
        PacienteHasMedico other = (PacienteHasMedico) object;
        if ((this.pacienteHasMedicoPK == null && other.pacienteHasMedicoPK != null) || (this.pacienteHasMedicoPK != null && !this.pacienteHasMedicoPK.equals(other.pacienteHasMedicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbomedical4000.entity.PacienteHasMedico[ pacienteHasMedicoPK=" + pacienteHasMedicoPK + " ]";
    }
    
}
