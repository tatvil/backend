package es.tatvil.backend.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate fecha; // Para el tipo DATE de MariaDB
    private String ciudad;
    private LocalTime amanecer; // Para el tipo TIME
    private LocalTime anochecer;
    
    @Column(name = "temp_min")
    private Integer tempMin;
    
    @Column(name = "temp_max")
    private Integer tempMax;
    
    private Integer humedad;
    
    @Column(name = "viento_velocidad")
    private Integer vientoVelocidad;
    
    @Column(name = "viento_direccion")
    private Integer vientoDireccion;
    
    private Integer nubes;
    private Integer lluvia;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public LocalTime getAmanecer() {
		return amanecer;
	}
	public void setAmanecer(LocalTime amanecer) {
		this.amanecer = amanecer;
	}
	public LocalTime getAnochecer() {
		return anochecer;
	}
	public void setAnochecer(LocalTime anochecer) {
		this.anochecer = anochecer;
	}
	public Integer getTempMin() {
		return tempMin;
	}
	public void setTempMin(Integer tempMin) {
		this.tempMin = tempMin;
	}
	public Integer getTempMax() {
		return tempMax;
	}
	public void setTempMax(Integer tempMax) {
		this.tempMax = tempMax;
	}
	public Integer getHumedad() {
		return humedad;
	}
	public void setHumedad(Integer humedad) {
		this.humedad = humedad;
	}
	public Integer getVientoVelocidad() {
		return vientoVelocidad;
	}
	public void setVientoVelocidad(Integer vientoVelocidad) {
		this.vientoVelocidad = vientoVelocidad;
	}
	public Integer getVientoDireccion() {
		return vientoDireccion;
	}
	public void setVientoDireccion(Integer vientoDireccion) {
		this.vientoDireccion = vientoDireccion;
	}
	public Integer getNubes() {
		return nubes;
	}
	public void setNubes(Integer nubes) {
		this.nubes = nubes;
	}
	public Integer getLluvia() {
		return lluvia;
	}
	public void setLluvia(Integer lluvia) {
		this.lluvia = lluvia;
	}
	@Override
	public int hashCode() {
		return Objects.hash(amanecer, anochecer, ciudad, fecha, humedad, id, lluvia, nubes, tempMax, tempMin,
				vientoDireccion, vientoVelocidad);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weather other = (Weather) obj;
		return Objects.equals(amanecer, other.amanecer) && Objects.equals(anochecer, other.anochecer)
				&& Objects.equals(ciudad, other.ciudad) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(humedad, other.humedad) && Objects.equals(id, other.id)
				&& Objects.equals(lluvia, other.lluvia) && Objects.equals(nubes, other.nubes)
				&& Objects.equals(tempMax, other.tempMax) && Objects.equals(tempMin, other.tempMin)
				&& Objects.equals(vientoDireccion, other.vientoDireccion)
				&& Objects.equals(vientoVelocidad, other.vientoVelocidad);
	}
	@Override
	public String toString() {
		return "Weather [id=" + id + ", fecha=" + fecha + ", ciudad=" + ciudad + ", amanecer=" + amanecer
				+ ", anochecer=" + anochecer + ", tempMin=" + tempMin + ", tempMax=" + tempMax + ", humedad=" + humedad
				+ ", vientoVelocidad=" + vientoVelocidad + ", vientoDireccion=" + vientoDireccion + ", nubes=" + nubes
				+ ", lluvia=" + lluvia + "]";
	}


}
