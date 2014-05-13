/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sihame
 */
@Embeddable
public class PacienteHasMedicoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Paciente_numSS")
    private int pacientenumSS;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Medico_numColegiado")
    private int mediconumColegiado;

    public PacienteHasMedicoPK() {
    }

    public PacienteHasMedicoPK(int pacientenumSS, int mediconumColegiado) {
        this.pacientenumSS = pacientenumSS;
        this.mediconumColegiado = mediconumColegiado;
    }

    public int getPacientenumSS() {
        return pacientenumSS;
    }

    public void setPacientenumSS(int pacientenumSS) {
        this.pacientenumSS = pacientenumSS;
    }

    public int getMediconumColegiado() {
        return mediconumColegiado;
    }

    public void setMediconumColegiado(int mediconumColegiado) {
        this.mediconumColegiado = mediconumColegiado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pacientenumSS;
        hash += (int) mediconumColegiado;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PacienteHasMedicoPK)) {
            return false;
        }
        PacienteHasMedicoPK other = (PacienteHasMedicoPK) object;
        if (this.pacientenumSS != other.pacientenumSS) {
            return false;
        }
        if (this.mediconumColegiado != other.mediconumColegiado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbomedical4000.entity.PacienteHasMedicoPK[ pacientenumSS=" + pacientenumSS + ", mediconumColegiado=" + mediconumColegiado + " ]";
    }
    
}
