package com.delazeri.clock.controllers;

import com.delazeri.clock.dtos.ContractDTO;
import com.delazeri.clock.entities.Contract;
import com.delazeri.clock.services.ContractService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @PostMapping(value = "/{userId}")
    public ResponseEntity<Contract> addContractToUser(@PathVariable UUID userId, @ResponseBody @Valid ContractDTO) {
        return new ResponseEntity<>();
    }
}
