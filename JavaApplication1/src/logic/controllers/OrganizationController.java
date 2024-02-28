package logic.controllers;

import java.util.ArrayList;
import logic.classes.Account;
import logic.classes.AccountUser;
import logic.interfaces.IOrganizationController;
import logic.classes.Organization;
import logic.services.OrganizationService;
import logic.interfaces.IOrganizationController;

public class OrganizationController implements IOrganizationController {
    
    private static OrganizationController instance;
    private OrganizationService organizationService;
    
    public OrganizationController(){
        this.organizationService = new OrganizationService();
    }
    
    public static OrganizationController getInstance() {
        if(instance == null){
            instance = new OrganizationController();
        }
        return instance;
    }
    
    public Organization getOrganizationByAccountId(String accountId) {
        return this.organizationService.getOrganizationByAccountId(accountId);
    }
    
    public Organization getOrganizationByDebtTransactionId(String transactionid) {
        return this.organizationService.getOrganizationByDebtTransactionId(transactionid);
    }
    
    public ArrayList<AccountUser> getAccountAndUserDetails(String organizationId) {
        return this.organizationService.getAccountAndUserDetails(organizationId);
    }
    
    public Organization getOrganizationById(String id) {
        return this.organizationService.getOrganizationById(id);
    }
    
    public ArrayList<Organization> listOrganiztions(){
        return this.organizationService.getAllOrganization();
    }
    
    public ArrayList<Organization> getAllOrganizationsById(int ownerId){
        return this.organizationService.getAllOrganizationsById(ownerId);
    }
    
    public String getOrganizationDescriptionById(int orgId){
        return this.organizationService.getOrganizationDescriptionById(orgId);
    }
    
    public void createOrganizaation (String name, String description, boolean isPublic, String password, String city, String address){
        this.organizationService.createOrganizations(name, description, isPublic, password, city, address);
    }
    
    public ArrayList<Organization> listAllOrganizations(){
        return this.organizationService.listAllOrganizations();
    }
    

}
