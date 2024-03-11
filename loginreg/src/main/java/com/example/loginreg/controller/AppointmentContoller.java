package com.example.loginreg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loginreg.dto.AppointmentDTO;
import com.example.loginreg.service.AppointmentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/appointment")
public class AppointmentContoller {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/create")
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        AppointmentDTO createdAppointment = appointmentService.createAppointment(appointmentDTO);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }

    @GetMapping("/viewall")
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
        List<AppointmentDTO> appointments = appointmentService.getAllAppointments();
        if (appointments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @PutMapping("/{appointmentId}/update")
    public ResponseEntity<String> updateAppointmentDetails(@PathVariable String appointmentId,
                                                   @RequestBody AppointmentDTO updatedAppointment) {
    appointmentService.updateAppointmentDetails(appointmentId, updatedAppointment);
    return new ResponseEntity<>("Appointment details updated successfully", HttpStatus.OK);
}

    @PutMapping("/{appointmentId}/cancel")
    public ResponseEntity<String> cancelAppointment(@PathVariable String appointmentId) {
        appointmentService.cancelAppointment(appointmentId);
        return new ResponseEntity<>("Appointment canceled successfully", HttpStatus.OK);
    }

    
}
