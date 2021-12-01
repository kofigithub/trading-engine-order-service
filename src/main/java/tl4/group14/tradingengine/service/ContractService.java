package tl4.group14.tradingengine.service;

import tl4.group14.tradingengine.model.Contract;


import java.util.List;

public interface ContractService {
    Contract saveContract(Contract contract);
    List<Contract> getAllContracts();
    Contract getContractById(long conid);
    Contract updateContract(Contract Contract, long conid);
    void deleteContract(long conid);
}
