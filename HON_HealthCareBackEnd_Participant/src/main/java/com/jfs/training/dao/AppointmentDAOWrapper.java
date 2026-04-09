package com.jfs.training.dao;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jfs.training.bean.AppointmentBean;
import com.jfs.training.bean.PatientBean;
import com.jfs.training.entity.AppointmentEntity;
import com.jfs.training.entity.PatientEntity;

@Repository
public class AppointmentDAOWrapper {
	@Autowired
	private AppointmentDAO appointmentDAO;

	@Autowired
	private PatientDAO patientDAO;

	/**
	 * To-Do Item 1.7: This method should add new appointment details to the
	 * database. NOTE: This requirement needs to be implemented using Spring Data
	 * JPA.
	 * 
	 * TODO:
	 * --Fetch patient ID from incoming AppointmentBean
	 * --Invoke Method findById()of PatientDAO to fetch patient details from
	 * database.
	 * If patient not found, throw exception with proper message
	 * --Convert AppointmentBean to AppointmentEntity(Hint: Utilize provided utility
	 * methods)
	 * --Set patient to appointment entity (Many-to-One relationship)
	 * --Invoke save method of AppointmentDAO to store appointment details
	 * --Convert saved AppointmentEntity back to AppointmentBean(Hint: Utilize
	 * provided utility methods)
	 * --Return the saved appointment details
	 */

	public AppointmentBean addAppointment(AppointmentBean bean) {
		PatientEntity patient = null;
		AppointmentEntity appointmentEntity = null;
		// Write code here..
		if (bean == null || bean.getPatient().getPatientId() == null) {
			throw new IllegalArgumentException("appointment or patient data is missing");
		}
		appointmentEntity = convertAppointmentBeanToEntity(bean);
		PatientBean patientBean = bean.getPatient();
		Optional<PatientEntity> queryResult = patientDAO.findById(patientBean.getPatientId());
		if (!queryResult.isPresent()) {
			throw new NoSuchElementException("Patient not found with id :" + patientBean.getPatientId());
		}
		patient = queryResult.get();
		appointmentEntity.setPatient(patient);
		AppointmentEntity savedAppointment = appointmentDAO.save(appointmentEntity);
		return convertAppointmentEntityToBean(savedAppointment);
	}

	/**
	 * To-Do Item 1.8: This method should fetch all appointment details from the
	 * database.
	 * NOTE: This requirement needs to be implemented using Spring Data JPA.
	 * 
	 * TODO:
	 * --Invoke findAll() method of AppointmentDAO to get all appointment entities
	 * --Check if the returned list is empty, handle appropriately
	 * --Convert each AppointmentEntity to AppointmentBean (Hint: Utilize provided
	 * utility methods)
	 * --Store all converted beans into a list
	 * --Handle null values safely during conversion
	 * --Return the list of AppointmentBean objects
	 */
	public List<AppointmentBean> getAllPatients() {
		List<AppointmentEntity> queryResult = appointmentDAO.findAll();
		return queryResult.stream().map(this::convertAppointmentEntityToBean).collect(Collectors.toList());
	}

	/* Convert AppointmentEntity to AppointmentBean */

	private AppointmentBean convertAppointmentEntityToBean(AppointmentEntity appointmentEntity2) {
		AppointmentBean bean = new AppointmentBean();
		BeanUtils.copyProperties(appointmentEntity2, bean);
		// Manually copy patient name
		if (appointmentEntity2.getPatient() != null) {
			PatientBean patientBean = new PatientBean();
			BeanUtils.copyProperties(appointmentEntity2.getPatient(), patientBean);
			bean.setPatient(patientBean);

		}
		return bean;
	}

	/* Convert AppointmentBean to AppointmentEntity. */
	private AppointmentEntity convertAppointmentBeanToEntity(AppointmentBean bean) {
		AppointmentEntity appointmentEntity = new AppointmentEntity();
		BeanUtils.copyProperties(bean, appointmentEntity);
		return appointmentEntity;
	}

}
