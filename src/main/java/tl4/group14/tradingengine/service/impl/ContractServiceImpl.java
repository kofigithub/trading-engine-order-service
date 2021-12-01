package tl4.group14.tradingengine.service.impl;

import org.springframework.stereotype.Service;
import tl4.group14.tradingengine.exception.ResourceNotFoundException;
import tl4.group14.tradingengine.model.Contract;
import tl4.group14.tradingengine.repository.ContractRepository;
import tl4.group14.tradingengine.service.ContractService;


import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {


    private ContractRepository contractRepository;


    //@Autowire
    public ContractServiceImpl(ContractRepository contractRepository) {
        super();
        this.contractRepository = contractRepository;
    }



    @Override
    public Contract saveContract(Contract contract) {
        return contractRepository.save(contract);
    }



    @Override
    public List<Contract> getAllContracts() {
        return  contractRepository.findAll();
    }



    @Override
    public Contract getContractById(long conid) {
//		Optional<Contract> contract = contractRepository.findById(id);
//		if(contract.isPresent()) {
//		return contract.get();
//
//		}
//		else {
//			throw new ResourceNotFoundException("Employee","Id", id);
        //}

        return contractRepository.findById(conid).orElseThrow(() -> new ResourceNotFoundException("Contract", "Id", conid));


    }



    @Override
    public Contract updateContract(Contract contract, long conid) {
        // we need to check whether employee with given id exists in DB or not
        Contract existingContract = contractRepository.findById(conid).orElseThrow(() -> new ResourceNotFoundException("Contract", "Id", conid));
        existingContract.setOrderType(contract.getOrderType());
        existingContract.setTicker(contract.getTicker());
        existingContract.setMultiplier(contract.getMultiplier());
        // save existing employee to DB
        contractRepository.save(existingContract);
        return existingContract;




    }



    @Override
    public void deleteContract(long conid) {
        // check whether contract with given id exists in DB or not
        contractRepository.findById(conid).orElseThrow(() ->
                new ResourceNotFoundException("Contract", "Id", conid));
        contractRepository.deleteById(conid);

    }



}

