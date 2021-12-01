package tl4.group14.tradingengine.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tl4.group14.tradingengine.model.Contract;
import tl4.group14.tradingengine.service.ContractService;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")

public class ContractController {
    private ContractService contractService;

    public ContractController(ContractService contractService) {
        super();
        this.contractService = contractService;
    }

    // build create contract REST API
    @PostMapping
    public ResponseEntity<Contract> saveContract(@RequestBody Contract contract){
        return new ResponseEntity<Contract>(contractService.saveContract(contract),HttpStatus.CREATED);

    }

    //build get all contract REST API
    @GetMapping
    public List<Contract> getAllContracts(){

        return contractService.getAllContracts();


    }

    // build get contract by id REST API
    // http://localhost:8080/api/contract/1
    @GetMapping("{conid}")
    public ResponseEntity<Contract> getContractById(@PathVariable("conid") long conid){
        return new ResponseEntity<Contract>(contractService.getContractById(conid),HttpStatus.OK);

    }

    // build update contract REST API
    // http://localhost:8080/api/contract/1
    @PutMapping("{conid}")
    public ResponseEntity<Contract> updateContract(@PathVariable("conid") long conid
            ,@RequestBody Contract contract){

        return new ResponseEntity<Contract>(contractService.updateContract(contract,conid),HttpStatus.OK);
    }

    //build delete contract  REST API
    // http://localhost:8080/api/contract/1
    @DeleteMapping("{conid}")
    public ResponseEntity<String> deleteContract(@PathVariable("conid") long conid) {
        //delete contract from DB
        contractService.deleteContract(conid);
        return new ResponseEntity<String>("contract deleted successfully!",HttpStatus.OK);

    }

}
