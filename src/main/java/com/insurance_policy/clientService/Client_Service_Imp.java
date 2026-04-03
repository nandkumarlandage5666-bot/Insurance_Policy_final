package com.insurance_policy.clientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance_policy.API_ExpectionHandler.ResourceNotFoundException;
import com.insurance_policy.clientRepository.ClientRepository;

import com.insurance_policy.dto.Client_dto;
import com.insurance_policy.model.Address;
import com.insurance_policy.model.Client;
import com.insurance_policy.model.InsurancePolicy;
import com.insurance_policy.policyRepository.InsurancePolicyRepository;
@Service
public class Client_Service_Imp implements Client_Service {
	@Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InsurancePolicyRepository policyRepository;

    private Client mapDtoToEntity(Client_dto dto) {
        Client client = new Client();
        client.setName(dto.getName());
        client.setDob(dto.getDob());
        client.setPhoneNo(dto.getPhoneNo());

        client.setAddress(dto.getAddress()); // @Embedded handles this automatically

        // Map policies if provided
        if (dto.getPolicy_No() != null) {
            List<InsurancePolicy> policies = dto.getPolicy_No().stream()
                .map(id -> policyRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Policy not found: " + id)))
                .toList();
            client.setPolicy(policies);
        }

        return client;
    }

    private Client_dto mapEntityToDto(Client client) {
        Client_dto dto = new Client_dto();
        dto.setName(client.getName());
        dto.setDob(client.getDob());
        dto.setPhoneNo(client.getPhoneNo());
        dto.setAddress(client.getAddress());

        if (client.getPolicy() != null) {
            List<Integer> policyIds = client.getPolicy().stream()
                .map(InsurancePolicy::getPolicy_No)
                .toList();
            dto.setPolicy_No(policyIds);
        }

        return dto;
    }

    @Override
    public Client_dto saveClient(Client_dto dto) {
        Client client = mapDtoToEntity(dto);
        Client saved = clientRepository.save(client);
        return mapEntityToDto(saved);
    }

    @Override
    public List<Client_dto> getAllClient() {
        return clientRepository.findAll().stream()
            .map(this::mapEntityToDto)
            .toList();
    }

    @Override
    public Client_dto getClientById(Long id) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Client not found: " + id));
        return mapEntityToDto(client);
    }

    @Override
    public Client_dto updateClientById(Long id, Client_dto dto) {
        Client existing = clientRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Client not found: " + id));

        Client updated = mapDtoToEntity(dto);
        updated.setClient_No(existing.getClient_No()); // maintain ID
        return mapEntityToDto(clientRepository.save(updated));
    }

    @Override
    public String deleteClientById(Long id) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Client not found: " + id));
        clientRepository.delete(client);
        return "Client deleted successfully";
    }
}
