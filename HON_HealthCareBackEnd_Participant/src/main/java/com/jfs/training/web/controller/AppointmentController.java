package com.jfs.training.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jfs.training.bean.AppointmentBean;
import com.jfs.training.services.AppointmentService;
import com.jfs.training.services.PatientService;

/**
 * REST Controller for Appointment operations.
 * Spring Boot 2.7.3 compatible.
 * Designed to be consumed by React frontend.
 */
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // @Autowired
    // private PatientService patientService;

    /**
     * To-Do Item 3.0:
     * This method should handle HTTP GET request to fetch all appointments.
     *
     * NOTE:
     * This requirement should use REST controller and fetch data from service
     * layer.
     *
     * TODO:
     * --Invoke getAllAppointments() method of AppointmentService
     * --Return the fetched appointment list as JSON response
     * --Return HTTP status 200 (OK)
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<AppointmentBean>> listAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    /**
     * To-Do Item 3.1:
     * This method should save the appointment details submitted from the frontend.
     *
     * TODO:
     * --Map the URL to /save using POST method
     * --Retrieve AppointmentBean from request
     * --Perform validation checks using BindingResult
     * --If validation fails:
     * --Return validation errors with HTTP 400 (BAD_REQUEST)
     * --On successful validation:
     * --Fetch the associated PatientBean using patientId
     * --Set the patient in AppointmentBean
     * --Invoke saveAppointment() method of AppointmentService
     * --Return saved AppointmentBean with HTTP 201 (CREATED)
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveAppointment(
            @Valid AppointmentBean appointmentBean,
            BindingResult result) throws Exception {
                if (result.hasErrors()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getAllErrors());
                }

        appointmentService.saveAppointment(appointmentBean);
        return ResponseEntity.ok(null);
    }

    /**
     * Handles all uncaught exceptions.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception exception) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
}